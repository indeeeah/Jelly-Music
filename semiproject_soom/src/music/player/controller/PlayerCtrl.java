package music.player.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.service.MainService;
import main.model.vo.MainVO;
import music.player.model.service.PlayerSrv;
import music.player.model.vo.PlayerVO;


/**
 * Servlet implementation class PlayerCtrl
 */
@WebServlet("/playerCtrl.do")
public class PlayerCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayerCtrl() {
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
//		String mem_id = (String)request.getSession().getAttribute("mem_id");
		String mem_id = "aaab";
		
		String mu_no = request.getParameter("mu_no");
		System.out.println("**************************************************");
		System.out.println(mu_no);
		System.out.println(mem_id);
		try {
			PlayerSrv pservice = new PlayerSrv();
			MainService mservice = new MainService();
			List<MainVO> scm = mservice.showCurrmusic(mem_id);
			List<PlayerVO> mplist = pservice.getMyListAll(mem_id);
//			List<PlayerVO> mprof = pservice.memberProf(mem_id);
			int result = pservice.isHeartExist(mem_id, mu_no);
//			List<PlayerVO> fmp = pservice.firstMyMusicPlayer(mem_id);
			System.out.println(mem_id);
			System.out.println(mu_no);
			if(mplist != null) {
				request.setAttribute("mplist", mplist);
				System.out.println("mplist OK");
//				request.setAttribute("mprof", mprof);
				System.out.println("mprof OK");
				request.setAttribute("heart", result);
				System.out.println("heart OK");
				System.out.println(result);
//				request.setAttribute("fmp", fmp);
//				System.out.println("fmm OK");
				request.setAttribute("scm", scm);
				System.out.println("scm OK");
				System.out.println(request.getParameter("mu_no"));
				
				//response.sendRedirect("views/music/player.jsp");
				request.getRequestDispatcher("views/music/player.jsp").forward(request, response);
				System.out.println("첫번째 forward");
			} else {
				request.getRequestDispatcher("views/music/player.jsp").forward(request, response);
				System.out.println("두번째 forward");
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("views/music/player.jsp").forward(request, response);
			System.out.println("세번째 forward");
		}
	}
}
