package music.more.comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.more.comment.model.service.MusicCommentSrv;
import music.more.comment.model.vo.MusicCommentVO;

/**
 * Servlet implementation class MusicCommentDeleteCtrl
 */
@WebServlet("/musicCommentDeleteCtrl")
public class MusicCommentDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicCommentDeleteCtrl() {
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
		
		int mu_co_no = Integer.parseInt(request.getParameter("mu_co_no"));
		String mu_no = request.getParameter("mu_no");
		System.out.println(mu_co_no);
		System.out.println(Integer.parseInt(request.getParameter("mu_co_no")));
		try {
			MusicCommentVO vo = new MusicCommentVO();
			vo.setMu_co_no(Integer.parseInt(request.getParameter("mu_co_no")));
			MusicCommentSrv PService= new MusicCommentSrv();
			int result = PService.deleteMuComment(vo.getMu_co_no());
			if(result>0) {
				request.setAttribute("mu_no", mu_no);
				RequestDispatcher disp = request.getRequestDispatcher("musicMoreServlet");
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
