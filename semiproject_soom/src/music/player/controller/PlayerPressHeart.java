package music.player.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.player.model.service.PlayerSrv;
import music.player.model.vo.PlayerVO;

/**
 * Servlet implementation class PlayerPressHeart
 */
@WebServlet("/playerPressHeart.do")
public class PlayerPressHeart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayerPressHeart() {
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
		String mu_no = request.getParameter("mu_no");
		PrintWriter out = response.getWriter();
		out.append("a");
		try {
			System.out.println(request.getParameter("mem_id"));
			System.out.println(request.getParameter("mu_no"));
			PlayerSrv pservice = new PlayerSrv();
			int result = pservice.clickHeart(mem_id, mu_no);
			if (result >= 1) {
				System.out.println("하트 인서트 성공!");
				out.append("a");
			} else {
				System.out.println("하트 인서트 실패 ㅠ");
				out.append("a");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("캐치 익셉션 오류");
		} finally {
			out.append("a");
			out.flush();
			out.close();
		}
	}

}
