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

/**
 * Servlet implementation class UnLoginMainServlet
 */
@WebServlet("/unLoginMainServlet")
public class UnLoginMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnLoginMainServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MainService mservice = new MainService();
			List<MainVO> searlist = mservice.searchWord();
			List<MainVO> t1p = mservice.get1to5Top();
			List<MainVO> t6p = mservice.get6to10Top();
			List<MainVO> nrm = mservice.getNewRelease();
			List<MainVO> mood = mservice.getMood();
			List<MainVO> gf = mservice.genreFirst();
			List<MainVO> gs = mservice.genreSecond();
			List<MainVO> gth = mservice.genreThird();
			List<MainVO> gfo = mservice.genreFourth();
			List<MainVO> gfi = mservice.genreFifth();

			if (searlist != null) {
				request.setAttribute("searlist", searlist);
				request.setAttribute("t1p", t1p);
				request.setAttribute("t6p", t6p);
				request.setAttribute("nrm", nrm);
				request.setAttribute("mood", mood);
				request.setAttribute("gf", gf);
				request.setAttribute("gs", gs);
				request.setAttribute("gth", gth);
				request.setAttribute("gfo", gfo);
				request.setAttribute("gfi", gfi);

				request.getRequestDispatcher("/views/main/mainunlogin.jsp").forward(request, response);
			} else {
				System.out.println("xxxxxx");
				request.getRequestDispatcher("/views/main/mainunlogin.jsp").forward(request, response);

			}

		} catch (Exception e) {
			System.out.println("???????");
			e.printStackTrace();
			request.getRequestDispatcher("/views/main/mainunlogin.jsp").forward(request, response);
		}
	}

}
