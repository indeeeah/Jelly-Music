package music.musicsearch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.purchase.membership.model.service.MemberShipSrv;
import member.purchase.membership.model.vo.MembershipVO;
import music.musicsearch.model.service.MusicSearchSrv;
import music.musicsearch.model.vo.MusicSearchVO;

/**
 * Servlet implementation class MusicSearchservlet
 */
@WebServlet("/MusicSearchservlet")
public class MusicSearchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicSearchservlet() {
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
			 MusicSearchSrv search1 = new MusicSearchSrv();
			 String search = request.getParameter("search");
	         List<MusicSearchVO> Mvo = search1.getMusicSearchAll(search);
	         if (search != null) {
	            System.out.println("aaa");
	            request.setAttribute("search", search);			
				request.getRequestDispatcher("/MusicSearch.jsp").forward(request, response);
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

