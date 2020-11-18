package tw.group4._35_.oldRegister.model;

import org.springframework.stereotype.Service;

@Service
public class MemberService implements InterfaceMemberService {

	InterfaceMemberDao  dao ;
	public MemberService() {
		this.dao = new MemberDao();
	}

	@Override
	public int saveMember(Member mb) {
		return dao.saveMember(mb);
	}

	@Override
	public boolean idExists(String id) {
		return dao.idExists(id);
	}

	@Override
	public Member queryMember(String id) {
		return dao.queryMember(id);
	}

	public Member checkIDPassword(String userId, String password) {
		Member mb = dao.checkIDPassword(userId, password);
		return mb;
	}
}
