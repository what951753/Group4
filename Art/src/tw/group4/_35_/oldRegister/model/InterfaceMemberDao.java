package tw.group4._35_.oldRegister.model;

import java.sql.Connection;

public interface InterfaceMemberDao {
	
	public boolean idExists(String id);

	public int saveMember(Member mb) ;
	
	public Member queryMember(String id);
	
	public Member checkIDPassword(String userId, String password);	

	public void setConnection(Connection con);
}