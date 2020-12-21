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
 * Servlet implementation class ArtistCommentWriteCtrl
 */
@WebServlet("/artistCommentWriteCtrl")
public class ArtistCommentWriteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistCommentWriteCtrl() {
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
			String art_no = request.getParameter("art_no");
			System.out.println("아티스트번호"+art_no);
			String mem_id = request.getParameter("mem_id");
			System.out.println(mem_id);
			ArtistCommentVO vo = new ArtistCommentVO();
			//hidden으로 들고 들어온 데이터 - 원본글, 댓글에 대한 정보를 가지고 있음.
			vo.setArt_co_no(Integer.parseInt(request.getParameter("art_co_no")));
			vo.setArt_ref(Integer.parseInt(request.getParameter("art_ref")));
			vo.setArt_step(Integer.parseInt(request.getParameter("art_step")));
			vo.setArt_level(Integer.parseInt(request.getParameter("art_level")));
			vo.setArt_cont(request.getParameter("art_cont"));
			vo.setMem_id(request.getParameter("mem_id"));
			vo.setArt_no(request.getParameter("art_no"));
			
			ArtistCommentSrv dService= new ArtistCommentSrv();
			int result = dService.writeArtComment(vo);
			if(result>=1) {
				System.out.println("아티스트댓글성공");
				request.setAttribute("art_no", art_no);
				RequestDispatcher disp = request.getRequestDispatcher("artistMoreServlet");
				disp.forward(request, response);
			} else {
				System.out.println("아티스트댓글실패");
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println("아티스트댓글넘버포맷");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		} catch (NullPointerException e) {
			System.out.println("아티스트댓글널포인터");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
		
	}

}
