package music.list.mood.model.service;
import static common.jdbcDriver.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import main.model.dao.MainDao;
import main.model.vo.MainVO;
import music.list.mood.model.dao.MoodDao;
import music.list.mood.model.vo.MoodVO;

public class MoodSrv {
	public List<MoodVO>setMoodAll(){
		Connection conn = getConnection();
		List<MoodVO> Mvo = new MoodDao().setMoodAll(conn);
		close(conn);
		return Mvo;
		
	}
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
}
