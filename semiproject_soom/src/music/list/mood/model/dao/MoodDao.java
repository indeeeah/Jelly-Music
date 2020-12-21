package music.list.mood.model.dao;
import static common.jdbcDriver.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import music.list.mood.model.vo.MoodVO;

public class MoodDao {
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	public List<MoodVO> setMoodAll(Connection conn){
		List<MoodVO> Mvo = new ArrayList<MoodVO>();
		String sql = " select * from (select rownum rnum, m.* from " 
              + "(select mo_no, mo_name, f_name from mood join allfile on mood.f_no=allfile.f_no order by mo_no asc) m ) "
          + "where rnum between 1 and 12 order by dbms_random.value";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					MoodVO vo = new MoodVO();
					vo.setMd_no(rs.getString("mo_no"));
					vo.setMd_name(rs.getString("mo_name"));
					vo.setF_no(rs.getString("f_no"));
					Mvo.add(vo);
				}while (rs.next());
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
		
		return Mvo;
		
	}
}
