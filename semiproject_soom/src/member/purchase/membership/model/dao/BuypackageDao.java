package member.purchase.membership.model.dao;
import static common.jdbcDriver.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.PreparedStatement;



import member.purchase.membership.model.vo.BuypackageVO;

public class BuypackageDao {
	private PreparedStatement pstmt;
	
	public int insertBuypackage(Connection conn, BuypackageVO vo) {
		int result = 0;
		String sql = "insert into buypackage (mem_id,ms_no,ms_p_date,ms_p_left) values(?,?,sysdate,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getMem_id());
			pstmt.setString(2,vo.getMs_no());
			pstmt.setDate(3,vo.getMs_p_left());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("BuypackageDao:"+e);
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

}
