package music.list.genre.model.dao;

import static common.jdbcDriver.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import music.list.genre.model.vo.GenreListVO;

public class GenreListDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<GenreListVO>setGenreListAll(Connection conn){
		List<GenreListVO> gvo = new ArrayList<GenreListVO>();
		String sql = "select * from (select rownum rnum, g.* " + "from (select gn_no, gn_name, f_name "
				+ "from genre join allfile " + "on genre.f_no=allfile.f_no " + "order by gn_no asc) g) "
				+ "where rnum between 1 and 6 " + "order by dbms_random.value";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				do {
					GenreListVO vo = new GenreListVO();
					vo.setGn_no(rs.getString("gn_no"));
					vo.setGn_name(rs.getString("gn_name"));
					vo.setF_no(rs.getString("f_no"));
					gvo.add(vo);
				}while (rs.next());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return gvo;
	}
}
