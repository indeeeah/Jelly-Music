package music.player.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.commit;
import static common.jdbcDriver.JDBCTemplate.getConnection;
import static common.jdbcDriver.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import music.player.model.dao.PlayMusicMiDao;

public class PlayMusicMiSrv {
	public int playMusicMi(int mly, String mem_id, String mu_no) {
		System.out.println("1분Srv1");
		Connection conn = getConnection();
		int result = new PlayMusicMiDao().playMusicMi(conn, mly, mem_id, mu_no);
		try {
			conn.setAutoCommit(false);
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		System.out.println("1분Srv2");
		System.out.println(result);
		
		return result;
	}
}
