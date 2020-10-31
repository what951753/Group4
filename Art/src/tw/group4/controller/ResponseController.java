package tw.group4.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@RequestMapping(path = "/responseBodyMessage.controller", method = RequestMethod.GET)
	public @ResponseBody String processResponseBody() {
		return "This message is from responseBody.";
	}
	
	@RequestMapping(path = "/responseBodyCharset.controller", method = RequestMethod.GET)
	public @ResponseBody String processResponseBodyCharset() {
		return "This Message is From responseBody Charset(中文).";
	}
	
//	這邊設定的是response編碼
//	filter過濾的是request編碼
	@RequestMapping(path = "/responseBodyCharset2.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String processResponseBodyCharset2() {
		return "This Message is From responseBody Charset2(中文).";
	}
	
	@RequestMapping(path = "/responseStatusCode.controller", method = RequestMethod.GET)
	public ResponseEntity<String> processResponseStatusCode() {
		return new ResponseEntity<String>("Forbidden(403)", HttpStatus.FORBIDDEN);
	}
	
	//之前範例是使用者送出要求
	//使用者沒有要求，但是伺服器直接送出回應內含圖片出來view
	@RequestMapping(path = "/responseImage.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public void processResponseImageResource(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/pages/images/0.jpg");
		IOUtils.copy(is1, response.getOutputStream());
	}
	
	//接到的是圖片的資料串流，return串流，無秀出
	@RequestMapping(path = "/responseImageReturn.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public byte[] processResponseImageReturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/pages/images/0.jpg");
		return IOUtils.toByteArray(is1);
	}
	
	//接到的是圖片的資料串流
	//@ResponseBody的意思就是把接到的串流當成BODY秀出來
	@RequestMapping(path = "/responseImageReturnShow.controller", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody byte[] processResponseImageReturnShow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream is1 = request.getServletContext().getResourceAsStream("/WEB-INF/pages/images/0.jpg");
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		return IOUtils.toByteArray(is1);
	}
	
}
