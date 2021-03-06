package music.more.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import music.more.comment.model.service.MusicCommentLikesSrv;

/**
 * Servlet implementation class DislikeAddAction
 */
@WebServlet("/dislikeAddAction")
public class DislikeAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DislikeAddAction() {
		super();
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
		int mu_co_no = Integer.parseInt(request.getParameter("mu_co_no"));
		PrintWriter out = response.getWriter();
		try {
			System.out.println(Integer.parseInt(request.getParameter("mu_co_no")));
			System.out.println(request.getParameter("mem_id"));
			MusicCommentLikesSrv mcservice = new MusicCommentLikesSrv();
			int result = mcservice.insertDisLike(mem_id, mu_co_no);
			if (result >= 1) {
				System.out.println("press delete success");
			} else {
				System.out.println("press delete fail");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}

	}

}
