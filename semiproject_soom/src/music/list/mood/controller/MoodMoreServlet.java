package music.list.mood.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.vo.MainVO;
import music.list.mood.model.service.MoodMoreSrv;
import music.list.mood.model.vo.MoodMoreVO;
import music.list.top.model.service.TopListSrv;
import music.list.top.model.vo.TopListVO;

/**
 * Servlet implementation class MoodMoreServlet
 */
@WebServlet("/MoodMoreServlet")
public class MoodMoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoodMoreServlet() {
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
		 request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html; charset=UTF-8");
		try {
			MoodMoreSrv mmSrv = new MoodMoreSrv();
			List<MoodMoreVO> MoodMore = mmSrv.getMoodMoreAll();
		      List<MainVO> searlist = mmSrv.searchWord();
		         request.setAttribute("searlist", searlist);
			if(MoodMore!= null) {
				System.out.println("aaaa");
				request.setAttribute("MoodMoret", MoodMore);
				request.getRequestDispatcher("/MoodMore.jsp").forward(request, response);
				
			}else {
				System.out.println("bbbb");
				request.setAttribute("errMsg","");
				request.getRequestDispatcher("/MoodMore.jsp");
			}
			
		}catch(Exception e) {
			System.out.println("cccc");
			request.setAttribute("errMsg", "잠시 후 다시 확인해 주세요.");
			request.getRequestDispatcher("/MoodMore.jsp");
		}
	}

}

