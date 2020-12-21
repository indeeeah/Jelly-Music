package music.more.comment.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import music.more.comment.model.vo.*;

public class MusicCommentDao {
	
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getCommentCount(Connection con) {
		int cnt = 0;
		String sql = "select COUNT(*) from musiccomment";
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
	
	public List<MusicCommentVO> getCommentAll(Connection con, String mu_no){
		List<MusicCommentVO> list = new ArrayList<MusicCommentVO>();
		String sql = "select mc.*, m.mem_name from musiccomment mc join member m on mc.mem_id = m.mem_id  where mc.mu_no=? order by mu_date desc"; //댓글이 달리면 해당 ref 같은 글이 최상위로 올라오게 한다.
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, mu_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					MusicCommentVO vo = new MusicCommentVO();
					vo.setMem_id(rs.getString("mem_id"));
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_co_no(rs.getInt("mu_co_no"));
					vo.setMu_cont(rs.getString("mu_cont"));
					vo.setMu_ref(rs.getInt("mu_ref"));
					vo.setMu_step(rs.getInt("mu_step"));
					vo.setMu_level(rs.getInt("mu_level"));
					vo.setMu_likes(rs.getInt("mu_likes"));
					vo.setMu_hates(rs.getInt("mu_hates"));
					vo.setMu_report(rs.getInt("mu_report"));
					vo.setMu_date(rs.getDate("mu_date"));
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
	
	public List<MusicCommentVO> getCommentByPage(Connection conn, int start, int end){
		List<MusicCommentVO> list = new ArrayList<MusicCommentVO>();
		String sql = "select * from "
				+ "(select ROWNUM rnum, d.* from "
				+ "(select * from musiccomment order by mu_ref desc, mu_step asc) "
				+ "d) "
				+ "where rnum >= ? and rnum <= ?"; 
		/*
		 * String sql = "select * from " + "(select ROWNUM rnum, d.* from " +
		 * "(select * from musiccomment order by mu_ref desc, mu_step asc) " + "d) " +
		 * "where rnum >= ? and rnum <= ?";
		 */		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					MusicCommentVO vo = new MusicCommentVO();
					vo.setMem_id(rs.getString("mem_id"));
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_co_no(rs.getInt("mu_co_no"));
					vo.setMu_ref(rs.getInt("mu_ref"));
					vo.setMu_step(rs.getInt("mu_step"));
					vo.setMu_level(rs.getInt("mu_level"));
					vo.setMu_likes(rs.getInt("mu_likes"));
					vo.setMu_hates(rs.getInt("mu_hates"));
					vo.setMu_report(rs.getInt("mu_report"));
					vo.setMu_date(rs.getDate("mu_date"));
					vo.setMu_cont(rs.getString("mu_cont"));
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
	
	public List<MusicCommentVO> getComment(Connection conn, int mu_co_no){
		List<MusicCommentVO> list = new ArrayList<MusicCommentVO>();
		String sql = "select * from musiccomment where mu_co_no= " + mu_co_no;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					MusicCommentVO vo = new MusicCommentVO();
					vo.setMem_id(rs.getString("mem_id"));
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_co_no(rs.getInt("mu_co_no"));
					vo.setMu_ref(rs.getInt("mu_ref"));
					vo.setMu_step(rs.getInt("mu_step"));
					vo.setMu_level(rs.getInt("mu_level"));
					vo.setMu_likes(rs.getInt("mu_likes"));
					vo.setMu_hates(rs.getInt("mu_hates"));
					vo.setMu_report(rs.getInt("mu_report"));
					vo.setMu_date(rs.getDate("mu_date"));
					vo.setMu_cont(rs.getString("mu_cont"));
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
	
	public int writeMuComment(Connection conn, MusicCommentVO vo){
		int result = 0;
		
		String mem_id = vo.getMem_id();
		String mu_no = vo.getMu_no();
		String mu_cont = vo.getMu_cont();
		
		int mu_co_no = vo.getMu_co_no();
		int mu_ref= vo.getMu_ref();
		int mu_step= vo.getMu_step();
		int mu_level= vo.getMu_level();
		
		// 가장 큰 mu_co_no를 읽어 나오는 쿼리문
		String sql_max = "select nvl(max(mu_co_no),0) from musiccomment";
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
			if(mu_co_no==0) {	//새글, 댓글아님.
				mu_ref = maxBno;
			} else {	// mu_co_no의 댓글을 의미함. update 문을 실행해야함.
				String sql_update = "update musiccomment set mu_step=mu_step+1 where mu_ref=? and mu_co_no<>mu_ref and mu_step>?";
				pstmt = conn.prepareStatement(sql_update);
				pstmt.setInt(1, mu_ref);
				pstmt.setInt(2, mu_step);
				result = pstmt.executeUpdate();
				close(pstmt);
				mu_step++;
				mu_level++;
			}
			
			String sql = "insert into musiccomment values (MU_COMMENT_SEQ.NEXTVAL,?,?,?,?,?,?,0,0,0,CURRENT_TIMESTAMP)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mu_no);
			pstmt.setString(3, mu_cont);
			pstmt.setInt(4, mu_ref);		
			pstmt.setInt(5, mu_step);	
			pstmt.setInt(6, mu_level);
			result = pstmt.executeUpdate();
			if(result<1) {
				System.out.println("["+mem_id+"]!!! 노래 댓글 입력 실패 !!!");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMuComment(Connection con, int mu_co_no) {
		int result = 0;
		String sql = "DELETE FROM musiccomment WHERE mu_co_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mu_co_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int getMusicCommentLikes(Connection con, String mem_id, int mu_co_no) {
		int result=0;
		String sql = "insert into likes (mem_id, mu_co_no) values(?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_co_no);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		String sql_up = "update musiccomment set mu_likes = (select count(*) from likes where=?) where =?";
		try {
			pstmt = con.prepareStatement(sql_up);
			pstmt.setInt(1, mu_co_no);
			pstmt.setInt(2, mu_co_no);
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return result;
	}
	
	public int getMusicCommenthates(Connection con, String mem_id, int mu_co_no) {
		String sql = "insert into likes (mem_id, mu_co_no) values(?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_co_no);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return -1;
	}
	
	public int getMusicCommentReport(Connection con, String mem_id, int mu_co_no) {
		String sql = "insert into likes (mem_id, mu_co_no) values(?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_co_no);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return -1;
	}
}
