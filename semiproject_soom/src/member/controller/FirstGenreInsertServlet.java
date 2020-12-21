package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.FirstGenreDao;
import member.model.service.FirstGenreSrv;
import member.model.vo.FirstGenreVO;

/**
 * Servlet implementation class FirstGenreInsertServlet
 */
@WebServlet("/firstGenreInsertServlet.do")
public class FirstGenreInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstGenreInsertServlet() {
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
		try {
			String mem_id = request.getParameter("mem_id");
			FirstGenreVO vo = new FirstGenreVO();
			vo.setMem_id(request.getParameter("mem_id"));
			vo.setMu_genre_1(request.getParameter("mu_genre_1"));
			vo.setMu_genre_2(request.getParameter("mu_genre_2"));
			vo.setMu_genre_3(request.getParameter("mu_genre_3"));
			System.out.println(request.getParameter("mem_id"));
			System.out.println(request.getParameter("mu_genre_1"));
			System.out.println(request.getParameter("mu_genre_2"));
			System.out.println(request.getParameter("mu_genre_3"));
			FirstGenreSrv fgservice = new FirstGenreSrv();
			int result = fgservice.firstGenre(vo);
			if(result>=1) {
				request.setAttribute("mem_id", mem_id);
				RequestDispatcher disp = request.getRequestDispatcher("finishRegisterServlet");
				disp.forward(request, response);
			} else {
				System.out.println("장르 업데이트 실패");
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		} catch (NullPointerException e) {
			e.printStackTrace();
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
	}

}
