package member.purchase.membership.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import member.purchase.membership.model.vo.StreamingVO;

public class StreamingDao {

	private PreparedStatement pstmt;
//	private ResultSet rs;

	public int insertStreaming(Connection conn, StreamingVO vo) {
		int result = 0;
		String sql = "insert into Streaming (mem_id, ms_no,ms_str_date,ms_str_left) values(?,?,sysdate,?)";
		System.out.println("a5: " + vo.toString());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_id());
			pstmt.setString(2, vo.getMs_no());
			pstmt.setDate(3, vo.getMs_str_left());
			System.out.println("a6");
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ms_p_leftDao :" + e);
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("a7:" + result);
		return result;
	}
}
