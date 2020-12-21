package album.more.comment.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.commit;
import static common.jdbcDriver.JDBCTemplate.getConnection;
import static common.jdbcDriver.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import album.more.comment.model.dao.AlbumCommentDao;
import album.more.comment.model.vo.AlbumCommentVO;

public class AlbumCommentSrv {

	public int getBoardCount() {
		Connection con = getConnection();
		int result = new AlbumCommentDao().getCommentCount(con);
		close(con);
		return result;
	}
	
	public List<AlbumCommentVO> getAlComment(String al_no){
		Connection con = getConnection();
		List<AlbumCommentVO> result = new AlbumCommentDao().getAlComment(con, al_no);
		close(con);
		return result;
	}
	
	/*
	 * public List<AlbumCommentVO> getCommentByPage(int start, int end){ Connection
	 * con = getConnection(); List<AlbumCommentVO> result = new
	 * AlbumCommentDao().getCommentByPage(con, start, end); close(con); return
	 * result; }
	 */
	
	/*
	 * public List<AlbumCommentVO> getBoard(int bno){ Connection con =
	 * getConnection(); List<AlbumCommentVO> result = new
	 * AlbumCommentDao().getBoard(con, bno); close(con); return result; }
	 */
	
	public int writeAlComment(AlbumCommentVO vo){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new AlbumCommentDao().writeAlComment(con, vo);
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
	
	public int deleteAlComment(int al_co_no){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new AlbumCommentDao().deleteAlComment(con, al_co_no);
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
