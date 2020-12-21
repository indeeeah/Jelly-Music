package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.service.MainService;
import main.model.vo.MainVO;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/memberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLoginServlet() {
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
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MainService mservice = new MainService();
			List<MainVO> searlist = mservice.searchWord();
			
			if (searlist != null) {
				request.setAttribute("searlist", searlist);
				
				System.out.println(searlist);
				request.getRequestDispatcher("/views/member/memberLogin.jsp").forward(request, response);
			} else {
				System.out.println("xxxxxx");
				request.getRequestDispatcher("/views/main/mainunlog.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("???????");
			e.printStackTrace();
			request.getRequestDispatcher("/views/main/mainunlog.jsp").forward(request, response);
		}
	}

}
