package music.more.comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import music.more.comment.model.service.MusicCommentSrv;
import music.more.comment.model.vo.MusicCommentVO;
import music.more.info.model.vo.MusicMoreVO;

/**
 * Servlet implementation class MusicCommentWriteCtrl
 */
@WebServlet("/musicCommentWriteCtrl.lo")
public class MusicCommentWriteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MusicCommentWriteCtrl() {
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
			String mu_no = request.getParameter("mu_no");
			System.out.println("음원번호"+mu_no);
			String mem_id = request.getParameter("mem_id");
			System.out.println(mem_id);
			MusicCommentVO vo = new MusicCommentVO();
			//hidden으로 들고 들어온 데이터 - 원본글, 댓글에 대한 정보를 가지고 있음.
			vo.setMu_co_no(Integer.parseInt(request.getParameter("mu_co_no")));
			vo.setMu_ref(Integer.parseInt(request.getParameter("mu_ref")));
			vo.setMu_step(Integer.parseInt(request.getParameter("mu_step")));
			vo.setMu_level(Integer.parseInt(request.getParameter("mu_level")));
			vo.setMu_cont(request.getParameter("mu_cont"));
			vo.setMem_id(request.getParameter("mem_id"));
			vo.setMu_no(request.getParameter("mu_no"));
			
			MusicCommentSrv dService= new MusicCommentSrv();
			int result = dService.writeMuComment(vo);
			if(result>=1) {
				System.out.println("뮤직댓글성공");
				request.setAttribute("mu_no1", mu_no);
				RequestDispatcher disp = request.getRequestDispatcher("musicMoreServlet");
				disp.forward(request, response);
			} else {
				System.out.println("뮤직댓글실패");
				request.getRequestDispatcher("./error.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println("뮤직댓글넘버포맷");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		} catch (NullPointerException e) {
			System.out.println("뮤직댓글널포인터");
			request.getRequestDispatcher("./error.jsp").forward(request, response);
		}
		
	}

}
