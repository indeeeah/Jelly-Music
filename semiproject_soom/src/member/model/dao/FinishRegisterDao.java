package member.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.FinishRegisterVO;

public class FinishRegisterDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<FinishRegisterVO> searchWord(Connection conn) {
		List<FinishRegisterVO> svo = new ArrayList<FinishRegisterVO>();
		String sql = "select * from (select * from search order by sear_hits desc) where rownum<11";// 조건 추가
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					FinishRegisterVO vo = new FinishRegisterVO();
					vo.setSear_word(rs.getString("sear_word"));
					svo.add(vo);
				} while (rs.next());
			} else {
				System.out.println("데이터가 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return svo;
	}

	public int frMakeCurrmusic(Connection conn, String mem_id) {
		int result = 0;
		String sql = "insert into currmusic values (?, '0000')";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("frMakeCurrmusic 추가 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
