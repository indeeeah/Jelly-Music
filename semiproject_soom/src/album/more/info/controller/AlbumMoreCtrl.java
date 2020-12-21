package album.more.info.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import album.more.comment.model.service.AlbumCommentSrv;
import album.more.comment.model.vo.AlbumCommentVO;
import album.more.info.model.service.AlbumMoreSrv;
import album.more.info.model.vo.AlbumMoreVO;
import music.more.comment.model.service.MusicCommentSrv;
import music.more.comment.model.vo.MusicCommentVO;

/**
 * Servlet implementation class MusicMoreServlet
 */
@WebServlet("/albumMoreServlet")
public class AlbumMoreCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumMoreCtrl() {
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
			AlbumMoreSrv AMService = new AlbumMoreSrv();
			AlbumCommentSrv ACService = new AlbumCommentSrv();
			String al_no = request.getParameter("al_no");
			
			List<AlbumMoreVO> info = AMService.getAlbumInfo(al_no);
			List<AlbumMoreVO> minclude = AMService.getIncludeMu(al_no);
			List<AlbumMoreVO> sList = AMService.getSingles(al_no);
			List<AlbumMoreVO> alist = AMService.getAlike(al_no);
			/* List<AlbumMoreVO> video = AMService.getAlbumVideo(); */

			List<AlbumCommentVO> clist = ACService.getAlComment(al_no);
			if(info!= null) {
				System.out.println("aaaaaa");
				request.setAttribute("info", info);
				request.setAttribute("minclude", minclude);
				request.setAttribute("sList", sList);
				request.setAttribute("alist", alist);
				
				request.setAttribute("clist", clist);
				request.getRequestDispatcher("albumMore.jsp").forward(request, response);
			} else {
				System.out.println("bbbbbb");
				request.setAttribute("errMsg", "작성된 글이 없습니다.");
				request.getRequestDispatcher("/views/board/musicCommentTest1.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("cccccc");
			request.setAttribute("errMsg", "잠시 후 다시 확인해 주세요");
			request.getRequestDispatcher("/views/board/musicCommentTest2.jsp").forward(request, response);
		}
	}
}
