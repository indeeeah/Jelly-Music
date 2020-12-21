package music.player.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayMusicMiDao {
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public int playMusicMi(Connection conn, int mly, String mem_id, String mu_no) {
		System.out.println(mly);
		System.out.println(mem_id);
		System.out.println(mu_no);
		int result=0;
		String sql = "update musichistory set play_more_min = ? where mem_id=? and mu_no=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mly); 
			pstmt.setString(2, mem_id); 
			pstmt.setString(3, mu_no);
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}
}
