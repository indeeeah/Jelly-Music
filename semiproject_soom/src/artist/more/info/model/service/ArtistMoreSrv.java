package artist.more.info.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import artist.more.comment.model.dao.ArtistCommentDao;
import artist.more.comment.model.vo.ArtistCommentVO;
import artist.more.info.model.dao.ArtistMoreDao;
import artist.more.info.model.vo.ArtistMoreVO;

public class ArtistMoreSrv {

	// 아티스트 기본 정보
	public List<ArtistMoreVO> getArtistInfo(String art_no) {
		Connection conn = getConnection();
		List<ArtistMoreVO> result = new ArtistMoreDao().getArtistInfo(conn, art_no);
		close(conn);
		return result;
	}

	// 대표 곡
	public List<ArtistMoreVO> getTracks(String art_no) {
		Connection conn = getConnection();
		List<ArtistMoreVO> result = new ArtistMoreDao().getTracks(conn, art_no);
		close(conn);
		return result;
	}

	// 싱글즈
	public List<ArtistMoreVO> getSingles(String art_no) {
		Connection conn = getConnection();
		List<ArtistMoreVO> result = new ArtistMoreDao().getSingles(conn, art_no);
		close(conn);
		return result;
	}

	// 비슷한 아티스트
	public List<ArtistMoreVO> getSimilar(String art_no) {
		Connection conn = getConnection();
		List<ArtistMoreVO> result = new ArtistMoreDao().getSimilar(conn, art_no);
		close(conn);
		return result;
	}

	// 앨범 댓글
	public List<ArtistCommentVO> getArtComment(String art_no) {
		Connection con = getConnection();
		List<ArtistCommentVO> result = new ArtistCommentDao().getArtComment(con, art_no);
		close(con);
		return result;
	}
}
