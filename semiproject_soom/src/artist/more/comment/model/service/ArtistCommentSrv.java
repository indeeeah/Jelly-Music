package artist.more.comment.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.commit;
import static common.jdbcDriver.JDBCTemplate.getConnection;
import static common.jdbcDriver.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import artist.more.comment.model.dao.ArtistCommentDao;
import artist.more.comment.model.vo.ArtistCommentVO;

public class ArtistCommentSrv {
	
	public int getCommentCount() {
		Connection con = getConnection();
		int result = new ArtistCommentDao().getCommentCount(con);
		close(con);
		return result;
	}
	
	/*
	 * public List<ArtistCommentVO> getCommentAll(){ Connection con =
	 * getConnection(); List<ArtistCommentVO> result = new
	 * ArtistCommentDao().getCommentAll(con); close(con); return result; }
	 * 
	 * public List<ArtistCommentVO> getCommentByPage(int start, int end){ Connection
	 * con = getConnection(); List<ArtistCommentVO> result = new
	 * ArtistCommentDao().getCommentByPage(con, start, end); close(con); return
	 * result; }
	 * 
	 * public List<ArtistCommentVO> getBoard(int bno){ Connection con =
	 * getConnection(); List<ArtistCommentVO> result = new
	 * ArtistCommentDao().getBoard(con, bno); close(con); return result; }
	 */
	
	public int writeArtComment(ArtistCommentVO vo){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new ArtistCommentDao().writeArtComment(con, vo);
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
	
	public int deleteArtComment(int art_co_no){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new ArtistCommentDao().deleteArtComment(con, art_co_no);
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
