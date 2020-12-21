package music.list.mood.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import music.list.mood.model.dao.MoodMoreDao;
import music.list.mood.model.vo.MoodMoreVO;
public class MoodMoreSrv {
	public List<MoodMoreVO> getMoodMoreAll(){
		Connection conn = getConnection();
		List<MoodMoreVO> result = new MoodMoreDao().getMoodMoreAll(conn);
		close(conn);
		return result;
	}

}

