package tw.group4._35_.oldRegister.model;

public interface InterfaceMemberService {
	boolean idExists(String id);
	int saveMember(Member mb);
	Member queryMember(String id);
	public Member checkIDPassword(String userId, String password) ;
}
