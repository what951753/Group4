package tw.group4._14_shopAP.init;

import java.io.*;
import java.sql.*;

import tw.group4._14_shopAP.model.ARTProduct;


public class APTableReset {
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8??�BOM字�??

	public static void main(String[] args) {
		String line = "";
		int count = 0;
		try (Connection con = DriverManager.getConnection(OracleSQL.getDburlOracle(),
				OracleSQL.getUseridOracle(), OracleSQL.getPswdOracle());
				Statement stmt = con.createStatement();) {
			
			try {
				stmt.executeUpdate(OracleSQL.getDropTableApcart());
				System.out.println("Drop Apcart Table!");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stmt.executeUpdate(OracleSQL.getCreateApcart());
			System.out.println("Apcart Table Creat <3");

		try {
			stmt.executeUpdate(OracleSQL.getDropTableArtproduct());
			System.out.println("Drop Artproduct Table!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		stmt.executeUpdate(OracleSQL.getCreateArtproduct());
		System.out.println("Artproduct Table Creat <3");
		
		try {
			stmt.executeUpdate(OracleSQL.getDropTableApcart());
			System.out.println("Drop Apcart Table!");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		stmt.executeUpdate(OracleSQL.getCreateApcart());
		System.out.println("Apcart Table Creat <3");
		
		try {
			stmt.executeUpdate(OracleSQL.getDropTableOrderitemsap());
			System.out.println("Drop OrderItemsAP Table!");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		stmt.executeUpdate(OracleSQL.getCreateOrderitemsap());
		System.out.println("OrderItemsAP Table Creat <3");
		
		
		try {
			stmt.executeUpdate(OracleSQL.getDropTableOrdersap());
			System.out.println("Drop Ordersap Table!");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		stmt.executeUpdate(OracleSQL.getCreateOrdersOracle());
		System.out.println("Orders Table Creat <3");
		
		//注意檔案路徑可能須修改
		File file = new File("C:\\Users\\user\\Downloads\\ink3.csv");
		
		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "big5");
				BufferedReader br = new BufferedReader(isr);) {
				con.setAutoCommit(false);
				String jdbc_insert_sql = "INSERT INTO Artproduct " + 
				" (aptitle,  aptype, apprice, apimg, apdes, apnum) "
						+ " VALUES ( ?, ?, ?, ?, ?, ?)";

				try (PreparedStatement pstmt = con.prepareStatement(jdbc_insert_sql);) {

					String lineText = null;
					while ((line = br.readLine()) != null) {
						System.out.println("line=" + line);
						// ?��?�� UTF8_BOM: \uFEFF
						if (line.startsWith(UTF8_BOM)) {
							line = line.substring(1);
						}
						String[] token = line.split(",");
						ARTProduct pd = new ARTProduct();
						String APId = token[0];
						String pTitle = (token[1]);
						String pType = (token[2]);
						String pRrice = (token[3]);
						String pImg = (token[4]);
						String pDes  = (token[5]);
						
						int pnum  = 10;
						count++;
				
//						pstmt.setString(1, APId);
						pstmt.setString(1, pTitle);
//						int pRrice2 = Integer.parseInt(pRrice);
						pstmt.setString(2, pType);
						pstmt.setString(3, pRrice);
						pstmt.setString(4, pImg);
						pstmt.setString(5, pDes);
						pstmt.setInt(6, pnum);
						
						pstmt.addBatch();
						pstmt.executeBatch();
						pstmt.clearBatch();

						System.out.println(APId + " " + pTitle + " " + pRrice + " " + pImg + " " + pDes);
						System.out.println("-----");
					}
					
					System.out.println("--------------------------------");
					con.commit();
					System.out.println("匯入 " + count + " 筆");
			}
			
			System.out.println("APPRODUCT TABLE CREAT!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
		
		}
	
	
	
		

	

}
	
