package post.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.PostSrv;
import post.model.vo.PostVO;

/**
 * Servlet implementation class PostDeleteServlet
 */
@WebServlet("/postDeleteServlet")
public class PostDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDeleteCtrl() {
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
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		int que_no = Integer.parseInt(request.getParameter("que_no"));
		System.out.println(que_no);
		System.out.println(Integer.parseInt(request.getParameter("que_no")));
		try {
			System.out.println("딜리트 트라이");
			PostVO vo = new PostVO();
			vo.setQue_no(Integer.parseInt(request.getParameter("que_no")));
			PostSrv PService= new PostSrv();
			int result = PService.deleteQues(vo.getQue_no());
			if(result>0) {
				response.sendRedirect("postListServlet");
			} else {
				request.getRequestDispatcher("./board/bwrite1.jsp"+"딜리트sql").forward(request, response);
			}
		} catch(NumberFormatException e) {
			request.getRequestDispatcher("./board/bwrite2.jsp"+"딜리트넘버포맷").forward(request, response);
		} catch(NullPointerException e) {
			request.getRequestDispatcher("./board/bwrite3.jsp"+"딜리트널포인터").forward(request, response);
		}
		
	}

}
