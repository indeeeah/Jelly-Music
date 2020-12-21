package artist.search.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import artist.more.info.model.vo.ArtistMoreVO;
import artist.search.model.service.ArtistSearchSrv;
import main.model.service.MainService;
import main.model.vo.MainVO;
import test.search.TestSearchSrv;

/**
 * Servlet implementation class ArtistSearchCtrl
 */
@WebServlet("/artistSearchCtrl")
public class ArtistSearchCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArtistSearchCtrl() {
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
		HttpSession httpSession = request.getSession();

		String mem_id = (String)request.getAttribute("mem_id");
		try {
			String art_no = request.getParameter("art_no");
			MainService mservice = new MainService();
			List<MainVO> himem = mservice.helloToMem(mem_id);
			ArtistSearchSrv ASService = new ArtistSearchSrv();
			List<ArtistMoreVO> aslist = ASService.getArtistSearch(art_no);
			List<MainVO> searlist = mservice.searchWord();
			
			if(art_no!=null) {
				System.out.println("aaa");
				request.setAttribute("aslist", aslist);
				System.out.println("aslist:"+art_no);
				request.setAttribute("himem", himem);
				request.getRequestDispatcher("/artistSearch.jsp").forward(request, response);
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
