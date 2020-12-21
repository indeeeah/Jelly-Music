package music.player.model.service;

import static common.jdbcDriver.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import music.player.model.dao.PlayerDao;
import music.player.model.vo.PlayerVO;

public class PlayerSrv {
	public List<PlayerVO> getMyListAll(String mem_id) {
		Connection conn = getConnection();
		List<PlayerVO> pvo = new PlayerDao().getMyListAll(conn, mem_id);
		close(conn);
		return pvo;
	}

//	public List<PlayerVO> memberProf(String mem_id) {
//		Connection conn = getConnection();
//		List<PlayerVO> mvo = new PlayerDao().memberProf(conn, mem_id);
//		close(conn);
//		return mvo;
//	}

	public int clickHeart(String mem_id, String mu_no) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new PlayerDao().clickHeart(conn, mem_id, mu_no);
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
		return result;
	}

	public int deleteHeart(String mem_id, String mu_no) {
		Connection conn = getConnection();
		int result = new PlayerDao().deleteHeart(conn, mem_id, mu_no);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deletePlayList(String mem_id, String mu_no) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new PlayerDao().deletePlayList(conn, mem_id, mu_no);
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
		return result;
	}

	public int isHeartExist(String mem_id, String mu_no) {
		Connection conn = getConnection();
		int n = new PlayerDao().isHeartExist(conn, mem_id, mu_no);
		close(conn);
		return n;

	}

//	public List<PlayerVO> firstMyMusicPlayer(String mem_id) {
//		Connection conn = getConnection();
//		List<PlayerVO> pvo = new PlayerDao().firstMyMusicPlayer(conn, mem_id);
//		close(conn);
//		return pvo;
//	}
//	public void heartTB_insert(String mem_id, String mu_no) {
//		Connection conn = getConnection();
//		try {
//			conn.setAutoCommit(false);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(conn);
//		}
//	}
//
//	public void heartTB_delete(String mem_id, String mu_no) {
//		Connection conn = getConnection();
//		try {
//			conn.setAutoCommit(false);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(conn);
//		}
//	}
//
//	public boolean prevent_duplication(String mem_id, String mu_no) {
//		Connection conn = getConnection();
//		int result = 0;
//		try {
//			conn.setAutoCommit(false);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(conn);
//		}
//		return result > 0 ? true : false;
//	}
}
