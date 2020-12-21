package post.model.service;
//한글 
import static common.jdbcDriver.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import post.model.dao.PostDao;
import post.model.vo.PostVO;

public class PostSrv {
	
	public int getQuesCount() {
		Connection con = getConnection();
		int result = new PostDao().getQuesCount(con);
		close(con);
		return result;
	}
	
	public List<PostVO> getQuesAll(){
		Connection con = getConnection();
		List<PostVO> result = new PostDao().getQuesAll(con);
		close(con);
		return result;
	}
	
	public List<PostVO> getQuesByPage(int start, int end){
		Connection con = getConnection();
		List<PostVO> result = new PostDao().getQuesByPage(con, start, end);
		close(con);
		return result;
	}
	
	public List<PostVO> getQues(int que_no){
		Connection con = getConnection();
		List<PostVO> result = new PostDao().getQues(con, que_no);
		close(con);
		return result;
	}
	
	public int writeQues(PostVO vo){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new PostDao().writeQues(con, vo);
			if(result>0)
				commit(con);
			else
				rollback(con);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
	
	public int updateQues(int que_no, String que_name, String que_content, String que_file){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new PostDao().updateQues(con, que_no, que_name, que_content, que_file );
			if(result>0)
				commit(con);
			else
				rollback(con);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
	
	public int deleteQues(int que_no){
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new PostDao().deleteQues(con, que_no);
			if(result>0)
				commit(con);
			else
				rollback(con);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
	public int getQuesCnt(int que_no) {
		Connection con = getConnection();
		int result = 0;
		try {
			con.setAutoCommit(false);
			result = new PostDao().getQuesCnt(con, que_no);
			if(result>0)
				commit(con);
			else
				rollback(con);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return result;
	}
	
	public List<PostVO> getQuesWriter(String quesSearch, int startRnum, int endRnum){
		Connection con = getConnection();
		List<PostVO> result = new PostDao().getQuesWriter(con, quesSearch, startRnum, endRnum);
		close(con);
		return result;
	}
	public int getQuesWriterCount(String quesSearch) {
		Connection con = getConnection();
		int result = new PostDao().getQuesWriterCount(con, quesSearch);
		close(con);
		return result;
	}
}
