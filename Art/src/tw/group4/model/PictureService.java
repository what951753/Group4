package tw.group4.model;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
	
	private PictureDAO pDAO;
	
	@Autowired
	public PictureService(PictureDAO pDao) {
		this.pDAO=pDao;
	}
	
	public Picture insert(Picture pBean) {
		return pDAO.insert(pBean);
	}
	
	public void savePicture(String fileName, String savePath) {
		try {
			Picture picture = new Picture();
			picture.setFilename(fileName);
			
			InputStream is1 = new FileInputStream(savePath);
			byte[] b =new byte[is1.available()];
			is1.read(b);
			is1.close();
			picture.setPicture(b);
			
			this.insert(picture);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//按id讀取資料庫內圖片的方法
	public Picture select(int id) {
		return pDAO.select(id);
	}

}
