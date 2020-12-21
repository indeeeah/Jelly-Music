package artist.more.comment.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import artist.more.comment.model.vo.ArtistCommentVO;

public class ArtistCommentDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getCommentCount(Connection con) {
		int cnt = 0;
		String sql = "select COUNT(*) from artistcomment";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return cnt;
	}
	
	public List<ArtistCommentVO> getArtComment(Connection con, String art_no){
		List<ArtistCommentVO> list = new ArrayList<ArtistCommentVO>();
		String sql = "select art.*, m.mem_name from artistcomment art join member m on art.mem_id = m.mem_id where art_no=? order by art_date desc"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, art_no);
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
	
	public int writeArtComment(Connection conn, ArtistCommentVO vo){
		int result = 0;
		
		String mem_id = vo.getMem_id();
		System.out.println(mem_id);
		String art_no = vo.getArt_no();
		System.out.println(art_no);
		String art_cont = vo.getArt_cont();
		System.out.println(art_cont);
		
		int art_co_no = vo.getArt_co_no();
		System.out.println(art_co_no);
		int art_ref= vo.getArt_ref();
		int art_step= vo.getArt_step();
		int art_level= vo.getArt_level();
		
		// 가장 큰 mu_co_no를 읽어 나오는 쿼리문
		String sql_max = "select nvl(max(art_co_no),0) from artistcomment";
		int maxBno = 0;
		try {
			pstmt = conn.prepareStatement(sql_max);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxBno = rs.getInt(1) + 1;
			} 
//			else {	// 이부분 잘 일어나지 않음
//				System.out.println("[ejkim] !!! 매우 이상한 상황임. 확인 바람 !!!");
//				maxBno = 1;		
//				return 0;	// 이부분 처리 필요함.
//			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		// insert 
		try {
			if(art_co_no==0) {	//새글, 댓글아님.
				art_ref = maxBno;
			} else {	// mu_co_no의 댓글을 의미함. update 문을 실행해야함.
				String sql_update = "update artistcomment set art_step=art_step+1 where art_ref=? and art_co_no<>art_ref and art_step>?";
				pstmt = conn.prepareStatement(sql_update);
				pstmt.setInt(1, art_ref);
				pstmt.setInt(2, art_step);
				result = pstmt.executeUpdate();
				close(pstmt);
				art_step++;
				art_level++;
			}
			
			String sql = "insert into artistcomment values (ART_COMMENT_SEQ.NEXTVAL,?,?,?,?,?,?,0,0,0,CURRENT_TIMESTAMP)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, art_no);
			pstmt.setString(3, art_cont);
			pstmt.setInt(4, art_ref);		
			pstmt.setInt(5, art_step);	
			pstmt.setInt(6, art_level);
			result = pstmt.executeUpdate();
			if(result<1) {
				System.out.println("["+mem_id+"]!!! 앨범 댓글 입력 실패 !!!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteArtComment(Connection con, int art_co_no) {
		int result = 0;
		String sql = "DELETE FROM Artistcomment WHERE art_co_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, art_co_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
