package memberPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.managerPost.service.ManagerPostSrv;
import manager.managerPost.vo.ManagerPostVo;
import memberPost.service.MemberPostSrv;
import memberPost.vo.MemberPostVo;

/**
 * Servlet implementation class ManagerPostDetail
 */
@WebServlet("/MemberPostDetailCtrl")
public class MemberPostDetailCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPostDetailCtrl() {
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
		try {
			int strp_no = Integer.parseInt(request.getParameter("p_no"));
			MemberPostSrv postService = new MemberPostSrv();
			MemberPostVo vo = postService.postDetail(strp_no);
			if(vo != null) {
				request.setAttribute("detailList", vo);
				request.getRequestDispatcher("/memberPost/pDetail.jsp").forward(request, response);
			} else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
