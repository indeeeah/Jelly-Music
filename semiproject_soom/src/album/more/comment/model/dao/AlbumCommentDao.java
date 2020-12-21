package album.more.comment.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import album.more.comment.model.vo.AlbumCommentVO;
import music.more.comment.model.vo.MusicCommentVO;

public class AlbumCommentDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getCommentCount(Connection con) {
		int cnt = 0;
		String sql = "select COUNT(*) from albumcomment";
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
	
	public List<AlbumCommentVO> getAlComment(Connection con, String al_no){
		List<AlbumCommentVO> list = new ArrayList<AlbumCommentVO>();
		String sql = "select al.*, m.mem_name from albumcomment al join member m on al.mem_id = m.mem_id where al_no=? order by al_date desc"; //댓글이 달리면 해당 ref 같은 글이 최상위로 올라오게 한다.
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, al_no);
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
	
	public int writeAlComment(Connection conn, AlbumCommentVO vo){
		int result = 0;
		
		String mem_id = vo.getMem_id();
		System.out.println(mem_id);
		String al_no = vo.getAl_no();
		System.out.println(al_no);
		String al_cont = vo.getAl_cont();
		System.out.println(al_cont);
		
		int al_co_no = vo.getAl_co_no();
		System.out.println(al_co_no);
		int al_ref= vo.getAl_ref();
		int al_step= vo.getAl_step();
		int al_level= vo.getAl_level();
		
		// 가장 큰 mu_co_no를 읽어 나오는 쿼리문
		String sql_max = "select nvl(max(al_co_no),0) from albumcomment";
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
			if(al_co_no==0) {	//새글, 댓글아님.
				al_ref = maxBno;
			} else {	// mu_co_no의 댓글을 의미함. update 문을 실행해야함.
				String sql_update = "update albumcomment set al_step=al_step+1 where al_ref=? and al_co_no<>al_ref and al_step>?";
				pstmt = conn.prepareStatement(sql_update);
				pstmt.setInt(1, al_ref);
				pstmt.setInt(2, al_step);
				result = pstmt.executeUpdate();
				close(pstmt);
				al_step++;
				al_level++;
			}
			
			String sql = "insert into albumcomment values (AL_COMMENT_SEQ.NEXTVAL,?,?,?,?,?,?,0,0,0,CURRENT_TIMESTAMP)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, al_no);
			pstmt.setString(3, al_cont);
			pstmt.setInt(4, al_ref);		
			pstmt.setInt(5, al_step);	
			pstmt.setInt(6, al_level);
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
	
	public int deleteAlComment(Connection con, int al_co_no) {
		int result = 0;
		String sql = "DELETE FROM albumcomment WHERE al_co_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, al_co_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
}
