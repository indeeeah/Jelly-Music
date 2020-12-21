package artist.search.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import artist.more.info.model.vo.ArtistMoreVO;
import artist.search.model.dao.ArtistSearchDao;

public class ArtistSearchSrv {
	
	public List<ArtistMoreVO> getArtistSearch(String art_no){
		Connection conn = getConnection();
		List<ArtistMoreVO> result = new ArtistSearchDao().getArtistSearch(conn, art_no);
		close(conn);
		return result;
	}
}
