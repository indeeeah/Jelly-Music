package music.more.info.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.service.MainService;
import main.model.vo.MainVO;
import music.more.comment.model.service.MusicCommentSrv;
import music.more.comment.model.vo.MusicCommentVO;
import music.more.info.model.service.MusicMoreSrv;
import music.more.info.model.vo.MusicMoreVO;

/**
 * Servlet implementation class MusicMoreunlogServlet
 */
@WebServlet("/MusicMoreunlogServlet")
public class MusicMoreunlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicMoreunlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
			String mu_no = request.getParameter("mu_no");
			System.out.println("음원상세mu_no"+ mu_no);
			MusicMoreSrv MMService = new MusicMoreSrv();
			MainService mservice = new MainService();
			List<MainVO> searlist = mservice.searchWord();
			List<MusicMoreVO> info = MMService.getMusicInfo(mu_no);
			List<MusicMoreVO> ly = MMService.getLyrics(mu_no);
			List<MusicMoreVO> slist = MMService.getSingles(mu_no);
			List<MusicMoreVO> ainclude= MMService.getIncludeAl(mu_no);
			List<MusicMoreVO> related= MMService.getRelated(mu_no);
			MusicCommentSrv MCService = new MusicCommentSrv();
			List<MusicCommentVO> clist = MCService.getCommentAll(mu_no);
			
			String mu_no1 = (String) request.getAttribute("mu_no1");
			System.out.println("음원상세mu_no1"+ mu_no1);
			if(info != null) {
				System.out.println("aaaaaa");
				request.setAttribute("searlist", searlist);
				request.setAttribute("info", info);
				request.setAttribute("lyrics", ly);
				request.setAttribute("slist", slist);
				request.setAttribute("ainclude", ainclude);
				request.setAttribute("related", related);
				System.out.println("a");
				request.setAttribute("clist", clist);
				System.out.println("b");
				request.getRequestDispatcher("/views/music/musicMoreunlog.jsp").forward(request, response);
				System.out.println("c");

			} else {
				System.out.println("bbbbbb");
				request.setAttribute("errMsg", "작성된 글이 없습니다.");
				request.getRequestDispatcher("/views/board/musicCommentTest1.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("cccccc");
			request.setAttribute("errMsg", "잠시 후 다시 확인해 주세요");
			request.getRequestDispatcher("/views/board/musicCommentTest2.jsp").forward(request, response);
		}
	}

}
