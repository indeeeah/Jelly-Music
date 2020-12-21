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
 * Servlet implementation class PlayerListDelete
 */
@WebServlet("/playerListDelete.do")
public class PlayerListDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayerListDelete() {
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
		out.append("c");
		try {
			PlayerSrv pservice = new PlayerSrv();
			int result = pservice.deletePlayList(mem_id, mu_no);
			if (result >= 1) {
				System.out.println("플레이리스트 딜리트 성공");
			} else {
				System.out.println("플레이리스트 딜리트 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("플레이리스트 딜리트 익셉션 오류ㅠ ");
		} finally {
			out.flush();
			out.close();
		}
	}

}
