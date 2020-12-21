package post.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import post.model.vo.PostVO;

public class PostDao {

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public int getQuesCount(Connection conn) {
		int cnt = 0;
		String sql = "select COUNT(*) from question";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return cnt;
	}

	public List<PostVO> getQuesAll(Connection conn) {
		List<PostVO> list = new ArrayList<PostVO>();
		String sql = "select * from question order by que_ref desc, que_step asc"; // 댓글이 달리면 해당 ref 같은 글이 최상위로 올라오게 한다.
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					PostVO vo = new PostVO();
					vo.setQue_no(rs.getInt("que_no"));
					vo.setMem_id(rs.getString("mem_id"));
					vo.setQue_name(rs.getString("que_name"));
					vo.setQue_content(rs.getString("que_content"));
					vo.setQue_file(rs.getString("que_file"));
					vo.setQue_ref(rs.getInt("que_ref"));
					vo.setQue_step(rs.getInt("que_step"));
					vo.setQue_level(rs.getInt("que_level"));
					vo.setQue_cnt(rs.getInt("que_cnt"));
					vo.setQue_date(rs.getDate("que_date"));
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

	public List<PostVO> getQuesByPage(Connection conn, int start, int end) {
		List<PostVO> list = new ArrayList<PostVO>();
		String sql = "select * from " + "(select ROWNUM rnum, d.* from "
				+ "(select * from question order by que_ref desc, que_step asc) " + "d) " + "where rnum >= ? and rnum <= ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					PostVO vo = new PostVO();
					vo.setQue_no(rs.getInt("que_no"));
					vo.setMem_id(rs.getString("mem_id"));
					vo.setQue_name(rs.getString("que_name"));
					vo.setQue_content(rs.getString("que_content"));
					vo.setQue_file(rs.getString("que_file"));
					vo.setQue_secret(rs.getString("que_secret"));
					vo.setQue_ref(rs.getInt("que_ref"));
					vo.setQue_step(rs.getInt("que_step"));
					vo.setQue_level(rs.getInt("que_level"));
					vo.setQue_cnt(rs.getInt("que_cnt"));
					vo.setQue_date(rs.getDate("que_date"));
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

	public List<PostVO> getQues(Connection conn, int que_no) {
		List<PostVO> list = new ArrayList<PostVO>();
		String sql = "select * from question where que_no =" + que_no;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					PostVO vo = new PostVO();
					vo.setQue_no(rs.getInt("que_no"));
					vo.setMem_id(rs.getString("mem_id"));
					vo.setQue_name(rs.getString("que_name"));
					vo.setQue_content(rs.getString("que_content"));
					vo.setQue_file(rs.getString("que_file"));
					vo.setQue_secret(rs.getString("que_secret"));
					vo.setQue_ref(rs.getInt("que_ref"));
					vo.setQue_step(rs.getInt("que_step"));
					vo.setQue_level(rs.getInt("que_level"));
					vo.setQue_cnt(rs.getInt("que_cnt"));
					vo.setQue_date(rs.getDate("que_date"));
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

	public int writeQues(Connection conn, PostVO vo) {
		int result = 0;

		String mem_id = vo.getMem_id();
		String que_name = vo.getQue_name();
		String que_content = vo.getQue_content();
		String que_file = vo.getQue_file();
		String que_secret = vo.getQue_secret();

		int que_no = vo.getQue_no();
		int que_ref = vo.getQue_ref();
		int que_step = vo.getQue_step();
		int que_level = vo.getQue_level();

		// 가장 큰 bno를 읽어 나오는 쿼리문
		String sql_max = "select nvl(max(que_no),0) from question";
		int maxQue_no = 0;
		try {
			pstmt = conn.prepareStatement(sql_max);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxQue_no = rs.getInt(1) + 1;
			}
//			else {	// 이부분 잘 일어나지 않음
//				System.out.println("[ejkim] !!! 매우 이상한 상황임. 확인 바람 !!!");
//				maxBno = 1;		
//				return 0;	// 이부분 처리 필요함.
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			// JdbcDAO.close(conn); 쓰지 않음 ~ 밑에 더 쓸거라서
		}

		// insert
		try {
			if (maxQue_no == 0) { // 새글, 댓글아님.
				que_ref = maxQue_no;
			} else { // bno의 댓글을 의미함. update 문을 실행해야함.
				String sql_update = "update question set que_step=que_step+1 where que_ref=? and que_no<>que_ref and que_step>?";
//				String sql_update = "update question set que_step= " + (que_step+1) +
//						" where que_ref=" + que_ref + " and que_no<>que_ref " + 
//						" and que_step>" + que_step;
				pstmt = conn.prepareStatement(sql_update);
//				pstmt.setInt(1, que_ref+1);
				pstmt.setInt(1, que_ref);
				pstmt.setInt(2, que_step);
				result = pstmt.executeUpdate();
				close(pstmt);
				que_step++;
				que_level++;
			}

			String sql = "insert into question values (?,?,?,?,?,?,?,?,0,CURRENT_TIMESTAMP,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxQue_no); // bno
			pstmt.setInt(6, que_ref); // ref
			pstmt.setInt(7, que_step); // re_step
			pstmt.setInt(8, que_level);// re_level
			pstmt.setString(2, mem_id);
			pstmt.setString(3, que_name);
			pstmt.setString(4, que_content);
			pstmt.setString(5, que_file);
			pstmt.setString(9, que_secret);
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("[ejkim]!!! insert 실패 !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateQues(Connection con, int que_no, String que_name, String que_content, String que_file) {
		int result = 0;
		String sql = "UPDATE question SET que_name=?, que_content = ?, que_file=?  WHERE que_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, que_name);
			pstmt.setString(2, que_content);
			pstmt.setString(3, que_file);
			pstmt.setInt(4, que_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteQues(Connection con, int que_no) {
		int result = 0;
		String sql = "DELETE FROM question WHERE que_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, que_no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int getQuesCnt(Connection conn, int que_no) {
		int result = 0;
		String sql = "update question set que_cnt=que_cnt+1 where que_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, que_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	public List<PostVO> getQuesWriter(Connection conn, String quesSearch, int startRnum, int endRnum) {
		List<PostVO> list = new ArrayList<PostVO>();
		String sql = "select * from (select ROWNUM rnum, d.* from (select * from question where mem_id=? order by que_ref desc, que_step asc) d) where rnum >= ? and rnum <= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, quesSearch);
			pstmt.setInt(2, startRnum);
			pstmt.setInt(3, endRnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					PostVO vo = new PostVO();
					vo.setQue_no(rs.getInt("que_no"));
					vo.setMem_id(rs.getString("mem_id"));
					vo.setQue_name(rs.getString("que_name"));
					vo.setQue_content(rs.getString("que_content"));
					vo.setQue_file(rs.getString("que_file"));
					vo.setQue_secret(rs.getString("que_secret"));
					vo.setQue_ref(rs.getInt("que_ref"));
					vo.setQue_step(rs.getInt("que_step"));
					vo.setQue_level(rs.getInt("que_level"));
					vo.setQue_cnt(rs.getInt("que_cnt"));
					vo.setQue_date(rs.getDate("que_date"));
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
	
	public int getQuesWriterCount(Connection conn, String quesSearch) {
		int cnt = 0;
		String sql = "select COUNT(*) from question where mem_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, quesSearch);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return cnt;
	}
}
