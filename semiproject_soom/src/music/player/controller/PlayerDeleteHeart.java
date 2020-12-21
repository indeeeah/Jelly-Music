package music.player.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.player.model.service.PlayerSrv;

/**
 * Servlet implementation class PlayerDeleteHeart
 */
@WebServlet("/playerDeleteHeart.do")
public class PlayerDeleteHeart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayerDeleteHeart() {
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
		String mu_no = request.getParameter("mu_no");
		PrintWriter out = response.getWriter();
		out.append("b");
		try {
			System.out.println(request.getParameter("mem_id"));
			System.out.println(request.getParameter("mu_no"));
			PlayerSrv pservice = new PlayerSrv();
			int result = pservice.deleteHeart(mem_id, mu_no);
			if (result >= 1) {
				System.out.println("하트 딜리트 성공!");
			} else {
				System.out.println("하트 딜리트 실패 ㅠ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("딜리트 캐치 익셉션 오류");
		} finally {
			out.flush();
			out.close();
		}
	}

}
