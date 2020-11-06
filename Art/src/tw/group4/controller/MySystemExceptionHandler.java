//package tw.group4.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class MySystemExceptionHandler {
//	
//	只要有錯誤訊息就會進來這裡被抓到，然後依下面定義的內容顯示錯誤訊息
//	@ExceptionHandler(Exception.class)
//	public Object processException(Exception e) {
//		String msg1 = "Error: Exception";
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg1);
//	}
//
//}
