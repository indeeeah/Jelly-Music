package manager.login.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manager.login.vo.ManagerLoginVo;

public class ManagerLoginDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public List<ManagerLoginVo> getLoginMng(Connection conn, String mng_id, String mng_pwd) {
		List<ManagerLoginVo> list = new ArrayList<ManagerLoginVo>();
		String sql = "select *  from manager where mng_id=? and mng_pwd=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mng_id);
			pstmt.setString(2, mng_pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					ManagerLoginVo vo = new ManagerLoginVo();
					vo.setMng_id(rs.getString("mng_id"));
					vo.setMng_pwd(rs.getString("mng_pwd"));
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
