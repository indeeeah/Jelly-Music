package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;
import member.model.vo.MemberVO;

import static common.jdbcDriver.JDBCTemplate.*;

public class MemberDao {
	PreparedStatement pstmt = null;
	ResultSet rset = null;

	// 사용자 로그인 메소드
	// 매개변수로 받은 ID와 PASSWD로 DataBase에 접속하여 일치하는 데이터 조회
	public Member loginMember(Connection con, String id, String passwd) {
		Member m = null;
		String query = "SELECT * FROM member02 WHERE ID = ? AND PASSWD = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id); // 첫번째 ‘?’ 에 id 값 대입
			pstmt.setString(2, passwd); // 두번째 ‘?’ 에 passwd 값 대입
			rset = pstmt.executeQuery();
			if (rset.next()) { // 첫 열은 head 컬럼이므로 next() 로 실제 컬럼값을 가져온다.
				m = new Member();
				m.setId(rset.getString("ID")); // 받아온 ID 컬럼 값을 member변수에 대입
				m.setPasswd(rset.getString("passwd"));
				m.setName(rset.getString("NAME"));
				m.setEmail(rset.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // ResultSet과 PreparedStatement 리소스를 반환
			close(rset);
			close(pstmt);
		}
		return m; // 조회하여 가져온 Member 객체를 반환한다
	}

	public MemberVO loginMembertest(Connection conn, String mem_id, String mem_pwd) {
		MemberVO m = null;
		String query = "SELECT * FROM member WHERE ID = ? AND PASSWD = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pwd);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				m = new MemberVO();
				m.setMem_id(rset.getString("mem_id"));
				m.setMem_pwd(rset.getString("mem_pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
	}

	// ID 값의 중복을 조회하는 메소드
	// id로 테이블을 조회하여 있으면 1 이상, 없으면 0인 쿼리 작성, -1이면 DB Query실행에 문제 발생
	public int dupIdChk(Connection con, String id) {
		int result = 0;
		// id로 테이블을 조회하여 있으면 1 이상, 없으면 0인 쿼리 작성
		String query = "SELECT COUNT(*) FROM member02 WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1); // rset의 첫 컬럼의 숫자값을 가져온다
			}
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	// DataBase에 Member 객체를 추가하는 메소드
	public int insertMember(Connection con, Member m) throws SQLException {
		int result = 0;
		String query = "INSERT INTO member02 VALUES(?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			// executeupdate() 는 실행 결과를 반영된 행의 개수로 리턴하므로
			// 1 이상은 실행 성공, 0 이하(구문 에러 포함)는 실패이다.
			result = pstmt.executeUpdate();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 기존 사용자의 정보를 수정하여 DataBase의 데이터를 수정하는 메소드
	public int updateMember(Connection con, Member m) {
		int result = 0;
		String query = "UPDATE member02 SET " + "PASSWD = ?, NAME = ?, EMAIL = ? WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getPasswd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 기존 사용자를 DataBase에서 삭제하는 메소드
	public int deleteMember(Connection con, String id) {
		int result = 0;
		String query = "DELETE FROM member02 WHERE ID = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 사용자 로그인 메소드
	// 매개변수로 받은 ID와 PASSWD로 DataBase에 접속하여 일치하는 데이터 조회
	public List<Member> getMembers(Connection con) {
		String query = "SELECT * FROM member02 WHERE ID = ? AND PASSWD = ?";
		List<Member> list = null;
		Member m = null;
		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			int cnt = 0;
			while(rset.next()) {
				cnt++;
				if(cnt==1)
					list = new ArrayList<Member>();
				m = new Member();
				m.setId(rset.getString("ID")); // 받아온 ID 컬럼 값을 member변수에 대입
				m.setPasswd(rset.getString("passwd"));
				m.setName(rset.getString("NAME"));
				m.setEmail(rset.getString("EMAIL"));
				list.add(m);
			}
			
			
			
			if (rset.next()) { // 첫 열은 head 컬럼이므로 next() 로 실제 컬럼값을 가져온다.
				list = new ArrayList<Member>();
				do {
					m = new Member();
					m.setId(rset.getString("ID")); // 받아온 ID 컬럼 값을 member변수에 대입
					m.setPasswd(rset.getString("passwd"));
					m.setName(rset.getString("NAME"));
					m.setEmail(rset.getString("EMAIL"));
					list.add(m);
				} while(rset.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // ResultSet과 PreparedStatement 리소스를 반환
			close(rset);
			close(pstmt);
		}
		return list; // 조회하여 가져온 Member 객체를 반환한다
	}
}
