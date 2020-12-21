package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.model.vo.MemberLoginVO;

public class MemberLoginDao {
	private DataSource ds = null; // DataSource ds는 아파치톰캣(WAS)가 제공하는 DBCP(DB Connection Pool) 이다.
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public MemberLoginDao() {
		try {
			Context initContext1 = new InitialContext();
			Context envContext1 = (Context) initContext1.lookup("java:/comp/env");
			ds = (DataSource) envContext1.lookup("jdbc/myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int MemberRegisterSrv(MemberLoginVO mvo) {
		int result = 0;
		String sql = "insert into member(mem_id, mem_pwd, mem_name, mem_email, mem_phone, mem_gender) values(?,?,?,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mvo.getMem_id());
			pstmt.setString(2, mvo.getMem_pwd());
			pstmt.setString(3, mvo.getMem_name());
			pstmt.setString(4, mvo.getMem_email());
			pstmt.setString(5, mvo.getMem_phone());
			pstmt.setInt(6, mvo.getMem_gender());
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	public MemberLoginVO MemberLogin(String mem_id, String mem_pwd) {
		ResultSet result = null;
		String sql = "SELECT * FROM member WHERE mem_id = ? AND mem_pwd = ?";
		MemberLoginVO mem = new MemberLoginVO();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pwd);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				mem.setMem_id(result.getString("mem_id"));
				mem.setMem_pwd(result.getString("mem_pwd"));
				mem.setMem_name(result.getString("mem_name"));
				mem.setMem_email(result.getString("mem_email"));
				mem.setMem_phone(result.getString("mem_phone"));
				mem.setMem_gender(result.getInt("mem_gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return mem;
	}
	
	public List<MemberLoginVO> MemberList() {
		List<MemberLoginVO> mVoList = null;
		String sql = "select * from member";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				mVoList = new ArrayList<MemberLoginVO>(); 
				do {
					MemberLoginVO mvo = new MemberLoginVO();
					mvo.setMem_id(rs.getString("mem_id"));
					mvo.setMem_pwd(rs.getString("mem_pwd"));
					mvo.setMem_name(rs.getString("mem_name"));
					mvo.setMem_email(rs.getString("mem_email"));
					mvo.setMem_phone(rs.getString("mem_phone"));
					mvo.setMem_gender(rs.getInt("mem_gender"));
					mVoList.add(mvo);
				}while(rs.next());
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return mVoList;
	}
	
	public int updateinfo(String mem_id, String mem_pwd, String mem_name, String mem_email, String mem_phone) {
		
		String sql="update member set mem_pwd=?, mem_name=?, mem_email=?, mem_phone=? where mem_id=?";
		int res = 0;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem_pwd);
			pstmt.setString(2, mem_name);
			pstmt.setString(3, mem_email);
			pstmt.setString(4, mem_phone);
			pstmt.setString(5, mem_id);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			close();
		}
		return res;	
	}
	
	public int MemberDelete(String mem_id) {
		String sql="delete member where mem_id=?";
		int result= -1;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem_id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			close();
		}
		return result;
	}
}








