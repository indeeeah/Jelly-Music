package music.list.genre.model.service;

import static common.jdbcDriver.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import main.model.dao.MainDao;
import main.model.vo.MainVO;
import music.list.genre.model.dao.GenreListDao;
import music.list.genre.model.vo.GenreListVO;

public class GenreListSrv {
	public List<GenreListVO> setGenreListAll(){
		Connection conn = getConnection();
		List<GenreListVO> gvo =new GenreListDao().setGenreListAll(conn);
		close(conn);
		return gvo;
	}
	public List<MainVO> searchWord() {
		Connection conn = getConnection();
		List<MainVO> svo = new MainDao().searchWord(conn);
		close(conn);
		return svo;
	}
	
}
