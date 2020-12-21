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
import member.model.service.FinishRegisterSrv;
import member.model.vo.FinishRegisterVO;
import member.model.vo.MemberLoginVO;

/**
 * Servlet implementation class FinishRegisterServlet
 */
@WebServlet("/finishRegisterServlet")
public class FinishRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinishRegisterServlet() {
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
		String mem_id = request.getParameter("mem_id");
		try {
			MainService mservice = new MainService();

//			List<MainVO> himem = mservice.helloToMem(mem_id);
			List<MainVO> searlist = mservice.searchWord();
			
			request.setAttribute("mem_id", mem_id);
			if(searlist!=null) {
//				request.setAttribute("himem", himem);
				request.setAttribute("searlist", searlist);
				
				request.getRequestDispatcher("views/member/finishregister.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("views/member/finishregister.jsp").forward(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("views/member/finishregister.jsp").forward(request, response);
		}
	}

}
