package manager.managerPost.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import manager.managerPost.dao.ManagerPostDao;
import manager.managerPost.vo.ManagerPostVo;

public class ManagerPostSrv {
	private static DataSource ds = null;
	private static Connection conn = null;
	private static ManagerPostDao dao = new ManagerPostDao();
	
	public ManagerPostSrv() {
		try {
			Context initContext1 = new InitialContext();
			Context envContext1 = (Context) initContext1.lookup("java:/comp/env");
			ds = (DataSource) envContext1.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static int getBoardCount() throws Exception {
		int result = new ManagerPostDao().getBoardCount(conn);
		return result;
	}
	
	public static List<ManagerPostVo> postList(int start, int end) throws Exception {
		List<ManagerPostVo> list = null;
		list = dao.postList(conn, start, end);
		if(list != null) {
			close();
		}
		return list;
	}
	
	public ManagerPostVo postDetail(int strp_no) throws Exception {
		ManagerPostVo vo = null;
		vo = dao.postDetail(conn, strp_no);
		if (vo != null) {
			close();
		}
		return vo;
	}
	
	public int postWrite(String p_name, String p_content, String mng_id) throws Exception {
		int result = 0;
		result = dao.postWrite(conn, p_name, p_content, mng_id);
		if (result != 0) {
			close();
		}

		return result;
	}

	public int postUpdate(String p_name, String p_content, String p_no) throws Exception {
		int result = 0;
		result = dao.postUpdate(conn, p_name, p_content, p_no);
		if (result != 0) {
			close();
		}
		return result;
	}

	public int postDelete(String p_no) throws Exception {
		int result = 0;
		result = dao.postDelete(conn, p_no);
		if (result != 0) {
			close();
		}

		return result;
	}

	public int upCount(int strp_no) throws Exception {
		int result = dao.upCount(conn, strp_no);
		return result;

	}

	
}
