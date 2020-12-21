package post.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.model.service.PostSrv;
import post.model.vo.PostVO;

/**
 * Servlet implementation class PostContentServlet
 */
@WebServlet("/postContentServlet")
public class PostContentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostContentCtrl() {
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
			int que_no = Integer.parseInt(request.getParameter("que_no"));
			PostSrv PService = new PostSrv();
			List<PostVO> list = PService.getQues(que_no);	//bno를 가지고 읽어왔으므로 list는  0번 인덱스만 존재할 것임.
			PostVO vo = list.get(0);	
			String pageNum = request.getParameter("pageNum");
			System.out.println(pageNum);
			if(pageNum==null){
				pageNum="1";
			}

			if(list != null) {
				System.out.println("aaaaaa");
				request.setAttribute("list", vo);
				request.setAttribute("pageNum", pageNum);
				request.getRequestDispatcher("/memberQuesContent.jsp").forward(request, response);
			} else {
				System.out.println("bbbbbb");
				request.setAttribute("errMsg", "작성된 글이 없습니다.");
				request.getRequestDispatcher("/views/board/blist1.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("cccccc");
			request.setAttribute("errMsg", "잠시 후 다시 확인해 주세요");
			request.getRequestDispatcher("/views/board/blist2.jsp").forward(request, response);
		}
	}
}
