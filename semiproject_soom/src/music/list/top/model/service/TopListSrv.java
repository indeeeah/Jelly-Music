package music.list.top.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import main.model.dao.MainDao;
import main.model.vo.MainVO;
import music.list.top.model.dao.TopListDao;
import music.list.top.model.vo.TopListVO;

public class TopListSrv {
	public List<TopListVO> getTopListAll(){
		Connection conn = getConnection();
		List<TopListVO> result = new TopListDao().getTopListAll(conn);
		close(conn);
		return result;
	}
	public List<MainVO> searchWord() {
		Connection conn = getConnection();
		List<MainVO> svo = new MainDao().searchWord(conn);
		close(conn);
		return svo;
	}

}
