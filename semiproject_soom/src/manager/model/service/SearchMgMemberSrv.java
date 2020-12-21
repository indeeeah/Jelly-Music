package manager.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import manager.model.dao.SearchMgMemberDao;
import manager.model.vo.SearchMgMemberVO;


public class SearchMgMemberSrv {
	
	public static List<SearchMgMemberVO> memList(int start, int end) throws Exception {
		Connection conn = getConnection();
		List<SearchMgMemberVO> list = null;
		list = new SearchMgMemberDao().memList(conn, start, end);
		if (list != null) {
			close(conn);
		}
		return list;
	}	
	
	public static int getBoardCount() throws Exception {
		Connection conn = getConnection();
		int result = new SearchMgMemberDao().getBoardCount(conn);
		close(conn);
		return result;
	}
	
	public List<SearchMgMemberVO> memSearch(String searchWord, int start, int end) throws Exception {
		Connection conn = getConnection();
		List<SearchMgMemberVO> list = null;
		SearchMgMemberDao dao = new SearchMgMemberDao();
		list = dao.memSearch(conn, searchWord, start, end);
		if (list != null) {
			close(conn);
		}
		return list;
	}
	
	public int getSearchCount(String searchWord) throws Exception {
		Connection conn = getConnection();
		int result = new SearchMgMemberDao().getSearchCount(conn, searchWord);
		conn.close();
		return result;			
	}
}
