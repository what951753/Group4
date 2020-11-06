//package tw.group4.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//@Repository("houseDao")
//public class HouseDAO {
//	
//	private DataSource datasource;
//	
//	@Autowired
//	public HouseDAO(@Qualifier("oracledatasource")DataSource datasource){
//		this.datasource = datasource;
//	}
//	
//	public House select(int houseid) throws SQLException {
//		Connection conn= datasource.getConnection();
//		String sqlStr = "Select * From House Where houseid=?";
//				
//		PreparedStatement pstmt = conn.prepareStatement(sqlStr);
//		pstmt.setInt(1, houseid);
//		ResultSet rs = pstmt.executeQuery();
//		
//		House hBean = null;
//		
//		if(rs.next()) {
//			hBean=new House();
//			hBean.setHouseid(rs.getInt(1));
//			hBean.setHousename(rs.getString(2));
//		}
//		
//		rs.close();
//		pstmt.close();
//		conn.close();
//		
//		return hBean;			
//	}
//}
