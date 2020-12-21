package manager.managerPost.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manager.managerPost.vo.ManagerPostVo;

public class ManagerPostDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public void close(ResultSet rs, PreparedStatement pstmt) throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
	}

	public int getBoardCount(Connection conn) throws SQLException, Exception {
		int cnt = 0;
		String sql = "select COUNT(*) from post";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			cnt = rs.getInt(1);
		}
		close(rs, pstmt);
		return cnt;
	}

	public List<ManagerPostVo> postList(Connection conn, int start, int end) throws SQLException, Exception {
		List<ManagerPostVo> list = null;
		String sql = "select * from " + "(select ROWNUM rnum, d.* from " + "(select * from post order by p_no desc) "
				+ "d) " + "where rnum >= ? and rnum <= ?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			list = new ArrayList<ManagerPostVo>();
			do {
				ManagerPostVo vo = new ManagerPostVo();
				vo.setP_no(rs.getString("p_no"));
				vo.setP_name(rs.getString("p_name"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_time(rs.getDate("p_time"));
				vo.setP_hits(rs.getInt("p_hits"));
				vo.setMng_id(rs.getString("mng_id"));
				list.add(vo);
			} while (rs.next());
			close(rs, pstmt);
		}
		return list;
	}

	public ManagerPostVo postDetail(Connection conn, int strp_no) throws SQLException, Exception {
		upCount(conn, strp_no);
		String sql = "select * from post where p_no = ?";
		ManagerPostVo vo = new ManagerPostVo();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, strp_no);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			vo.setP_no(rs.getString("p_no"));
			vo.setP_name(rs.getString("p_name"));
			vo.setP_content(rs.getString("p_content"));
			vo.setP_time(rs.getDate("p_time"));
			vo.setP_hits(rs.getInt("p_hits"));
			vo.setMng_id(rs.getString("mng_id"));

		}
		close(rs, pstmt);
		return vo;
	}

	public int postWrite(Connection conn, String p_name, String p_content, String mng_id) throws SQLException, Exception {
		String sql = "insert into post(p_no, p_name, p_content, mng_id)"
				+ "values (P_NO_SEQ.nextval,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, p_name);
		pstmt.setString(2, p_content);
		pstmt.setString(3, mng_id);
		
		int result = pstmt.executeUpdate();

		close(rs, pstmt);
		return result;
	}

	public int postUpdate(Connection conn, String p_name, String p_content, String p_no) throws SQLException, Exception {
		String sql = "UPDATE post SET p_name = ?, p_content = ? " + "WHERE p_no = ?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, p_name);
		pstmt.setString(2, p_content);
		pstmt.setString(3, p_no);

		int result = pstmt.executeUpdate();

		close(rs, pstmt);
		return result;
	}

	public int postDelete(Connection conn, String p_no) throws SQLException, Exception {
		int result = 0;
		String sql = "DELETE FROM post WHERE p_no = ?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, p_no);

		result = pstmt.executeUpdate();

		close(rs, pstmt);
		return result;
	}

	public int upCount(Connection conn, int strp_no) throws SQLException, Exception {
		String sql = "update post set p_hits = p_hits + 1 where p_no = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, strp_no);

		int result = pstmt.executeUpdate();
		close(rs, pstmt);

		return result;
	}

}
