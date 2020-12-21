package member.purchase.membership.model.service;

import member.purchase.membership.model.dao.BuypackageDao;
import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.purchase.membership.model.vo.BuypackageVO;

public class BuypackageSrv {
	public int insertBuypackage(BuypackageVO vo) {
		Connection conn = getConnection();
		int result = new BuypackageDao().insertBuypackage(conn, vo);
		close(conn);
		return result;
	}
}
