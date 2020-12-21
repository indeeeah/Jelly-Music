package music.more.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.more.comment.model.service.MusicCommentLikesSrv;

/**
 * Servlet implementation class AddReport
 */
@WebServlet("/addReport")
public class AddReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReport() {
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
		int mu_co_no = Integer.parseInt(request.getParameter("mu_co_no"));
		String report_reason = request.getParameter("report_reason");
		String report_content = request.getParameter("report_content");
		PrintWriter out = response.getWriter();
		try {
			System.out.println(request.getParameter("mem_id"));
			System.out.println(Integer.parseInt(request.getParameter("mu_co_no")));
			MusicCommentLikesSrv mcservice = new MusicCommentLikesSrv();
			int result = mcservice.addReport(mem_id, mu_co_no, report_reason, report_content);
			if(result>=1) {
				System.out.println("신고 성공!");
			} else {
				System.out.println("신고 실패!");
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("신고 익셉션");
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
