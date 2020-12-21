package music.list.memberRec.model.dao;

import static common.jdbcDriver.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import music.list.memberRec.model.vo.MemberRecVO;

public class MemberRecDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<MemberRecVO> setMemberRecAll(Connection conn, String mem_id){
		List<MemberRecVO> rvo = new ArrayList<MemberRecVO>();
		String sql = " select * from (select rownum rnum, h. * from (select count(mem_id) cnt,\r\n" + 
				" mu_no from musichistory where mem_id in(select mem_id from\r\n" + 
				" musichistory where mu_no =(select mu_no from (select rownum rnum, \r\n" + 
				" m.* from (select * from musichistory where mem_id = 'aaaa' order by \r\n" + 
				" play_more_min desc) m) where rnum=1)) group by mu_no order by cnt \r\n" + 
				" desc) h) where rnum <11";
		try {
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					MemberRecVO vo = new MemberRecVO();
					vo.setMem_id(rs.getString("mem_id"));
					vo.setArt_no(rs.getString("art_no"));
					vo.setArt_name(rs.getString("art_name"));
					vo.setMu_no(rs.getString("mu_no"));
					vo.setMu_name(rs.getString("mu_name"));
					vo.setF_no(rs.getNString("f_no"));
					rvo.add(vo);
				}while(rs.next());
			}
		}catch(SQLException e) {
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return rvo;
	}
}