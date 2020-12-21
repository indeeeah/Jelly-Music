package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static common.jdbcDriver.JDBCTemplate.*;

import member.model.dao.FirstArtistDao;
import member.model.vo.FirstArtistVO;

public class FirstArtistSrv {
	public List<FirstArtistVO> setArtistt() {
		Connection conn = getConnection();
		List<FirstArtistVO> fvo = new FirstArtistDao().setArtistt(conn);
		close(conn);
		return fvo;
	}

	public List<FirstArtistVO> setArtistm() {
		Connection conn = getConnection();
		List<FirstArtistVO> fvo = new FirstArtistDao().setArtistm(conn);
		close(conn);
		return fvo;
	}

	public List<FirstArtistVO> setArtistb() {
		Connection conn = getConnection();
		List<FirstArtistVO> fvo = new FirstArtistDao().setArtistb(conn);
		close(conn);
		return fvo;
	}

	public int firstArtist(FirstArtistVO vo) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new FirstArtistDao().firstArtist(conn, vo);
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
