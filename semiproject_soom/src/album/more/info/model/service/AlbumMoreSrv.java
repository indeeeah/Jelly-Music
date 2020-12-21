package album.more.info.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import album.more.comment.model.dao.AlbumCommentDao;
import album.more.comment.model.vo.AlbumCommentVO;
import album.more.info.model.dao.AlbumMoreDao;
import album.more.info.model.vo.AlbumMoreVO;
import music.more.comment.model.dao.MusicCommentDao;
import music.more.comment.model.vo.MusicCommentVO;
import music.more.info.model.dao.MusicMoreDao;
import music.more.info.model.vo.MusicMoreVO;

public class AlbumMoreSrv {
	
	// 곡 기본 정보
	public List<AlbumMoreVO> getAlbumInfo(String al_no){
		Connection conn = getConnection();
		List<AlbumMoreVO> result = new AlbumMoreDao().getAlbumInfo(conn, al_no);
		close(conn);
		return result;
	}
	
	// 수록 곡
	public List<AlbumMoreVO> getIncludeMu(String al_no){
		Connection conn = getConnection();
		List<AlbumMoreVO> result = new AlbumMoreDao().getIncludeMu(conn, al_no);
		close(conn);
		return result;
	}
		
	// 싱글즈
	public List<AlbumMoreVO> getSingles(String al_no){
		Connection conn = getConnection();
		List<AlbumMoreVO> result = new AlbumMoreDao().getSingles(conn, al_no);
		close(conn);
		return result;
	}
	
	// 비슷한 앨범
	public List<AlbumMoreVO> getAlike(String al_no){
		Connection conn = getConnection();
		List<AlbumMoreVO> result = new AlbumMoreDao().getAlike(conn, al_no);
		close(conn);
		return result;
	}

	
	// 앨범 댓글
	public List<AlbumCommentVO> getAlComment(String al_no){
		Connection con = getConnection();
		List<AlbumCommentVO> result = new AlbumCommentDao().getAlComment(con, al_no);
		close(con);
		return result;
	}
}
