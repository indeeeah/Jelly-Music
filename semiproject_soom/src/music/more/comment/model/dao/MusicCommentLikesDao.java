package music.more.comment.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import music.more.comment.model.vo.MusicCommentLikesVO;
import music.more.comment.model.vo.MusicCommentVO;

public class MusicCommentLikesDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	


	public int insertLike(Connection conn, String mem_id, int mu_co_no) {
		int result = 0;
		String sql = "delete from contdislike where mem_id=? and mu_co_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_co_no);
			result = pstmt.executeUpdate();

			sql = "insert into contlike (mem_id, mu_co_no) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_co_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertDisLike(Connection conn, String mem_id, int mu_co_no) {
		int result = 0;
		String sql = "delete from contlike where mem_id=? and mu_co_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_co_no);
			result = pstmt.executeUpdate();

			sql = "insert into contdislike (mem_id, mu_co_no) values (?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_co_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int getMusicCommentLikeCount(Connection conn, int mu_co_no) {
		int likesCnt = 0;
		String sql = "select count(*) from contlike where mu_co_no=?";
		MusicCommentVO vo = new MusicCommentVO();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mu_co_no);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return likesCnt;
	}
	
	public HashMap<String, Integer> getLikeDislikeCount(Connection conn, int mu_co_no1, int mu_co_no2) {
		HashMap<String, Integer> map = null;
		String sql = "select (select count(*) from contlike where mu_co_no = ?) as likecnt, " + 
				"(select count(*) from contdislike where mu_co_no =?) as dislikecnt from dual";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mu_co_no1);
			pstmt.setInt(2, mu_co_no2);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				map = new HashMap<String, Integer>();
				map.put("likecnt", rs.getInt("likecnt"));
				map.put("dislikecnt", rs.getInt("dislikecnt"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return map;
	} 
	
	public int addReport(Connection conn, String mem_id, int mu_co_no, String report_reason, String report_content) {
		int result = 0;
		String sql = "insert into report (mem_id, mu_co_no, report_reason, report_content) values (?,?,?,?)";
		try {
			MusicCommentLikesVO vo = new MusicCommentLikesVO();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, mu_co_no);
			pstmt.setString(3, report_reason);
			pstmt.setString(4, report_content);
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("댓글 신고 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}
		

}

//	public int getMusicCommentLike(Connection con, String mem_id, int mu_co_no) {
//		String sql = "insert into likes (mem_id, mu_co_no) values(?,?)";
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setInt(2, mu_co_no);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//
//		return -1;
//	}
//
//	public int getMusicCommenthate(Connection con, String mem_id, int mu_co_no) {
//		String sql = "insert into likes (mem_id, mu_co_no) values(?,?)";
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setInt(2, mu_co_no);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//
//		return -1;
//	}
//
//	public int getMusicCommentReport(Connection con, String mem_id, int mu_co_no) {
//		String sql = "insert into likes (mem_id, mu_co_no) values(?,?)";
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setInt(2, mu_co_no);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//
//		return -1;
//	}
//
//	public int isLikeorHateExist(Connection conn, int mu_co_no, String mem_id) {
//		int result = 0;
//		String sql = "select mem_likeorhate from musiccmlikeorhate where mu_co_no=? and mem_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			pstmt.setString(2, mem_id);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				result = rs.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			result = 0;
//			System.out.println(result + "좋아요나 싫어요 누른적 없음");
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		System.out.println(result);
//		return result;
//	}
//
//	public int pressLikeInsert(Connection conn, int mu_co_no, String mem_id) {
//		int result = 0;
//		String sql = "insert into musiccmlikeorhate values (?,?,1)";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			pstmt.setString(2, mem_id);
//			result = pstmt.executeUpdate();
//			if (result < 1) {
//				System.out.println("like press fail");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//
//	}
//
//	public int pressHateInsert(Connection conn, int mu_co_no, String mem_id) {
//		int result = 0;
//		String sql = "insert into musiccmlikeorhate values (?,?,-1)";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			pstmt.setString(2, mem_id);
//			result = pstmt.executeUpdate();
//			if (result < 1) {
//				System.out.println("hate press fail");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//
//	}
//
//	public int addLikeUpdate(Connection conn, int mu_co_no) {
//		int result = 0;
//		String sql = "update musiccomment into mu_likes=mu_likes+1 where mu_co_no=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//
//	public int addHateUpdate(Connection conn, int mu_co_no) {
//		int result = 0;
//		String sql = "update musiccomment into mu_hates=mu_hates+1 where mu_co_no=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//
//	public int minusLikeUpdate(Connection conn, int mu_co_no) {
//		int result = 0;
//		String sql = "update musiccomment into mu_likes=mu_likes-1 where mu_co_no=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//
//	public int minusHateUpdate(Connection conn, int mu_co_no) {
//		int result = 0;
//		String sql = "update musiccomment into mu_hates=mu_hates-1 where mu_co_no=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//
//	public int makeUpdatetoZero(Connection conn, int mu_co_no, String mem_id) {
//		int result = 0;
//		String sql = "update musiccmlikeorhate set mem_likeorhate=0 where mu_co_no=? and mem_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			pstmt.setString(2, mem_id);
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//
//	public int makeUpdatetoLike(Connection conn, int mu_co_no, String mem_id) {
//		int result = 0;
//		String sql = "update musiccmlikeorhate set mem_likeorhate=1 where mu_co_no=? and mem_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			pstmt.setString(2, mem_id);
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//
//	public int makeUpdatetoHate(Connection conn, int mu_co_no, String mem_id) {
//		int result = 0;
//		String sql = "update musiccmlikeorhate set mem_likeorhate=-1 where mu_co_no=? and mem_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, mu_co_no);
//			pstmt.setString(2, mem_id);
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//
//	//////////////////////////////////////////////////////////////////////////////////////////