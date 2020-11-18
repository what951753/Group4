package tw.group4._35_.oldRegister.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import tw.group4._35_.util.GlobalService;

@Repository
public class MemberDao implements InterfaceMemberDao {

	private DataSource ds = null;
	private Connection conn = null;
	public MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
	// 儲存MemberBean物件，將參數mb新增到Member表格內。
	public int saveMember(Member mb) {
		String sql = "insert into Member " 
				+ " (memberID, name, password, address, email, "
				+ " tel, userType, registerTime, Total_Amount, Ticket_Amount," 
				+ " Product_Amount, Class_Amount, Reservation_Quantity,"
				+ " Artshop_Quantity, Class_Quantity, preference) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;

		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, mb.getMemberId());
			ps.setString(2, mb.getName());	
			ps.setString(3, mb.getPassword());
			ps.setString(4, mb.getAddress());
			ps.setString(5, mb.getEmail());
			ps.setString(6, mb.getTel());
			ps.setString(7, mb.getUserType());
			ps.setTimestamp(8, mb.getRegisterTime());		
			ps.setDouble(9, mb.getTotalAmt());
			ps.setDouble(10, mb.getTicketAmt());
			ps.setDouble(11, mb.getProductAmt());
			ps.setDouble(12, mb.getClassAmt());
			ps.setDouble(13, mb.getReservationQut());
			ps.setDouble(14, mb.getArtshopQut());
			ps.setDouble(15, mb.getClassQut());
			ps.setInt(16, mb.getPreference());
		
			n = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#saveMember()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@Override
	public boolean idExists(String id) {
		boolean exist = false;
		String sql = "SELECT * FROM Member WHERE memberID = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					exist = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#idExists()發生例外: " 
					+ ex.getMessage());
		}
		return exist;
	}
	
	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public Member queryMember(String id) {
		Member mb = null;
		String sql = "SELECT * FROM Member WHERE memberID = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new Member();
//					mb.setPKey(rs.getInt("seqNo"));
					mb.setMemberId(rs.getString("memberId"));
					mb.setName(rs.getString("name"));
					mb.setPassword(rs.getString("password"));
					mb.setAddress(rs.getString("address"));
					mb.setEmail(rs.getString("email"));
					mb.setTel(rs.getString("tel"));
					mb.setUserType(rs.getString("userType"));
					mb.setRegisterTime(rs.getTimestamp("RegisterTime"));
					mb.setTotalAmt(rs.getDouble("totalAmt"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " 
					+ ex.getMessage());
		}
		return mb;
	}
	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	@Override
	public Member checkIDPassword(String userId, String password) {
		Member mb = null;
		String sql = "SELECT * FROM Member m WHERE m.memberId = ? and m.password = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, userId);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new Member();
//					mb.setPKey(rs.getInt("seqNo"));
					mb.setMemberId(rs.getString("memberId"));
					mb.setName(rs.getString("name"));
					mb.setPassword(rs.getString("password"));
					mb.setAddress(rs.getString("address"));
					mb.setEmail(rs.getString("email"));
					mb.setTel(rs.getString("tel"));
					mb.setUserType(rs.getString("userType"));
					mb.setRegisterTime(rs.getTimestamp("registerTime"));
					mb.setTotalAmt(rs.getDouble("Total_Amount"));
					mb.setTicketAmt(rs.getDouble("Ticket_Amount"));
					mb.setProductAmt(rs.getDouble("Product_Amount"));
					mb.setClassAmt(rs.getDouble("Class_Amount"));
					mb.setReservationQut(rs.getDouble("Reservation_Quantity"));
					mb.setArtshopQut(rs.getDouble("Artshop_Quantity"));
					mb.setClassQut(rs.getDouble("Class_Quantity"));
					mb.setPreference(rs.getInt("preference"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#checkIDPassword()發生SQL例外: " 
					+ ex.getMessage());
		}
		return mb;
	}
	/*
	 * 功能：更新客戶的未付款訂購金額。
	 * 說明：處理客戶訂單時，[訂單的總金額 + 該客戶的未付款餘額]不能超過限額，
	 * 此限額定義在 GlobalService類別的常數: ORDER_AMOUNT_LIMIT
	 * 步驟：
	 * 1. 取出Member表格內的 Member#unpaid_amount欄位(未付款餘額) 
	 * 2. unpaid_amount加上本訂單的總金額後，檢查該數值是否超過限額
	 *    (GlobalService.ORDER_AMOUNT_LIMIT)。 
	 *    如果超過限額， 則
	 *    		該訂單不予處裡， 丟出UnpaidOrderAmountExceedingException，
	 * 	    否則更新Member表格的unpaid_amount欄位: Member#unpaid_amount += currentAmount;
	 */
	
	@Override
	public void setConnection(Connection conn) {
        this.conn = conn;
	}
}
