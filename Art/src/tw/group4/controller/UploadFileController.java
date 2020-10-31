package tw.group4.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.group4.model.PictureService;

@Controller
public class UploadFileController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PictureService pService;
	
	@RequestMapping(path = "/fileUploadEntry.controller", method = RequestMethod.GET)
	public String processEntryFormPage() {
		return "uploadFile";
	}
	
	@RequestMapping(path = "/fileUploadAction.controller", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<byte[]> idldentification(@RequestParam("myFiles") MultipartFile mfile) throws IOException {
		
		String fileName = mfile.getOriginalFilename();
//		取得存檔路徑
		String fileTempDirPath = request.getSession().getServletContext().getRealPath("/")+"uploadTempDir\\";
		
		System.out.println("fileName:"+fileName);
		System.out.println("fileTempDirPath:"+fileTempDirPath);
		
		File dirPath = new File(fileTempDirPath);
		if(!dirPath.exists()) {
			boolean status = dirPath.mkdirs();
			System.out.println("status:"+status);
		}
		
		String fileSavePath = fileTempDirPath + fileName;
		File saveFile = new File(fileSavePath);
		mfile.transferTo(saveFile);
		System.out.println("fileSavePath:"+fileSavePath);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		
		if(fileName!=null && fileName.length()!=0) {
			pService.savePicture(fileName, fileSavePath);
		}
		
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);
	}

}
