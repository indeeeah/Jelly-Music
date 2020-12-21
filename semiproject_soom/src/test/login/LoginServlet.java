package test.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import member.model.vo.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String mem_id = request.getParameter("id");
		String mem_pwd = request.getParameter("pw");
		try {
			LoginSrv LService = new LoginSrv();
			List<MemberVO> login = LService.getLogin(mem_id, mem_pwd);

			if (login != null) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("mem_id", mem_id);
				httpSession.setAttribute("mem_pwd", mem_pwd);
				httpSession.setAttribute("loginOk", login);
				httpSession.removeAttribute("loginMng");
				httpSession.removeAttribute("mng_id");
				httpSession.removeAttribute("mng_pwd");
				request.getRequestDispatcher("/testSearch.jsp").forward(request, response);
			} else {
				System.out.println("로그인널");
				request.setAttribute("errMsg", "작성된 글이 없습니다.");
				request.getRequestDispatcher("/views/board/musicCommentTest1.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("로그인익셉션");
			request.setAttribute("errMsg", "잠시 후 다시 확인해 주세요");
			request.getRequestDispatcher("/views/board/musicCommentTest2.jsp").forward(request, response);
		}
	}
}
