package album.more.comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import album.more.comment.model.service.AlbumCommentSrv;
import album.more.comment.model.vo.AlbumCommentVO;

/**
 * Servlet implementation class albumCommentDeleteCtrl
 */
@WebServlet("/albumCommentDeleteCtrl")
public class AlbumCommentDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumCommentDeleteCtrl() {
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
		
		int al_co_no = Integer.parseInt(request.getParameter("al_co_no"));
		String al_no = request.getParameter("al_no");
		System.out.println(al_co_no);
		System.out.println(Integer.parseInt(request.getParameter("al_co_no")));
		try {
			AlbumCommentVO vo = new AlbumCommentVO();
			vo.setAl_co_no(Integer.parseInt(request.getParameter("al_co_no")));
			AlbumCommentSrv PService= new AlbumCommentSrv();
			int result = PService.deleteAlComment(vo.getAl_co_no());
			if(result>0) {
				request.setAttribute("al_no", al_no);
				RequestDispatcher disp = request.getRequestDispatcher("albumMoreServlet");
				disp.forward(request, response);
			} else {
				System.out.println("딜리트sql");
				request.getRequestDispatcher("./board/bwrite1.jsp").forward(request, response);
			}
		} catch(NumberFormatException e) {
			System.out.println("딜리트넘버포맷");
			request.getRequestDispatcher("./board/bwrite2.jsp").forward(request, response);
		} catch(NullPointerException e) {
			System.out.println("딜리트널포인터");
			request.getRequestDispatcher("./board/bwrite3.jsp").forward(request, response);
		}
		
	}

}
