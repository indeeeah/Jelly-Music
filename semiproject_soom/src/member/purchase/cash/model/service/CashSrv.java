package member.purchase.cash.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.purchase.cash.model.dao.CashDao;
import member.purchase.cash.model.vo.CashVO;

public class CashSrv {
	public int insertCash(CashVO vo) {
		Connection conn = getConnection();
		int result = new CashDao().insertCash(conn, vo);
		close(conn);
		return result;
	}

}
