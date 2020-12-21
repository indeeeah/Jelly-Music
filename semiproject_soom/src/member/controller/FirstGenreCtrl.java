package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.FirstGenreSrv;
import member.model.vo.FirstGenreVO;
import member.model.vo.MemberLoginVO;

/**
 * Servlet implementation class FirstGenreCtrl
 */
@WebServlet("/firstGenreCtrl.do")
public class FirstGenreCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstGenreCtrl() {
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
			FirstGenreSrv fgservice = new FirstGenreSrv();
			List<FirstGenreVO> fgt = fgservice.setGenret();
			List<FirstGenreVO> fgm = fgservice.setGenrem();
			List<FirstGenreVO> fgb = fgservice.setGenreb();
			System.out.println("11111111");
			request.setAttribute("mem_id", mem_id);
			System.out.println(mem_id);
			if (fgt != null) {
				System.out.println("222222");
				request.setAttribute("fgt", fgt);
				request.setAttribute("fgm", fgm);
				request.setAttribute("fgb", fgb);
				request.getRequestDispatcher("/views/member/firstGenre.jsp").forward(request, response);
				System.out.println("3333333");
			} else {
				request.getRequestDispatcher("/views/member/firstGenre.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/member/firstGenre.jsp").forward(request, response);
		}
	}

}
