package test.login;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import member.model.vo.MemberVO;

public class LoginSrv {
	public List<MemberVO> getLogin(String id, String pw){
		Connection conn = getConnection();
		List<MemberVO> result = new LoginDao().getLogin(conn, id, pw);
		close(conn);
		return result;
	}
}
