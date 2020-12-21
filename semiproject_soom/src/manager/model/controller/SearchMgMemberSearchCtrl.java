package manager.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.model.service.SearchMgMemberSrv;
import manager.model.vo.SearchMgMemberVO;

/**
 * Servlet implementation class SearchMgMemberSearchCtrl
 */
@WebServlet("/SearchMgMemberSearchCtrl")
public class SearchMgMemberSearchCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMgMemberSearchCtrl() {
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
		SearchMgMemberSrv searchService = new SearchMgMemberSrv();	
		String searchWord = request.getParameter("searchWord");
		int pageSize = 10; // 세로
		int pageBlock = 10; // 가로
		System.out.println("111111111");
		try {
			// 총 글 개수
			int nCount = searchService.getSearchCount(searchWord);
			// 페이지 수 초기화
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			} else if (pageNum.equals("")) {
				pageNum = "1";
			}
			// startPage , endPage 구하는 식
			int currentPage = Integer.parseInt(pageNum);

			int pageCount = (nCount / pageSize) + (nCount % pageSize == 0 ? 0 : 1);
			int startPage = 1;
			int endPage = 1;
			if (currentPage % pageBlock == 0) {
				startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
			} else {
				startPage = ((currentPage / pageBlock)) * pageBlock + 1;
			}
			endPage = startPage + pageBlock - 1;
			if (endPage > pageCount) {
				endPage = pageCount;
			}
			// 페이징 rownum 구하기
			int startRnum = ((currentPage - 1) * pageSize) + 1; 
			int endRnum = startRnum + pageSize - 1; // currentPage*pageSize
			List<SearchMgMemberVO> list = SearchMgMemberSrv.memList(startRnum, endRnum);

			// 보내주기
			List<SearchMgMemberVO> searchList = searchService.memSearch(searchWord, startRnum, endRnum);
			System.out.println("startRnum");
			System.out.println("endRnum");
			if (list != null) {
				request.setAttribute("memList", searchList);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("PageNum", currentPage);
				request.setAttribute("searchWord", searchWord);
			}
			System.out.println("검색연결");
			RequestDispatcher disp = request.getRequestDispatcher("/searchMgMemDetail.jsp");
			disp.forward(request, response);
		} catch (Exception e) {
			System.out.println("검색 실패");
			e.printStackTrace();
		}
	}

}
