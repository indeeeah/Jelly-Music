package test.login;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.MemberVO;

public class LoginDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public List<MemberVO> getLogin(Connection conn, String id, String pw) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select *  from member where mem_id=? and mem_pwd=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MemberVO vo = new MemberVO();
					vo.setMem_id(rs.getString("mem_id"));
					vo.setMem_pwd(rs.getString("mem_pwd"));
					vo.setMem_aka(rs.getString("mem_aka"));
					vo.setMem_addr(rs.getString("mem_addr"));
					vo.setMem_email(rs.getString("mem_email"));
					vo.setMem_phone(rs.getInt("mem_phone"));
					vo.setMem_sns(rs.getString("mem_sns"));
					vo.setMem_birth(rs.getDate("mem_birth"));
					vo.setMem_reg_date(rs.getDate("mem_reg_date"));
					vo.setMem_wd_date(rs.getDate("mem_wd_date"));
					list.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
