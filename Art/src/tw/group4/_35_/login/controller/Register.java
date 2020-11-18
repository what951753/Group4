package tw.group4._35_.login.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.time.LocalDate;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.group4._35_.login.model.WebsiteMember;
import tw.group4._35_.login.model.WebsiteMemberService;
import tw.group4._35_.util.GlobalService;
import tw.group4.util.IdentityFilter;

@Controller
public class Register {
	
	@Autowired
	private ServletContext ctx;
	
	public static String regexPwd = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,}$";
	public static String regexTel = "(\\d{2,3}-?|\\(\\d{2,3}\\))\\d{3,4}-?\\d{4}|09\\d{2}(\\d{6}|-\\d{3}-\\d{3})";
	public static String regexEmail = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
	
	@Autowired
	private WebsiteMemberService wmService;
	
//	單純轉跳頁面要用GetMapping
	@GetMapping("/35/registerEntry")
	public String registerEntry(Model m) {
		WebsiteMember member = new WebsiteMember();
		m.addAttribute("member", member);
		return IdentityFilter.loginID+"35/login/register";
	}
	
//	表單綁定一定要記得傳入BindingResult，即使沒用到，否則會400 Bad Request
	@PostMapping("/35/registerCheck.ctrl")
	public String registerCheck(@RequestParam("memberPic") MultipartFile mFile, @RequestParam("passwordAuth") String passwordAuth, @ModelAttribute("member") WebsiteMember member, BindingResult result, Model m, ServletRequest request) throws IOException{
		
		String name = member.getName();
		String password = member.getPassword();
		String email = member.getEmail();
		String tel = member.getTel();
		
		if(name.equals("")||password.equals("")||email.equals("")||tel.equals("")) {
			m.addAttribute("errMsg", "姓名、密碼、E-mail和電話為必填");
			return IdentityFilter.loginID+"35/login/register";
		}else if(!password.matches(regexPwd)) {
			m.addAttribute("errMsg", "密碼須包含至少一個大、小寫英文字母、數字、特殊符號，且八位數以上");
			return IdentityFilter.loginID+"35/login/register";
		}else if(!member.getPassword().equals(passwordAuth)) {
			m.addAttribute("errMsg", "密碼二次驗證失敗，請確認密碼無誤");
			return IdentityFilter.loginID+"35/login/register";
		}else if(!tel.matches(regexTel)) {
			m.addAttribute("errMsg", "電話格式錯誤");
			return IdentityFilter.loginID+"35/login/register";
		}else if(!email.matches(regexEmail)) {
			m.addAttribute("errMsg", "Email格式錯誤");
			return IdentityFilter.loginID+"35/login/register";
		}else if(wmService.checkNameExsist(name)) {
			m.addAttribute("errMsg", "會員名稱已被使用");
			return IdentityFilter.loginID+"35/login/register";
		}
		
//		執行到這代表綁定表單輸入資料ok
//		加入名稱和歡迎用語，等等返回註冊成功頁面
		m.addAttribute("welcome", name+"，註冊成功，祝您有個得藝的一天");
		
//		如果mFile值為空代表使用者沒上傳照片，這時候塞預設圖片給使用者
		Blob blob = null;
		if(mFile.isEmpty()) {
			try {
//				先輸入為BufferedImage (image)
				FileInputStream fis = new FileInputStream(ctx.getRealPath("/WEB-INF/IOFiles/inputJPG/memberDefault.JPG"));
				BufferedImage image = ImageIO.read(fis);
//				再把BufferedImage轉為ByteArrayOutputStream (baos)
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(image, "jpg", baos);
//				ByteArrayOutputStream轉ByteArray (ba)
				byte[] ba = baos.toByteArray();
//	 			convert Byte array to Blob using SerialBlob() method
				blob = new SerialBlob(ba);
			} catch (Exception e) {
				e.printStackTrace();
			}
//		若非空就塞mFile圖片
		}else {
			try {
//			MultipartFile轉ByteArray
//			ByteArray再轉Blob
				blob = new SerialBlob(mFile.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LocalDate now = LocalDate.now();
		
//		加密使用者密碼再存進資料庫
		String passwordEncoded = GlobalService.getMD5Endocing(
				GlobalService.encryptString(member.getPassword()));
		
		WebsiteMember wmBean = new WebsiteMember(member.getName(), passwordEncoded, member.getAddress(), 
												 member.getEmail(), member.getTel(), "user", blob, "", now, 10000.0);
		wmService.insert(wmBean);
		
//		註冊成功後同時也要登入，所以叫出session來放attribute "member"
		HttpServletRequest httpReq = (HttpServletRequest) request;	
		HttpSession session = httpReq.getSession();
		session.setAttribute("member", wmBean);

//		把mFile的byte[]叫出來
		byte[] memberPicByteArray = mFile.getBytes();
        String encodedString = Base64.encodeBase64String(memberPicByteArray);
		session.setAttribute("memberPic", encodedString);
		
//		下列方法是存webapp設定的路徑，再存資料庫
////		取得上傳原始檔案的名稱
//		String fileName = mfile.getOriginalFilename();
////		取得上傳圖片要暫存的路徑
//		String fileTempDirPath = ctx.getRealPath("/")+"uploadTempDir\\";
//		
//		System.out.println("fileName:"+fileName);
//		System.out.println("fileTempDirPath:"+fileTempDirPath);
//		
////		new File()內是資料夾路徑，回傳產生的就是File型態(資料夾)物件
////		new FileInputStream()內是檔案路徑，產生的是資料流型態檔案物件
//		File dirFile = new File(fileTempDirPath);
//		if(!dirFile.exists()) {
////			mkdirs建立file前面幾層的資料夾，mkdir則是只建立一層
//			boolean status = dirFile.mkdirs();
//			System.out.println("dirFile.mkdirs的結果:"+status);
//		}
//		
////		new File()內是檔案路徑，回傳產生的就是File型態(檔案)物件
//		String fileSavePath = fileTempDirPath + fileName;
//		System.out.println("fileSavePath:"+fileSavePath);
//		File jpegFile = new File(fileSavePath);
//		mfile.transferTo(jpegFile);
//
////		確認有上傳到檔案，再執行存資料庫的動作
//		if(fileName!=null && fileName.length()!=0) {
//			service.saveMemberPic(fileName, fileSavePath);
//		}
//		
////		HttpHeaders headers = new HttpHeaders();
////		headers.setContentType(MediaType.IMAGE_JPEG);
//		
//		需要直接回傳ResponseBody到前端頁面顯示圖片，才需要下行
//		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);
//		方法結束
		
		return "redirect:/35/registerOkLogin";
	}
	
//	多轉跳一次控制器，會再重新送出request
//	這時候過濾器才能驗證身份為會員，而非訪客
	@GetMapping("/35/registerOkLogin")
	public String registerOkLogin(@ModelAttribute("welcome") String welcome){
		
		return IdentityFilter.loginID+"35/login/registerSuccess";
	}
}
