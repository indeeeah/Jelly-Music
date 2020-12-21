package member.model.service;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dao.MemberLoginDao;
import member.model.vo.MemberLoginVO;

/**
 * Servlet implementation class MemberRegisterCtrl
 */
@WebServlet("/memberLogin.do")
public class MemberLoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLoginSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mem_id = request.getParameter("loginId");
		String mem_pwd = request.getParameter("loginPw");

		String method = request.getMethod();
		if ("GET".equalsIgnoreCase(method)) {
			RequestDispatcher disp = request.getRequestDispatcher("/memberLogin.jsp");
			disp.forward(request, response);
		} else {
			if (!mem_id.equals("") && !mem_pwd.equals("")) {
				MemberLoginVO mem = null;
				try {
					MemberLoginDao dao = new MemberLoginDao();
					mem = dao.MemberLogin(mem_id, mem_pwd);
					if (mem != null) { 
						session.setAttribute("ssLogInfo", mem);
						response.sendRedirect("mainServlet");

					} else {
						RequestDispatcher disp1 = request.getRequestDispatcher("/memberRegister.jsp");
						disp1.forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("errorMsg", "SQL 또는 예기치 못한 장애발생으로 데이터 입력 실패함!!!");
					RequestDispatcher disp2 = request.getRequestDispatcher("/error.jsp");
					disp2.forward(request, response);
				}
			} else {
				RequestDispatcher disp3 = request.getRequestDispatcher("/memberRegister.jsp");
				disp3.forward(request, response);
			}

		}
	}

}
