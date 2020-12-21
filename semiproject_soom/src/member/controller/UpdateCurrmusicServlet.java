package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.service.MainService;

/**
 * Servlet implementation class UpdateCurrmusicServlet
 */
@WebServlet("/updateCurrmusicServlet")
public class UpdateCurrmusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCurrmusicServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mu_no = request.getParameter("mu_no");
		PrintWriter out = response.getWriter();
		try {
			System.out.println(request.getParameter("mem_id"));
			System.out.println(request.getParameter("mu_no"));
			MainService mservice = new MainService();
			int result = mservice.updateCurrmusic(mem_id, mu_no);
			if (result >= 1) {
				System.out.println("currmusic upadate sucess");
			} else {
				System.out.println("currmusic update fail");
				System.out.println(request.getParameter("mem_id"));
				System.out.println(request.getParameter("mu_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("currmusic exception");
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
		doGet(request, response);
	}

}
