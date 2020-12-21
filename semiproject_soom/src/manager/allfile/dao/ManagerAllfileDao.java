package manager.allfile.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manager.allfile.vo.ManagerAllfileVO;

public class ManagerAllfileDao {

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
	
	public int uploadFile(Connection conn, String f_no, String f_name) throws SQLException, Exception {
		String sql = "insert into mallfile values(m_fno_seq.nextval,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, f_no);
		pstmt.setString(2, f_name);
		
		int result = pstmt.executeUpdate();

		close(rs, pstmt);
		return result;
	}
	
	public int getBoardCount(Connection conn) throws SQLException, Exception {
		int cnt = 0;
		String sql = "select COUNT(*) from mallfile";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			cnt = rs.getInt(1);
		}
		close(rs, pstmt);
		return cnt;
	}

	public List<ManagerAllfileVO> allList(Connection conn, int start, int end) throws SQLException, Exception {
		List<ManagerAllfileVO> list = null;
		String sql = "select * from " + "(select ROWNUM rnum, d.* from " + "(select * from mallfile order by num desc) "
				+ "d) " + "where rnum >= ? and rnum <= ?";

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			list = new ArrayList<ManagerAllfileVO>();
			do {
				ManagerAllfileVO vo = new ManagerAllfileVO();
				vo.setNum(rs.getInt("num"));
				vo.setF_no(rs.getString("f_no"));
				vo.setF_name(rs.getString("f_name"));
				list.add(vo);
			} while (rs.next());
			close(rs, pstmt);
		}
		return list;
	}

	public ManagerAllfileVO selectOne(Connection conn, int num) throws SQLException, Exception {
		String sql = "select * from mallfile where num = ?";
		ManagerAllfileVO vo = new ManagerAllfileVO();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			vo.setNum(rs.getInt("num"));
			vo.setF_no(rs.getString("f_no"));
			vo.setF_name(rs.getString("f_name"));		
		}
		close(rs, pstmt);
		return vo;
	}
}
