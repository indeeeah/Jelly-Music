package main.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import main.model.dao.MainDao;
import main.model.vo.MainVO;
import static common.jdbcDriver.JDBCTemplate.*;

public class MainService {

//	public List<MainVO> helloToMem(String mem_id) {
//		Connection conn = getConnection();
//		List<MainVO> mvo = new MainDao().helloToMem(conn, mem_id);
//		close(conn);
//		return mvo;
//	}

	public List<MainVO> searchWord() {
		Connection conn = getConnection();
		List<MainVO> svo = new MainDao().searchWord(conn);
		close(conn);
		return svo;
	}

	public List<MainVO> get1to5Top() {
		Connection conn = getConnection();
		List<MainVO> tvo = new MainDao().get1to5Top(conn);
		close(conn);
		return tvo;
	}

	public List<MainVO> get6to10Top() {
		Connection conn = getConnection();
		List<MainVO> tvo = new MainDao().get6to10Top(conn);
		close(conn);
		return tvo;
	}

	public List<MainVO> getNewRelease() {
		Connection conn = getConnection();
		List<MainVO> nvo = new MainDao().getNewRelease(conn);
		close(conn);
		return nvo;
	}

	public List<MainVO> getMood() {
		Connection conn = getConnection();
		List<MainVO> mvo = new MainDao().getMood(conn);
		close(conn);
		return mvo;
	}

	public List<MainVO> getMemPlay(String mem_id) {
		Connection conn = getConnection();
		List<MainVO> mvo = new MainDao().getMemPlay(conn, mem_id);
		close(conn);
		return mvo;
	}

	public List<MainVO> mayLikeArt(String mem_id) {
		Connection conn = getConnection();
		List<MainVO> mvo = new MainDao().mayLikeArt(conn, mem_id);
		close(conn);
		return mvo;
	}

	public List<MainVO> mayLikeMusic(String mem_id) {
		Connection conn = getConnection();
		List<MainVO> mvo = new MainDao().mayLikeMusic(conn, mem_id);
		close(conn);
		return mvo;
	}

	public List<MainVO> genreFirst() {
		Connection conn = getConnection();
		List<MainVO> gvo = new MainDao().genreFirst(conn);
		close(conn);
		return gvo;
	}

	public List<MainVO> genreSecond() {
		Connection conn = getConnection();
		List<MainVO> gvo = new MainDao().genreSecond(conn);
		close(conn);
		return gvo;
	}

	public List<MainVO> genreThird() {
		Connection conn = getConnection();
		List<MainVO> gvo = new MainDao().genreThird(conn);
		close(conn);
		return gvo;
	}

	public List<MainVO> genreFourth() {
		Connection conn = getConnection();
		List<MainVO> gvo = new MainDao().genreFourth(conn);
		close(conn);
		return gvo;
	}

	public List<MainVO> genreFifth() {
		Connection conn = getConnection();
		List<MainVO> gvo = new MainDao().genreFifth(conn);
		close(conn);
		return gvo;
	}

	public int addMyPlayList(String mem_id, String mu_no) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new MainDao().addMyPlayList(conn, mem_id, mu_no);
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

//	public List<MainVO> firstMyMusic(String mem_id) {
//		Connection conn = getConnection();
//		List<MainVO> fvo = new MainDao().firstMyMusic(conn, mem_id);
//		close(conn);
//		return fvo;
//	}

	public List<MainVO> showCurrmusic(String mem_id) {
		Connection conn = getConnection();
		List<MainVO> mvo = new MainDao().showCurrmusic(conn, mem_id);
		close(conn);
		return mvo;
	}

	public int updateCurrmusic(String mem_id, String mu_no) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new MainDao().updateCurrmusic(conn, mem_id, mu_no);
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
