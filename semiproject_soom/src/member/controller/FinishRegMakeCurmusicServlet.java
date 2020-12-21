package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.FinishRegisterSrv;

/**
 * Servlet implementation class FinishRegMakeCurmusicServlet
 */
@WebServlet("/finishRegMakeCurmusicServlet")
public class FinishRegMakeCurmusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FinishRegMakeCurmusicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		PrintWriter out = response.getWriter();
		try {
			System.out.println(request.getParameter("mem_id"));
			FinishRegisterSrv frservice = new FinishRegisterSrv();
			int result = frservice.frMakeCurrmusic(mem_id);
			if (result >= 1) {
				System.out.println("인서트 커런트 뮤직 성공!");
			} else {
				System.out.println("인서트 커런트 뮤직 실패!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("커런트 뮤직 익셉션 오류");
		} finally {
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
