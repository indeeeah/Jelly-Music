package member.purchase.membership.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import main.model.dao.MainDao;
import main.model.vo.MainVO;
import member.purchase.membership.model.dao.MembershipDao;
import member.purchase.membership.model.vo.MembershipVO;

public class MemberShipSrv {

	public List<MembershipVO> getMembershipAll() {
		Connection conn = getConnection();
		List<MembershipVO> result = new MembershipDao().getMembershipAll(conn);
		close(conn);
		return result;
	}
	public List<MainVO> searchWord() {
		Connection conn = getConnection();
		List<MainVO> svo = new MainDao().searchWord(conn);
		close(conn);
		return svo;
	}


}