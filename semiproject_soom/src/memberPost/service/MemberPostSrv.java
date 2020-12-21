package memberPost.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import memberPost.dao.MemberPostDao;
import memberPost.vo.MemberPostVo;

public class MemberPostSrv {
	private static DataSource ds = null;
	private static Connection conn = null;
	private static MemberPostDao dao = new MemberPostDao();
	
	public MemberPostSrv() {
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
		int result = new MemberPostDao().getBoardCount(conn);
		return result;
	}
	
	public static List<MemberPostVo> postList(int start, int end) throws Exception {
		List<MemberPostVo> list = null;
		list = dao.postList(conn, start, end);
		if(list != null) {
			close();
		}
		return list;
	}
	
	public MemberPostVo postDetail(int strp_no) throws Exception {
		MemberPostVo vo = null;
		vo = dao.postDetail(conn, strp_no);
		if (vo != null) {
			close();
		}
		return vo;
	}
	
	public int upCount(int strp_no) throws Exception {
		int result = dao.upCount(conn, strp_no);
		return result;

	}

	
}
