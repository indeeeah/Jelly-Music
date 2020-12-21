package artist.more.comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.more.comment.model.service.ArtistCommentSrv;
import artist.more.comment.model.vo.ArtistCommentVO;

/**
 * Servlet implementation class ArtistCommentDeleteCtrl
 */
@WebServlet("/artistCommentDeleteCtrl")
public class ArtistCommentDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistCommentDeleteCtrl() {
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
		
		int art_co_no = Integer.parseInt(request.getParameter("art_co_no"));
		String art_no = request.getParameter("art_no");
		System.out.println(art_co_no);
		System.out.println(Integer.parseInt(request.getParameter("art_co_no")));
		try {
			ArtistCommentVO vo = new ArtistCommentVO();
			vo.setArt_co_no(Integer.parseInt(request.getParameter("art_co_no")));
			ArtistCommentSrv PService= new ArtistCommentSrv();
			int result = PService.deleteArtComment(vo.getArt_co_no());
			if(result>0) {
				request.setAttribute("art_no", art_no);
				RequestDispatcher disp = request.getRequestDispatcher("artistMoreServlet");
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
