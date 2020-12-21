package member.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.*;
import java.util.*;

import artist.more.info.model.vo.ArtistMoreVO;

public class TestSearchDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public List<ArtistMoreVO> getResearch(Connection conn, String search) {
		List<ArtistMoreVO> list = new ArrayList<ArtistMoreVO>();
		String sql = "select *  from album al" + 
				"    left outer join music m on m.al_no = al.al_no" + 
				"    left outer join artist art on m.art_no = art.art_no" + 
				"    where art.art_name like ?";
		String a = "%"+search+"%";
		System.out.println(a);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					ArtistMoreVO vo = new ArtistMoreVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setAl_name(rs.getString("al_name"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_name(rs.getString("art_name"));
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
