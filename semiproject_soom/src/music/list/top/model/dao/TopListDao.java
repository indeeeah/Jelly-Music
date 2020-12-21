package music.list.top.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static common.jdbcDriver.JDBCTemplate.close;

import music.list.top.model.vo.TopListVO;

public class TopListDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<TopListVO> getTopListAll(Connection conn){
		ArrayList<TopListVO> list = null;
		String sql ="select * from (select ROWNUM rnum, mu.* from " + 
				"    (select * from album al" + 
				"        left outer join music m on m.al_no = al.al_no" + 
				"        left outer join artist art on m.art_no = art.art_no" + 
				"        where art.art_no=? order by mu_every_play desc) " + 
				"    mu) " + 
				"where rnum >= 1 and rnum <= 100";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<TopListVO>();
				do {
					TopListVO tvo = new TopListVO();
					tvo.setAl_no(rs.getString("al_no"));
					tvo.setAl_name(rs.getString("al_name"));
					tvo.setArt_no(rs.getString("art_no"));
					tvo.setArt_name(rs.getString("art_name"));
					tvo.setMu_no(rs.getString("mu_no"));
					tvo.setMu_name(rs.getString("mu_name"));
					tvo.setMu_ly(rs.getString("mu_ly"));
					tvo.setMu_every_heart(rs.getInt("mu_every_heart"));
					list.add(tvo);
					
				}while (rs.next());
		}
		}catch (Exception e) {
			System.out.println("getTopListAll:"+ e);
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;

	}
}
