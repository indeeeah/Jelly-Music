package music.list.main.model.service;

import java.sql.Connection;
import java.util.List;

import music.list.main.model.dao.MainListDao;
import music.list.main.model.vo.MainListVO;
import static common.jdbcDriver.JDBCTemplate.*;


public class MainListSrv {
	
	public List<MainListVO> get1to5Heart(){
		Connection conn = getConnection();
		List<MainListVO> hvo = new MainListDao().get1to5Heart(conn);
		close(conn);
		return hvo;
	}
	
	public List<MainListVO> get6to10Heart(){
		Connection conn = getConnection();
		List<MainListVO> hvo = new MainListDao().get6to10Heart(conn);
		close(conn);
		return hvo;
	}
	
	public List<MainListVO> getMoodAllt(){
		Connection conn = getConnection();
		List<MainListVO> mvo = new MainListDao().getMoodAllt(conn);
		close(conn);
		return mvo;
	}
	
	public List<MainListVO> getMoodAlld(){
		Connection conn = getConnection();
		List<MainListVO> mvo = new MainListDao().getMoodAlld(conn);
		close(conn);
		return mvo;
	}
	
}
