package artist.search.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import artist.more.info.model.vo.ArtistMoreVO;

public class ArtistSearchDao {
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<ArtistMoreVO> getArtistSearch(Connection conn, String art_no) {
		List<ArtistMoreVO> list = new ArrayList<ArtistMoreVO>();
		String sql = "select al.al_no, al.al_name, art.art_no, art.art_name, m.mu_no, m.mu_name, al.f_no, m.mu_ly  from album al\r\n" + 
				"    left outer join music m on m.al_no = al.al_no\r\n" + 
				"    left outer join artist art on m.art_no = art.art_no where art.art_no = ? order by mu_every_play";
		String a = "%"+art_no+"%";
		System.out.println(a);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, art_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					ArtistMoreVO vo = new ArtistMoreVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setAl_name(rs.getString("al_name"));
					vo.setF_no(rs.getString("f_no"));
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
