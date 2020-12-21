package memberPost.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberPost.service.MemberPostSrv;
import memberPost.vo.MemberPostVo;

/**
 * Servlet implementation class ManagerPostListCtrl
 */
@WebServlet("/MemberPostListCtrl")
public class MemberPostListCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPostListCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		MemberPostSrv postService = new MemberPostSrv();
		int pageSize = 10; //  한 페이지당글수
		int pageBlock = 10; // 한 화면에 나타날 페이지 링크 수
		
		try { 
			// 총 글 개수
			int pCount = postService.getBoardCount();
			// 현재 page 값으로 들고 들어온 것을 확인
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1"; // 현재 page 값을 들고 들오온게 없다면 1번째 page 보여주기
			} else if (pageNum.equals("")) {
				pageNum = "1";
			}
			int currentPage = Integer.parseInt(pageNum); // 현재 page  

			// 총 페이지 개수 = (충 글개수 / 페이지당글수) + (총 글개수에서 페이지당글개수 나눈 나머지가 0 이라면 0, 나머지가 있다면 페이지 개수를 1 증가함) 
			int pageCount = (pCount / pageSize) + (pCount % pageSize == 0 ? 0 : 1);
			int startPage = 1; // 화면에 나타날 시작 페이지
			int endPage = 1; // 화면에 나나날 마지막 페이지

			if (currentPage % pageBlock == 0) { // 즉 currentPage가 10, 20, 30.. 인 경우 11~20인 페이지, 21~30인 페이지가 보일 수 있음을 방지함
				startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
			} else {
				startPage = ((currentPage / pageBlock)) * pageBlock + 1;
			}

			endPage = startPage + pageBlock - 1; // - 1 빼줘야 함. 1~10 --> 즉 1 + 9 = 10, 총 글 35개, 총페이지는 4개, 10
			if (endPage > pageCount)
				endPage = pageCount;

			// 화면에 보여줄 게시글 rownum 구하기
			int startRnum = (currentPage - 1) * pageSize + 1;
			int endRnum = startRnum + pageSize - 1; // currentPage*pageSize
			List<MemberPostVo> list = MemberPostSrv.postList(startRnum, endRnum);
			
			System.out.println("aaaaaa");
			request.setAttribute("postList", list);
			request.setAttribute("PageNum", currentPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.getRequestDispatcher("/memberPost/pList.jsp").forward(request, response);
		
		} catch (Exception e) {
			System.out.println("bbbbbb");
			request.getRequestDispatcher("/memberPost/pList.jsp").forward(request, response);
		}
	
	}

}
