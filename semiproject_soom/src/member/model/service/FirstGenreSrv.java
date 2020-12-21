package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import static common.jdbcDriver.JDBCTemplate.*;

import member.model.dao.FirstGenreDao;
import member.model.vo.FirstGenreVO;

public class FirstGenreSrv {
	public List<FirstGenreVO> setGenret() {
		Connection conn = getConnection();
		List<FirstGenreVO> fvo = new FirstGenreDao().setGenret(conn);
		close(conn);
		return fvo;
	}

	public List<FirstGenreVO> setGenrem() {
		Connection conn = getConnection();
		List<FirstGenreVO> fvo = new FirstGenreDao().setGenrem(conn);
		close(conn);
		return fvo;
	}

	public List<FirstGenreVO> setGenreb() {
		Connection conn = getConnection();
		List<FirstGenreVO> fvo = new FirstGenreDao().setGenreb(conn);
		close(conn);
		return fvo;
	}

	public int firstGenre(FirstGenreVO vo) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new FirstGenreDao().firstGenre(conn, vo);
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
