package music.list.top.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.vo.MainVO;
import music.list.top.model.service.TopListSrv;
import music.list.top.model.vo.TopListVO;

/**
 * Servlet implementation class TopList
 */
@WebServlet("/TopList")
public class TopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopListServlet() {
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
			TopListSrv tSrv = new TopListSrv();
			List<TopListVO> Toplist = tSrv.getTopListAll();
		      List<MainVO> searlist = tSrv.searchWord();
		         request.setAttribute("searlist", searlist);
			if(Toplist!= null) {
				System.out.println("aaaa");
				request.setAttribute("TopList", Toplist);
				request.getRequestDispatcher("/TopList.jsp").forward(request, response);
				
			}else {
				System.out.println("bbbb");
				request.setAttribute("errMsg","");
				request.getRequestDispatcher("/TopList.jsp");
			}
			
		}catch(Exception e) {
			System.out.println("cccc");
			request.setAttribute("errMsg", "잠시 후 다시 확인해 주세요.");
			request.getRequestDispatcher("/TopList.jsp");
		}
	}

}
