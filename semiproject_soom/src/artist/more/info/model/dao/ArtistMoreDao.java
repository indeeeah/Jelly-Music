package artist.more.info.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import artist.more.comment.model.vo.ArtistCommentVO;
import artist.more.info.model.vo.ArtistMoreVO;

public class ArtistMoreDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 아티스트 소개
	public List<ArtistMoreVO> getArtistInfo(Connection conn, String art_no) {
		List<ArtistMoreVO> list = new ArrayList<ArtistMoreVO>();
		String sql = "select distinct m.art_no, art_name, art_intro, art.f_no from music m \r\n" + 
				"    left outer join album al on m.al_no = al.al_no \r\n" + 
				"    left outer join artist art on m.art_no = art.art_no\r\n" + 
				"    where art.art_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, art_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					ArtistMoreVO vo = new ArtistMoreVO();
					vo.setArt_name(rs.getString("art_name"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_intro(rs.getString("art_intro"));
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

	// 대표곡
	public List<ArtistMoreVO> getTracks(Connection conn, String art_no) {
		List<ArtistMoreVO> slist = new ArrayList<ArtistMoreVO>();
		String sql = "select * from (select ROWNUM rnum, mu.* from " + 
				"    (select * from album al" + 
				"        left outer join music m on m.al_no = al.al_no" + 
				"        left outer join artist art on m.art_no = art.art_no" + 
				"        where art.art_no=? order by mu_every_play desc) " + 
				"    mu) " + 
				"where rnum >= 1 and rnum <= 5";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, art_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					ArtistMoreVO vo = new ArtistMoreVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setAl_name(rs.getString("al_name"));
					vo.setMu_ly(rs.getString("mu_ly"));
					slist.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return slist;

	}

	// 싱글
	public List<ArtistMoreVO> getSingles(Connection conn, String art_no) {
		List<ArtistMoreVO> list = new ArrayList<ArtistMoreVO>();
		String sql = "select distinct al_name, al.al_no, art_name, art.art_no  from album al" + 
				"    left outer join music m on m.al_no = al.al_no" + 
				"    left outer join artist art on m.art_no = art.art_no" + 
				"    where art.art_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, art_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					ArtistMoreVO vo = new ArtistMoreVO();
					vo.setAl_name(rs.getString("al_name"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setArt_no(rs.getString("art_no"));
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

	// 비슷한 아티스트
	public List<ArtistMoreVO> getSimilar(Connection conn, String art_no) {
		List<ArtistMoreVO> list = new ArrayList<ArtistMoreVO>();
		String sql = "select * from (select rownum rnum, s.* from (select m.mu_no, m.mu_name, al.al_no, art.art_no, art.art_name, m.mu_mood, m.mu_every_play, art.f_no from music m\r\n" + 
				"    left outer join album al on m.al_no = al.al_no\r\n" + 
				"    left outer join artist art on m.art_no = art.art_no\r\n" + 
				"where m.mu_genre in(select distinct mu_genre from music m\r\n" + 
				"                        left outer join album al on m.al_no = al.al_no\r\n" + 
				"                        left outer join artist art on m.art_no = art.art_no\r\n" + 
				"                    where art.art_no = ?) and not art.art_no=? order by mu_every_play) s) where rnum <7";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, art_no);
			pstmt.setString(2, art_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					ArtistMoreVO vo = new ArtistMoreVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setMu_mood(rs.getInt("mu_mood"));
					vo.setMu_every_play(rs.getInt("mu_every_play"));
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

	// 아티스트 댓글
	public List<ArtistCommentVO> getArtComment(Connection con){
		List<ArtistCommentVO> list = new ArrayList<ArtistCommentVO>();
		String sql = "select art.*, m.mem_name from artistcomment art join member m on art.mem_id = m.mem_id  order by art_date desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					ArtistCommentVO vo = new ArtistCommentVO();
					vo.setMem_id(rs.getString("mem_id"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_co_no(rs.getInt("art_co_no"));
					vo.setArt_cont(rs.getString("art_cont"));
					vo.setArt_ref(rs.getInt("art_ref"));
					vo.setArt_step(rs.getInt("art_step"));
					vo.setArt_level(rs.getInt("art_level"));
					vo.setArt_likes(rs.getInt("art_likes"));
					vo.setArt_hates(rs.getInt("art_hates"));
					vo.setArt_report(rs.getInt("art_report"));
					vo.setArt_date(rs.getDate("art_date"));
					vo.setMem_name(rs.getString("mem_name"));
					list.add(vo);
				} while(rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
}
