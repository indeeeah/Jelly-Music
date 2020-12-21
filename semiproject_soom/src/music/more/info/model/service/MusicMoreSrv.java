package music.more.info.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import music.more.comment.model.dao.MusicCommentDao;
import music.more.comment.model.vo.MusicCommentVO;
import music.more.info.model.dao.MusicMoreDao;
import music.more.info.model.vo.MusicMoreVO;

public class MusicMoreSrv {
	
	
	// 곡 기본 정보
	public List<MusicMoreVO> getMusicInfo(String mu_no){
		Connection conn = getConnection();
		List<MusicMoreVO> result = new MusicMoreDao().getMusicInfo(conn, mu_no);
		close(conn);
		return result;
	}
	// 가사
	public List<MusicMoreVO> getLyrics(String mu_no){
		Connection conn = getConnection();
		List<MusicMoreVO> result = new MusicMoreDao().getLyrics(conn, mu_no);
		close(conn);
		return result;
	}
	// 수록앨범
	public List<MusicMoreVO> getIncludeAl(String mu_no){
		Connection conn = getConnection();
		List<MusicMoreVO> result = new MusicMoreDao().getIncludeAl(conn, mu_no);
		close(conn);
		return result;
	}
	
	
	// 비디오
	
	// 싱글즈
	public List<MusicMoreVO> getSingles(String mu_no){
		Connection conn = getConnection();
		List<MusicMoreVO> result = new MusicMoreDao().getSingles(conn, mu_no);
		close(conn);
		return result;
	}
	
	// 관련음악
	public List<MusicMoreVO> getRelated(String mu_no){
		Connection conn = getConnection();
		List<MusicMoreVO> result = new MusicMoreDao().getRelated(conn, mu_no);
		close(conn);
		return result;
	}
	
	// 댓글 리스트
	public List<MusicCommentVO> getCommentAll(String mu_no){
		Connection con = getConnection();
		List<MusicCommentVO> result = new MusicCommentDao().getCommentAll(con, mu_no);
		close(con);
		return result;
	}
}
