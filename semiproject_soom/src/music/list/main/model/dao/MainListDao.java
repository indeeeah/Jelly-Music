package music.list.main.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import music.list.main.model.vo.MainListVO;

public class MainListDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<MainListVO> get1to5Heart(Connection conn) {
		List<MainListVO> hvo = new ArrayList<MainListVO>();
		String sql = "select * from (select rownum rnum, m.* "
				+ "from (select mu_every_heart, mu_name, art_name, f_name, music.mu_no  "
				+ "from music join artist "
				+ "on music.art_no=artist.art_no "
				+ "inner join allfile "
				+ "on artist.f_no=allfile.f_no "
				+ "order by mu_every_heart desc) m) "
				+ "where rnum between 1 and 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainListVO vo = new MainListVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					hvo.add(vo);
					System.out.println("top 6 to 10 date good");
				} while (rs.next());
			} else {
				System.out.println("top 6 to 10 date is null");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return hvo;
	}
	
	public List<MainListVO> get6to10Heart(Connection conn) {
		List<MainListVO> hvo = new ArrayList<MainListVO>();
		String sql = "select * from (select rownum rnum, m.* "
				+ "from (select mu_every_heart, mu_name, art_name, f_name, music.mu_no  "
				+ "from music join artist "
				+ "on music.art_no=artist.art_no "
				+ "inner join allfile "
				+ "on artist.f_no=allfile.f_no "
				+ "order by mu_every_heart desc) m) "
				+ "where rnum between 6 and 10";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainListVO vo = new MainListVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					hvo.add(vo);
					System.out.println("top 6 to 10 date good");
				} while (rs.next());
			} else {
				System.out.println("top 6 to 10 date is null");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return hvo;
	}
	
	

	public List<MainListVO> getMoodAllt(Connection conn) {
		List<MainListVO> mvo = new ArrayList<MainListVO>();
		String sql = "select * from (select rownum rnum, m.* "
				+ "from (select mo_no, f_name, mo_name, mood.f_no "
				+ "from mood, allfile where mood.f_no=allfile.f_no) m) "
				+ "where rnum between 1 and 5";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainListVO vo = new MainListVO();
					vo.setF_no(rs.getString("f_no"));
					vo.setMo_name(rs.getString("mo_name"));
					vo.setF_name(rs.getString("f_name"));
					mvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return mvo;
	}
	
	public List<MainListVO> getMoodAlld(Connection conn) {
		List<MainListVO> mvo = new ArrayList<MainListVO>();
		String sql = "select * from (select rownum rnum, m.* "
				+ "from (select mo_no, f_name, mo_name, mood.f_no "
				+ "from mood, allfile where mood.f_no=allfile.f_no) m) "
				+ "where rnum between 6 and 10";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					MainListVO vo = new MainListVO();
					vo.setF_no(rs.getString("f_no"));
					vo.setMo_name(rs.getString("mo_name"));
					vo.setF_name(rs.getString("f_name"));
					mvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return mvo;
	}
	
}
