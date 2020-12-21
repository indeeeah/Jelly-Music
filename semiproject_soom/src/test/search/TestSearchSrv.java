package test.search;
import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;
import java.sql.Connection;
import java.util.List;

import artist.more.info.model.vo.ArtistMoreVO;

public class TestSearchSrv {
	public List<ArtistMoreVO> getResearch(String search){
		Connection conn = getConnection();
		List<ArtistMoreVO> result = new TestSearchDao().getResearch(conn, search);
		close(conn);
		return result;
	}
}
