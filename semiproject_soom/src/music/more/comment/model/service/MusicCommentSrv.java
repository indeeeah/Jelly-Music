package music.more.comment.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.commit;
import static common.jdbcDriver.JDBCTemplate.getConnection;
import static common.jdbcDriver.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import music.more.comment.model.dao.MusicCommentDao;
import music.more.comment.model.vo.MusicCommentVO;

public class MusicCommentSrv {
	
	public int getCommentCount() {
		Connection con = getConnection();
		int result = new MusicCommentDao().getCommentCount(con);
		close(con);
		return result;
	}
	
	public List<MusicCommentVO> getCommentAll(String mu_no){
		Connection con = getConnection();
		List<MusicCommentVO> result = new MusicCommentDao().getCommentAll(con, mu_no);
		close(con);
		return result;
	}
	
	public List<MusicCommentVO> getCommentByPage(int start, int end){
		Connection con = getConnection();
		List<MusicCommentVO> result = new MusicCommentDao().getCommentByPage(con, start, end);
		close(con);
		return result;
	}
	
	public List<MusicCommentVO> getComment(int mu_co_no){
		Connection con = getConnection();
		List<MusicCommentVO> result = new MusicCommentDao().getComment(con, mu_co_no);
		close(con);
		return result;
	}
	
	public int writeMuComment(MusicCommentVO vo){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new MusicCommentDao().writeMuComment(con, vo);
			if(result>0)
				commit(con);
			else
				rollback(con);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
	
	public int deleteMuComment(int mu_co_no){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new MusicCommentDao().deleteMuComment(con, mu_co_no);
			if(result>0)
				commit(con);
			else
				rollback(con);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
	
	public int getMusicCommentLikes(String mem_id, int mu_co_no) {
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new MusicCommentDao().getMusicCommentLikes(con, mem_id, mu_co_no);
			if(result>0)
				commit(con);
			else
				rollback(con);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
}
