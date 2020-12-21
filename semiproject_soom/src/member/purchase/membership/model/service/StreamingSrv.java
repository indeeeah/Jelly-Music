package member.purchase.membership.model.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.purchase.membership.model.dao.StreamingDao;
import member.purchase.membership.model.vo.StreamingVO;

public class StreamingSrv {
	
	public int insertStreaming(StreamingVO vo) {
		Connection conn = getConnection();
		int result = new StreamingDao().insertStreaming(conn, vo);
		close(conn);
		return result;
	}


}
