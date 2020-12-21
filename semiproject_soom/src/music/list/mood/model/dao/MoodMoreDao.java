package music.list.mood.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import music.list.mood.model.vo.MoodMoreVO;

public class MoodMoreDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<MoodMoreVO> getMoodMoreAll(Connection conn){
		ArrayList<MoodMoreVO> list = null;
		String sql =" select * from (select rownum rnum, m.* from " 
              + "(select mo_no, mo_name, f_name from mood join allfile on mood.f_no=allfile.f_no order by mo_no asc) m ) "
          + "where rnum between 1 and 12 order by dbms_random.value";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<MoodMoreVO>();
				do {
					MoodMoreVO tvo = new MoodMoreVO();
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
			System.out.println("getMoodmoreAll:"+ e);
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;

	}
}


