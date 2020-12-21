package music.musicsearch.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import music.musicsearch.model.vo.MusicSearchVO;

public class MusicSearchDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public List<MusicSearchVO> getMusicSearchAll(Connection conn, String search) {
		List<MusicSearchVO> list = new ArrayList<MusicSearchVO>();
		String sql = "select * from (select ROWNUM rnum, mu.* from " + 
				"    (select m.mu_no, m.mu_name, art.art_no, art.art_name, al.f_no from album al " + 
				"        left outer join music m on m.al_no = al.al_no " + 
				"        left outer join artist art on m.art_no = art.art_no " + 
				"        where m.mu_name like ? order by mu_every_play desc) " + 
				"    mu) " + 
				"	where rnum >= 1 and rnum <= 6";
		String a = "%"+search+"%";
		System.out.println(a);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					MusicSearchVO vo = new MusicSearchVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_no(rs.getString("f_no"));
					vo.setAl_name(rs.getString("al_naem"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setMu_ly(rs.getString("mu_ly"));
					list.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;

	}



}
