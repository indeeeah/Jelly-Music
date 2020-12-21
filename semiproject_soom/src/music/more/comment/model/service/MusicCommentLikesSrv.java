package music.more.comment.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.commit;
import static common.jdbcDriver.JDBCTemplate.getConnection;
import static common.jdbcDriver.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import music.more.comment.model.dao.MusicCommentLikesDao;

public class MusicCommentLikesSrv {

	public int insertLike(String mem_id, int mu_co_no) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new MusicCommentLikesDao().insertLike(conn, mem_id, mu_co_no);
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

	public int insertDisLike(String mem_id, int mu_co_no) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new MusicCommentLikesDao().insertDisLike(conn, mem_id, mu_co_no);
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

	public int getMusicCommentLikeCount(int mu_co_no) {
		Connection conn = getConnection();
		int result = new MusicCommentLikesDao().getMusicCommentLikeCount(conn, mu_co_no);
		close(conn);
		return result;
	}

	public HashMap<String, Integer> getLikeDislikeCount(int mu_co_no1, int mu_co_no2) {
		Connection conn = getConnection();
		HashMap<String, Integer> vo = new MusicCommentLikesDao().getLikeDislikeCount(conn, mu_co_no1, mu_co_no2);
		close(conn);
		return vo;
	}

	public int addReport(String mem_id, int mu_co_no, String report_reason, String report_content) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new MusicCommentLikesDao().addReport(conn, mem_id, mu_co_no, report_reason, report_content);
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
}

//	public int getCommentLike(String mem_id, int mu_co_no) {
//		Connection con = getConnection();
//		int result = 0;
//		try {
//			con.setAutoCommit(false);
//			result = new MusicCommentLikesDao().getMusicCommentLike(con, mem_id, mu_co_no);
//			if (result > 0)
//				commit(con);
//			else
//				rollback(con);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(con);
//		}
//		return result;
//	}
//
//	public int pressLikeInsert(int mu_co_no, String mem_id) {
//		Connection conn = getConnection();
//		int result = 0;
//		try {
//			conn.setAutoCommit(false);
//			result = new MusicCommentLikesDao().pressLikeInsert(conn, mu_co_no, mem_id);
//			if (result > 0) {
//				commit(conn);
//			} else {
//				rollback(conn);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(conn);
//		}
//		return result;
//	}
//
//	public int pressHateInsert(int mu_co_no, String mem_id) {
//		Connection conn = getConnection();
//		int result = 0;
//		try {
//			conn.setAutoCommit(false);
//			result = new MusicCommentLikesDao().pressHateInsert(conn, mu_co_no, mem_id);
//			if (result > 0) {
//				commit(conn);
//			} else {
//				rollback(conn);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(conn);
//		}
//		return result;
//	}
//
//	public int addLikeUpdate(int mu_co_no) {
//		Connection conn = getConnection();
//		int result = 0;
//		try {
//			conn.setAutoCommit(false);
//			result = new MusicCommentLikesDao().addLikeUpdate(conn, mu_co_no);
//			if (result > 0) {
//				commit(conn);
//			} else {
//				rollback(conn);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(conn);
//		}
//		return result;
//	}
//
//	public int addHateUpdate(int mu_co_no) {
//		Connection conn = getConnection();
//		int result = 0;
//		try {
//			conn.setAutoCommit(false);
//			result = new MusicCommentLikesDao().addHateUpdate(conn, mu_co_no);
//			if (result > 0) {
//				commit(conn);
//			} else {
//				rollback(conn);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(conn);
//		}
//		return result;
//	}
//
//	//////////////////////////////////////////////////////////////////////////////////////////