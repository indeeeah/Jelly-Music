package music.player.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.player.model.service.PlayMusicMiSrv;

/**
 * Servlet implementation class playMusicMiCtrl
 */
@WebServlet("/playMusicMiCtrl")
public class playMusicMiCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public playMusicMiCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		System.out.println("1분서블릿");
		int mly = Integer.parseInt(request.getParameter("mly"));
		String mem_id = request.getParameter("mem_id");
		String mu_no = request.getParameter("mu_no");
		try {
			PlayMusicMiSrv PMMService = new PlayMusicMiSrv();
			int result = PMMService.playMusicMi(mly, mem_id, mu_no);
			if(result >0) {
				System.out.println("1분미리듣기입력성공^^");
			}else {
				System.out.println("1분미리듣기입력실패ㅜㅜ");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
