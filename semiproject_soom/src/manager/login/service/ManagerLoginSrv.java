package manager.login.service;

import static common.jdbcDriver.JDBCTemplate.close;
import static common.jdbcDriver.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import manager.login.dao.ManagerLoginDao;
import manager.login.vo.ManagerLoginVo;

public class ManagerLoginSrv {
	public List<ManagerLoginVo> getLoginMng(String mng_id, String mng_pwd){
		Connection conn = getConnection();
		List<ManagerLoginVo> result = new ManagerLoginDao().getLoginMng(conn, mng_id, mng_pwd);
		close(conn);
		return result;
	}
}
