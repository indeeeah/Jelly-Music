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
 * Servlet implementation class AlbumCommentWriteCtrl
 */
@WebServlet("/albumCommentWriteCtrl")
public class AlbumCommentWriteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumCommentWriteCtrl() {
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
		//한글
		try {
			String al_no = request.getParameter("al_no");
			System.out.println("앨범번호"+al_no);
			String mem_id = request.getParameter("mem_id");
			System.out.println(mem_id);
			AlbumCommentVO vo = new AlbumCommentVO();
			//hidden으로 들고 들어온 데이터 - 원본글, 댓글에 대한 정보를 가지고 있음.
			vo.setAl_co_no(Integer.parseInt(request.getParameter("al_co_no")));
			vo.setAl_ref(Integer.parseInt(request.getParameter("al_ref")));
			vo.setAl_step(Integer.parseInt(request.getParameter("al_step")));
			vo.setAl_level(Integer.parseInt(request.getParameter("al_level")));
			vo.setAl_cont(request.getParameter("al_cont"));
			vo.setMem_id(request.getParameter("mem_id"));
			vo.setAl_no(request.getParameter("al_no"));
			
			AlbumCommentSrv dService= new AlbumCommentSrv();
			int result = dService.writeAlComment(vo);
			if(result>=1) {
				System.out.println("앨범댓글성공");
				request.setAttribute("al_no", al_no);
				RequestDispatcher disp = request.getRequestDispatcher("albumMoreServlet");
				disp.forward(request, response);
			} else {
				System.out.println("앨범댓글실패");
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println("앨범댓글넘버포맷");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		} catch (NullPointerException e) {
			System.out.println("앨범댓글널포인터");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
		
	}

}
