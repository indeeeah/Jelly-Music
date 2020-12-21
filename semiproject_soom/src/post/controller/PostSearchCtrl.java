package post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import post.model.service.PostSrv;
import post.model.vo.PostVO;

/**
 * Servlet implementation class PostSearchCtrl
 */
@WebServlet("/postSearchCtrl")
public class PostSearchCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostSearchCtrl() {
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
		int pageSize = 10; //  한 페이지당글수
		int pageBlock = 10; // 한 화면에 나타날 페이지 링크 수
		HttpSession httpSession = request.getSession();
		String quesSearch = request.getParameter("quesSearch");
		try {
			PostSrv PService = new PostSrv();
			int bCount = PService.getQuesWriterCount(quesSearch);
			String pageNum = request.getParameter("pageNum");
			if(pageNum == null){
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum);
			
			int pageCount = (bCount / pageSize) + (bCount % pageSize == 0 ? 0 : 1);
			int startPage = 1;
			int endPage = 1;
			
			if (currentPage % pageBlock == 0){
				startPage = ((currentPage/pageBlock)-1)*pageBlock +1;
			} else {
				startPage = ((currentPage/pageBlock))*pageBlock +1;
			}
			
			endPage = startPage+pageBlock - 1;
			if(endPage > pageCount) 
				endPage = pageCount;
			
			int startRnum = (currentPage-1)*pageSize+1;
			int endRnum = startRnum + pageSize - 1;		//currentPage*pageSize
			List<PostVO> QSearchW = PService.getQuesWriter(quesSearch, startRnum, endRnum);
//			List<PostVO> QSearchS = PService.getQuesSubject(keyword);
			if(quesSearch!=null) {
				System.out.println("aaa");
//				request.setAttribute("QSearchS", QSearchS);
				request.setAttribute("QSearchW", QSearchW);
				request.setAttribute("pageCount", pageCount);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("bCount", bCount);   
				request.setAttribute("pageNum", pageNum);   
				request.getRequestDispatcher("/memberQuesSearch.jsp").forward(request, response);
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
