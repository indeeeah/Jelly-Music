package member.purchase.membership.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import member.purchase.membership.model.vo.MembershipVO;

public class MembershipDao {

	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArrayList<MembershipVO> getMembershipAll(Connection conn) {
		ArrayList<MembershipVO> list = null;
		String sql = "select * from membership";
		try {		
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList<MembershipVO>();
				do {
					MembershipVO vo = new MembershipVO();
					vo.setMs_no(rs.getString("ms_no"));
					vo.setMs_type(rs.getString("ms_type"));
					vo.setMs_price(rs.getInt("ms_price"));
					list.add(vo);
					System.out.println("getMembershipAll add list");
				} while (rs.next());
			}
		} catch (Exception e) {
			System.out.println("getMembershipAll:" + e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

}
