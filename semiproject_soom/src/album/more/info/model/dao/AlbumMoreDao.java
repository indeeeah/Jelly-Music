package album.more.info.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import album.more.comment.model.vo.AlbumCommentVO;
import album.more.info.model.vo.AlbumMoreVO;

public class AlbumMoreDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 앨범 소개
	public List<AlbumMoreVO> getAlbumInfo(Connection conn, String al_no){
		List<AlbumMoreVO> list = new ArrayList<AlbumMoreVO>();
		String sql = "select distinct m.al_no, m.art_no, al_name, art_name, al_release, al.f_no, al_intro from music m " + 
				"    left outer join album al on m.al_no = al.al_no " + 
				"    left outer join artist art on m.art_no = art.art_no " + 
				"    where m.al_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, al_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					AlbumMoreVO vo = new AlbumMoreVO();
					vo.setAl_no(rs.getString("al_no"));
					vo.setAl_name(rs.getString("al_name")); 
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setAl_intro(rs.getString("al_intro"));
					vo.setAl_release(rs.getDate("al_release"));
					vo.setF_no(rs.getString("f_no"));
					list.add(vo);
				}while(rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
		
	// 수록곡
	public List<AlbumMoreVO> getIncludeMu(Connection conn, String al_no){
		List<AlbumMoreVO> slist = new ArrayList<AlbumMoreVO>();
		String sql = "select mu_no, mu_name, art.art_no, art_name, mu_ly, al.al_no, al.al_name, al.f_no from music m" + 
				"    left outer join album al on m.al_no = al.al_no" + 
				"    left outer join artist art on m.art_no = art.art_no" + 
				"    where al.al_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, al_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					AlbumMoreVO vo = new AlbumMoreVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setAl_name(rs.getString("al_name"));
					vo.setMu_ly(rs.getString("mu_ly"));
					vo.setF_no(rs.getString("f_no"));
					slist.add(vo);
				}while(rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return slist;
		
	}
	
	// 싱글
	public List<AlbumMoreVO> getSingles(Connection conn, String al_no){
		List<AlbumMoreVO> list = new ArrayList<AlbumMoreVO>();
		String sql = "select distinct al_name, al.al_no, art_name, art.art_no, al.f_no from music m" + 
				"    left outer join album al on m.al_no = al.al_no" + 
				"    left outer join artist art on m.art_no = art.art_no" + 
				"    where art_name=(select distinct art_name from music m" + 
				"    left outer join album al on m.al_no = al.al_no" + 
				"    left outer join artist art on m.art_no = art.art_no" + 
				"    where al.al_no=?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, al_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					AlbumMoreVO vo = new AlbumMoreVO();
					vo.setAl_name(rs.getString("al_name"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setF_no(rs.getString("f_no"));
					list.add(vo);
				}while(rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	// 비슷한 앨범
	public List<AlbumMoreVO> getAlike(Connection conn, String al_no){
		List<AlbumMoreVO> list = new ArrayList<AlbumMoreVO>();
		String sql = "select * from (select rownum rnum, s.* from (select al.al_no, al.al_name, art.art_no, art.art_name, al.f_no from music m\r\n" + 
				"    left outer join album al on m.al_no = al.al_no\r\n" + 
				"    left outer join artist art on m.art_no = art.art_no\r\n" + 
				"where m.mu_genre in(select distinct mu_genre from music m\r\n" + 
				"                        left outer join album al on m.al_no = al.al_no\r\n" + 
				"                        left outer join artist art on m.art_no = art.art_no\r\n" + 
				"                    where al.al_no = ?) and not al.al_no=? order by mu_every_play) s) where rnum <7";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, al_no);
			pstmt.setString(2, al_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					AlbumMoreVO vo = new AlbumMoreVO();
					vo.setAl_name(rs.getString("al_name"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setF_no(rs.getString("f_no"));
					list.add(vo);
				}while(rs.next());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	// 댓글 	
	public List<AlbumCommentVO> getCommentAll(Connection con){
		List<AlbumCommentVO> list = new ArrayList<AlbumCommentVO>();
		String sql = "select al.*, m.mem_name from albumcomment al join member m on al.mem_id = m.mem_id  order by al_date desc"; //댓글이 달리면 해당 ref 같은 글이 최상위로 올라오게 한다.
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					AlbumCommentVO vo = new AlbumCommentVO();
					vo.setMem_id(rs.getString("mem_id"));
					vo.setAl_no(rs.getString("al_no"));
					vo.setAl_co_no(rs.getInt("al_co_no"));
					vo.setAl_cont(rs.getString("al_cont"));
					vo.setAl_ref(rs.getInt("al_ref"));
					vo.setAl_step(rs.getInt("al_step"));
					vo.setAl_level(rs.getInt("al_level"));
					vo.setAl_likes(rs.getInt("al_likes"));
					vo.setAl_hates(rs.getInt("al_hates"));
					vo.setAl_report(rs.getInt("al_report"));
					vo.setAl_date(rs.getDate("al_date"));
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
