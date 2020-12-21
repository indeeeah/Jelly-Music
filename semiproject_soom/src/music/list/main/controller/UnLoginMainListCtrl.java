package music.list.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.service.MainService;
import main.model.vo.MainVO;
import music.list.main.model.service.MainListSrv;
import music.list.main.model.vo.MainListVO;

/**
 * Servlet implementation class UnLoginMainListCtrl
 */
@WebServlet("/unLoginMainListCtrl.do")
public class UnLoginMainListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnLoginMainListCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		try {
			MainListSrv mlservice = new MainListSrv();
			MainService mservice = new MainService();
			List<MainVO> searlist = mservice.searchWord();
			List<MainVO> t1p = mservice.get1to5Top();
			List<MainVO> t6p = mservice.get6to10Top();
			List<MainVO> gf = mservice.genreFirst();
			List<MainVO> gs = mservice.genreSecond();
			List<MainVO> gth = mservice.genreThird();
			List<MainVO> gfo = mservice.genreFourth();
			List<MainVO> gfi = mservice.genreFifth();
			List<MainListVO> hr1 = mlservice.get1to5Heart();
			List<MainListVO> hr6 = mlservice.get6to10Heart();
			List<MainListVO> moodt = mlservice.getMoodAllt();
			List<MainListVO> moodd = mlservice.getMoodAlld();
			if (moodt != null) {
				request.setAttribute("searlist", searlist);
				request.setAttribute("t1p", t1p);
				request.setAttribute("t6p", t6p);
				request.setAttribute("hr1", hr1);
				request.setAttribute("hr6", hr6);
				request.setAttribute("moodt", moodt);
				request.setAttribute("moodd", moodd);
				request.setAttribute("gf", gf);
				request.setAttribute("gs", gs);
				request.setAttribute("gth", gth);
				request.setAttribute("gfo", gfo);
				request.setAttribute("gfi", gfi);
				request.getRequestDispatcher("/views/music/mainListunlog.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/music/mainListunlog.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/music/mainListunlog.jsp").forward(request, response);
		}
	}
}
