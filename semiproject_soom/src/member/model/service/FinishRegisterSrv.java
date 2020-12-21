package member.model.service;

import static common.jdbcDriver.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import member.model.dao.FinishRegisterDao;
import member.model.vo.FinishRegisterVO;

public class FinishRegisterSrv {

	public List<FinishRegisterVO> helloToMem(String mem_id) {
		Connection conn = getConnection();
		List<FinishRegisterVO> mvo = new FinishRegisterDao().helloToMem(conn, mem_id);
		close(conn);
		return mvo;
	}

	public List<FinishRegisterVO> searchWord() {
		Connection conn = getConnection();
		List<FinishRegisterVO> svo = new FinishRegisterDao().searchWord(conn);
		close(conn);
		return svo;
	}

	public int frMakeCurrmusic(String mem_id) {
		Connection conn = getConnection();
		int result = 0;
		try {
			conn.setAutoCommit(false);
			result = new FinishRegisterDao().frMakeCurrmusic(conn, mem_id);
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
