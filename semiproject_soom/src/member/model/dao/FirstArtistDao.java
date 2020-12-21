package member.model.dao;

import static common.jdbcDriver.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.FirstArtistVO;

public class FirstArtistDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<FirstArtistVO> setArtistt(Connection conn) {
		List<FirstArtistVO> fvo = new ArrayList<FirstArtistVO>();
		String sql = "select * from (select rownum rnum, m.* from (select art_name, avg(mu_every_play), f_name, artist.f_no " + 
				"from artist join music on artist.art_no = music.art_no " + 
				"inner join allfile on artist.f_no = allfile.f_no group by art_name, f_name, artist.f_no " + 
				"order by avg(mu_every_play) desc) m) where rnum between 1 and 6 order by dbms_random.value";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					FirstArtistVO vo = new FirstArtistVO();
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					vo.setF_no(rs.getString("f_no"));
					fvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return fvo;
	}

	public List<FirstArtistVO> setArtistm(Connection conn) {
		List<FirstArtistVO> fvo = new ArrayList<FirstArtistVO>();
		String sql = "select * from (select rownum rnum, m.* from (select art_name, avg(mu_every_play), f_name, artist.f_no " + 
				"from artist join music on artist.art_no = music.art_no " + 
				"inner join allfile on artist.f_no = allfile.f_no group by art_name, f_name, artist.f_no " + 
				"order by avg(mu_every_play) desc) m) where rnum between 7 and 12 order by dbms_random.value";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					FirstArtistVO vo = new FirstArtistVO();
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					vo.setF_no(rs.getString("f_no"));
					fvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return fvo;
	}

	public List<FirstArtistVO> setArtistb(Connection conn) {
		List<FirstArtistVO> fvo = new ArrayList<FirstArtistVO>();
		String sql = "select * from (select rownum rnum, m.* from (select art_name, avg(mu_every_play), f_name, artist.f_no " + 
				"from artist join music on artist.art_no = music.art_no " + 
				"inner join allfile on artist.f_no = allfile.f_no group by art_name, f_name, artist.f_no " + 
				"order by avg(mu_every_play) desc) m) where rnum between 13 and 18 order by dbms_random.value";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					FirstArtistVO vo = new FirstArtistVO();
					vo.setArt_name(rs.getString("art_name"));
					vo.setF_name(rs.getString("f_name"));
					vo.setF_no(rs.getString("f_no"));
					fvo.add(vo);
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return fvo;
	}

	public int firstArtist(Connection conn, FirstArtistVO vo) {
		int result = 0;
		String sql = "insert into firstchoice (mem_id, art_no_1, art_no_2, art_no_3) values (?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_id());
			pstmt.setString(2, vo.getArt_no_1());
			pstmt.setString(3, vo.getArt_no_2());
			pstmt.setString(4, vo.getArt_no_3());
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("아티스트 선택 insert 실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
