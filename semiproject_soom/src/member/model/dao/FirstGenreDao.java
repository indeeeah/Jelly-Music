package member.model.dao;

import static common.jdbcDriver.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.FirstGenreVO;

public class FirstGenreDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public List<FirstGenreVO> setGenret(Connection conn) {
		List<FirstGenreVO> fvo = new ArrayList<FirstGenreVO>();
		String sql = "select * from (select rownum rnum, g.* " + "from (select gn_no, gn_name, f_name "
				+ "from genre join allfile " + "on genre.f_no=allfile.f_no " + "order by gn_no asc) g) "
				+ "where rnum between 1 and 7 " + "order by dbms_random.value";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					FirstGenreVO vo = new FirstGenreVO();
					vo.setGn_no(rs.getString("gn_no"));
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_name(rs.getString("f_name"));
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

	public List<FirstGenreVO> setGenrem(Connection conn) {
		List<FirstGenreVO> fvo = new ArrayList<FirstGenreVO>();
		String sql = "select * from (select rownum rnum, g.* " + "from (select gn_no, gn_name, f_name "
				+ "from genre join allfile " + "on genre.f_no=allfile.f_no " + "order by gn_no asc) g) "
				+ "where rnum between 8 and 14 " + "order by dbms_random.value";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					FirstGenreVO vo = new FirstGenreVO();
					vo.setGn_no(rs.getString("gn_no"));
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_name(rs.getString("f_name"));
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

	public List<FirstGenreVO> setGenreb(Connection conn) {
		List<FirstGenreVO> fvo = new ArrayList<FirstGenreVO>();
		String sql = "select * from (select rownum rnum, g.* " + "from (select gn_no, gn_name, f_name "
				+ "from genre join allfile " + "on genre.f_no=allfile.f_no " + "order by gn_no asc) g) "
				+ "where rnum between 15 and 21 " + "order by dbms_random.value";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					FirstGenreVO vo = new FirstGenreVO();
					vo.setGn_no(rs.getString("gn_no"));
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_name(rs.getString("f_name"));
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

	public int firstGenre(Connection conn, FirstGenreVO vo) {
		int result = 0;
		String sql = "update firstchoice set mu_genre_1=?, mu_genre_2=?, mu_genre_3=? where mem_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMu_genre_1());
			pstmt.setString(2, vo.getMu_genre_2());
			pstmt.setString(3, vo.getMu_genre_3());
			pstmt.setString(4, vo.getMem_id());
			result = pstmt.executeUpdate();
			if (result < 1) {
				System.out.println("insert 실패!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}
