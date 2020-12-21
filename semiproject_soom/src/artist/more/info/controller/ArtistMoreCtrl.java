package artist.more.info.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.more.comment.model.vo.ArtistCommentVO;
import artist.more.info.model.service.ArtistMoreSrv;
import artist.more.info.model.vo.ArtistMoreVO;

/**
 * Servlet implementation class AtistMoreServlet
 */
@WebServlet("/artistMoreServlet")
public class ArtistMoreCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistMoreCtrl() {
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
			ArtistMoreSrv AMService = new ArtistMoreSrv();
			String art_no = request.getParameter("art_no");
			
			List<ArtistMoreVO> info = AMService.getArtistInfo(art_no);
			List<ArtistMoreVO> tracks = AMService.getTracks(art_no);
			List<ArtistMoreVO> sList = AMService.getSingles(art_no);
			List<ArtistMoreVO> similar = AMService.getSimilar(art_no);

			List<ArtistCommentVO> clist = AMService.getArtComment(art_no);
			if(info!= null) {
				System.out.println("aaaaaa1");
				request.setAttribute("info", info);
				System.out.println("aaaaaa2");
				request.setAttribute("tracks", tracks);
				System.out.println("aaaaaa3");
				request.setAttribute("sList", sList);
				System.out.println("aaaaaa4");
				request.setAttribute("similar", similar);
				System.out.println("aaaaaa5");
				request.setAttribute("clist", clist);
				System.out.println("aaaaaa6");
				request.getRequestDispatcher("/artistMore.jsp").forward(request, response);
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
