package test.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.more.comment.model.service.ArtistCommentSrv;
import artist.more.comment.model.vo.ArtistCommentVO;
import artist.more.info.model.vo.ArtistMoreVO;
import music.more.info.model.vo.MusicMoreVO;

/**
 * Servlet implementation class TestSearchServlet
 */
@WebServlet("/testSearchServlet")
public class TestSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestSearchServlet() {
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
			String search = request.getParameter("search");
			TestSearchSrv TService = new TestSearchSrv();
			List<ArtistMoreVO> result = TService.getResearch(search);
			
			if(search!=null) {
				System.out.println("aaa");
				request.setAttribute("result", result);
				request.getRequestDispatcher("/testSearch.jsp").forward(request, response);
			} else {
				System.out.println("bbb");
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println("ccc");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		} catch (NullPointerException e) {
			System.out.println("ddd");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
		
	}

}
