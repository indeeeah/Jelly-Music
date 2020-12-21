package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.FirstArtistSrv;
import member.model.vo.FirstArtistVO;
import member.model.vo.MemberLoginVO;

/**
 * Servlet implementation class FirstArtistCtrl
 */
@WebServlet("/firstArtistCtrl.do")
public class FirstArtistCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstArtistCtrl() {
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
		try {
			FirstArtistSrv faservice = new FirstArtistSrv();
			List<FirstArtistVO> fat = faservice.setArtistt();
			List<FirstArtistVO> fam = faservice.setArtistm();
			List<FirstArtistVO> fab = faservice.setArtistb();
			String mem_id = request.getParameter("mem_id");
			System.out.println(mem_id);
			System.out.println("11111111");
			System.out.println(mem_id);
			if (fat != null) {
				System.out.println("222222");
				request.setAttribute("fat", fat);
				request.setAttribute("fam", fam);
				request.setAttribute("fab", fab);
				request.setAttribute("mem_id", mem_id);
				request.getRequestDispatcher("/views/member/firstArtist.jsp").forward(request, response);;
				System.out.println("3333333");

			} else {
				request.getRequestDispatcher("/views/member/firstArtist.jsp").forward(request, response);;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/views/member/firstArtist.jsp").forward(request, response);;
		}
	}
}
