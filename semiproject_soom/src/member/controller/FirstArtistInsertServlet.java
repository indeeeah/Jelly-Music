package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.FirstArtistSrv;
import member.model.vo.FirstArtistVO;

/**
 * Servlet implementation class FirstArtistInsertServlet
 */
@WebServlet("/firstArtistInsertServlet.do")
public class FirstArtistInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstArtistInsertServlet() {
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
			System.out.println("mem_id: "+ mem_id);
			FirstArtistVO vo = new FirstArtistVO();
			vo.setMem_id(request.getParameter("mem_id"));
			vo.setArt_no_1(request.getParameter("art_no_1"));
			vo.setArt_no_2(request.getParameter("art_no_2"));
			vo.setArt_no_3(request.getParameter("art_no_3"));
			System.out.println(request.getParameter("mem_id"));
			System.out.println(request.getParameter("art_no_1"));
			System.out.println(request.getParameter("art_no_2"));
			System.out.println(request.getParameter("art_no_3"));
			FirstArtistSrv faservice = new FirstArtistSrv();
			int result = faservice.firstArtist(vo);
			if (result >= 1) {
				request.setAttribute("mem_id", mem_id);
				RequestDispatcher disp = request.getRequestDispatcher("firstGenreCtrl.do");
				disp.forward(request, response);
			} else {
				System.out.println("아티스트 업데이트 실패");
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
