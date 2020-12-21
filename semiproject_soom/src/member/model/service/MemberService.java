package member.model.service;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import member.model.vo.MemberVO;

import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import static common.jdbcDriver.JDBCTemplate.*;

public class MemberService {
	// DBCP

	// 로그인 시 Member 객체를 받아오는 메소드
	public Member loginMember(String id, String passwd) {
		Connection con = getConnection();
//		con=null 상태
		Member m = new MemberDao().loginMember(con, id, passwd);
		close(con);
		// m == null
		return m;
	}

	public MemberVO loginMembertest(String mem_id, String mem_pwd) {
		Connection conn = getConnection();
		MemberVO m = new MemberDao().loginMembertest(conn, mem_id, mem_pwd);
		close(conn);
		return m;
	}

	// ID 값의 중복을 조회하는 메소드
	// id로 테이블을 조회하여 있으면 1 이상, 없으면 0인 쿼리 작성
	public int dupIdChk(String id) {
		Connection con = getConnection();
		int n = new MemberDao().dupIdChk(con, id);
		close(con);
		return n;
	}

	// DataBase에 Member 객체를 추가하는 메소드
	public int insertMember(Member m) throws SQLException {
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(true);
			result = new MemberDao().insertMember(con, m);
			if (result > 0)
				commit(con);
			else
				rollback(con);
		} finally {
			close(con);
		}
		return result;
	}

	// 기존 사용자의 정보를 수정하여 DataBase의 데이터를 수정하는 메소드
	public int updateMember(Member m) {
		Connection con = getConnection();
		int result = 0;
		if (con != null) {
			result = new MemberDao().updateMember(con, m);
			if (result > 0)
				commit(con);
			else
				rollback(con);
			close(con);
		}
		return result;
	}

	// 기존 사용자를 DataBase에서 삭제하는 메소드
	public int deleteMember(String id) {
		Connection con = getConnection();
		int result = new MemberDao().deleteMember(con, id);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
}
