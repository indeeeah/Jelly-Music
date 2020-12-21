package main.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.service.MainService;
import main.model.vo.MainVO;
import member.model.vo.MemberLoginVO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/mainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
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
		System.out.println("trtrt");
		MemberLoginVO vo = (MemberLoginVO)request.getSession().getAttribute("ssLogInfo");
		String mem_id = vo.getMem_id();
		try {
			MainService mservice = new MainService();
			////////꼭 넣어야될 코드///////
//			List<MainVO> himem = mservice.helloToMem(mem_id);
			List<MainVO> searlist = mservice.searchWord();
			List<MainVO> scm = mservice.showCurrmusic(mem_id);
			//////////////////////////////////
			List<MainVO> t1p = mservice.get1to5Top();
			List<MainVO> t6p = mservice.get6to10Top();
			List<MainVO> nrm = mservice.getNewRelease();
			List<MainVO> mood = mservice.getMood();
			List<MainVO> mpl = mservice.getMemPlay(mem_id);
			List<MainVO> ml = mservice.mayLikeArt(mem_id);
			List<MainVO> mlm = mservice.mayLikeMusic(mem_id);
			List<MainVO> gf = mservice.genreFirst();
			List<MainVO> gs = mservice.genreSecond();
			List<MainVO> gth = mservice.genreThird();
			List<MainVO> gfo = mservice.genreFourth();
			List<MainVO> gfi = mservice.genreFifth();
//			List<MainVO> fmm = mservice.firstMyMusic(mem_id);
			
//			session.setAttribute("mem_id", mem_id);
			request.setAttribute("mem_id", mem_id);
			System.out.println(mem_id);
//			if (himem != null) {
//				request.setAttribute("himem", himem);
				request.setAttribute("searlist", searlist);
				request.setAttribute("t1p", t1p);
				request.setAttribute("t6p", t6p);
				request.setAttribute("nrm", nrm);
				request.setAttribute("mood", mood);
				request.setAttribute("mpl", mpl);
				request.setAttribute("ml", ml);
				request.setAttribute("mlm", mlm);
				request.setAttribute("gf", gf);
				request.setAttribute("gs", gs);
				request.setAttribute("gth", gth);
				request.setAttribute("gfo", gfo);
				request.setAttribute("gfi", gfi);
//				request.setAttribute("fmm", fmm);
				request.setAttribute("scm", scm);
				
				System.out.println("*****************************리스트 보여주기 끝");

				request.getRequestDispatcher("/views/main/main.jsp").forward(request, response);
//				request.getRequestDispatcher("playerCtrl.do").forward(request, response);
//			} else {
//				System.out.println("xxxxxx");
//				request.getRequestDispatcher("/views/main/mainunlog.jsp").forward(request, response);
//
//			}

		} catch (Exception e) {
			System.out.println("???????");
			e.printStackTrace();
			request.getRequestDispatcher("/views/main/mainunlogin.jsp").forward(request, response);
		}
	}

}
