package music.list.genre.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.vo.MainVO;
import music.list.genre.model.service.GenreListSrv;
import music.list.genre.model.vo.GenreListVO;

/**
 * Servlet implementation class GenreListServelr
 */
@WebServlet("/GenreListServelr")
public class GenreListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenreListServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	      request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html; charset=UTF-8");

	      try {
	    	  GenreListSrv gSrv = new GenreListSrv();
	         List<GenreListVO> genreList = gSrv.setGenreListAll();
	         List<MainVO> searlist = gSrv.searchWord();
	         request.setAttribute("searlist", searlist);
	         if (genreList != null) {
	            System.out.println("aaa");
	            request.setAttribute("genreList", genreList);
	            request.getRequestDispatcher("/Genre.jsp").forward(request, response);
	         } else {
	            System.out.println("bbb");
	            request.setAttribute("errMsg", "현재 구매할 수 있는 이용권이 없습니다. 추후 서비스 예정입니다.");
	            request.getRequestDispatcher("/errrorMsg.jsp").forward(request, response);
	         }
	      } catch (Exception e) {
	         System.out.println("ccc");
	         request.setAttribute("errMsg", "잠시후 다시 이용해 주세요.");
	         request.getRequestDispatcher("/errrorMsg.jsp").forward(request, response);
	      }

	   }

}
