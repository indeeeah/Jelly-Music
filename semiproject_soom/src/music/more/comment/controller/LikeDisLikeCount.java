package music.more.comment.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import music.more.comment.model.service.MusicCommentLikesSrv;

/**
 * Servlet implementation class LikeDisLikeCount
 */
@WebServlet("/likeDisLikeCount")
public class LikeDisLikeCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LikeDisLikeCount() {
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
		int mu_co_no1 = Integer.parseInt(request.getParameter("mu_co_no1"));
		int mu_co_no2 = Integer.parseInt(request.getParameter("mu_co_no2"));
		System.out.println(mu_co_no1);
		try {
			MusicCommentLikesSrv mcservice = new MusicCommentLikesSrv();
			HashMap<String, Integer> ldc = mcservice.getLikeDislikeCount(mu_co_no1, mu_co_no2);

			JSONObject jsobj = new JSONObject();
			jsobj.put("likecnt", ldc.get("likecnt"));
			jsobj.put("dislikecnt", ldc.get("dislikecnt"));

			String result = jsobj.toString();
			request.setAttribute("result", result);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
