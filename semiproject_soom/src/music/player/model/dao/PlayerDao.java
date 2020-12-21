package music.player.model.dao;

import static common.jdbcDriver.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import music.player.model.vo.PlayerVO;

public class PlayerDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<PlayerVO> getMyListAll(Connection conn, String mem_id) {
		List<PlayerVO> pvo = new ArrayList<PlayerVO>();
		String sql = "select mem_id, mu_name, al_name, art_name, play_date, f_name, music.mu_no, mu_ly "
				+ "from music join album on music.al_no = album.al_no "
				+ "inner join artist on music.art_no = artist.art_no "
				+ "inner join allfile on album.f_no = allfile.f_no "
				+ "inner join musichistory on music.mu_no = musichistory.mu_no "
				+ "where mem_id=? and play_now='Y' order by play_date desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					PlayerVO vo = new PlayerVO();
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setAl_name(rs.getString("al_name"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					vo.setMu_ly(rs.getString("mu_ly"));
					pvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return pvo;
	}

//	public List<PlayerVO> memberProf(Connection conn, String mem_id) {
//		List<PlayerVO> mvo = new ArrayList<PlayerVO>();
//		String sql = "select * from member where mem_id=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				do {
//					PlayerVO vo = new PlayerVO();
//					vo.setMem_prof(rs.getString("mem_prof"));
//					mvo.add(vo);
//				} while (rs.next());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return mvo;
//	}

	public int clickHeart(Connection conn, String mem_id, String mu_no) {
//		PlayerVO vo = new PlayerVO();
		int result = 0;
		String sql = "insert into heart values(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mu_no);
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("heart insert 실패 !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteHeart(Connection conn, String mem_id, String mu_no) {
//		PlayerVO vo = new PlayerVO();
		int result = -1;
		String sql = "delete from heart where mem_id=? and mu_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mu_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deletePlayList(Connection conn, String mem_id, String mu_no) {
		PlayerVO vo = new PlayerVO();
		int result = 0;
		String sql = "update musichistory set play_now='N' where mem_id=? and mu_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mu_no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int isHeartExist(Connection conn, String mem_id, String mu_no) {
		int result = 0;
		String sql = "select count(*) from heart where mem_id=? and mu_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mu_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
				if(result>0) {
					return 1;
				} else {
					return 0;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
			result = -1;
			System.out.println(result + "실패");
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println(result + "heart 리턴값");
		return result;
	}
	
//	public List<PlayerVO> firstMyMusicPlayer(Connection conn, String mem_id){
//		List<PlayerVO> pvo = new ArrayList<PlayerVO>();
//		String sql =  "select * from (select rownum rnum, m.* from " + 
//				"(select mem_id, mu_name, al_name, art_name, play_date, f_name, music.mu_no, mu_ly " + 
//				"from music join album on music.al_no = album.al_no " + 
//				"inner join artist on music.art_no = artist.art_no " + 
//				"inner join allfile on album.f_no = allfile.f_no " + 
//				"inner join musichistory on music.mu_no = musichistory.mu_no " + 
//				"where mem_id=? and play_now='Y' order by play_date desc) m) where rnum=1";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				do {
//					PlayerVO vo = new PlayerVO();
//					vo.setMu_no(rs.getString("mu_no"));
//					vo.setMem_id(rs.getString("mem_id"));
//					pvo.add(vo);
//					System.out.println("Player firstMyMusic 성공!");
//				} while(rs.next());
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//			System.out.println("SQL 익셉션!!");
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
//		return pvo;
//	}
//	public void heartTB_insert(Connection conn, String mem_id, String mu_no) {
//		String sql = "insert into heart values (?,?)";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setString(2, mu_no);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//
//	}
//
//	public void heartTB_delete(Connection conn, String mem_id, String mu_no) {
//		String sql = "delete from heart where mem_id=? and mu_no=?";
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setString(2, mu_no);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//	}
//
//	public boolean prevent_duplication(Connection conn, String mem_id, String mu_no) {
//		String sql = "select from heart where mem_id=? and mu_no=?";
//		int count = 0;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setString(2, mu_no);
//			count = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			count = -1;
//		} finally {
//			close(pstmt);
//		}
//		return count > 0 ? true : false;
//	}

}
