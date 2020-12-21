package member.purchase.cash.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import static common.jdbcDriver.JDBCTemplate.close;
import member.purchase.cash.model.vo.CashVO;

public class CashDao {
	private PreparedStatement pstmt;
	public int insertCash(Connection conn, CashVO vo) {
		int result = 0;
		String sql = "insert into Cash (memid,cs_price,cs_left) valuse(?,?,?)";
		System.out.println("a5: " + vo.toString());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getMem_id());
			pstmt.setInt(2,vo.getCs_price());
			pstmt.setInt(3,vo.getCs_left());
			System.out.println("a6");
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("CashDao :"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("a7:" + result);
		return result;
	}
}
