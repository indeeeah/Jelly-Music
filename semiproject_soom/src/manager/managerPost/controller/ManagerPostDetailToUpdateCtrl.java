package manager.managerPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.managerPost.service.ManagerPostSrv;
import manager.managerPost.vo.ManagerPostVo;

/**
 * Servlet implementation class ManagerPostDetailToUpdateCtrl
 */
@WebServlet("/ManagerPostDetailToUpdateCtrl")
public class ManagerPostDetailToUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPostDetailToUpdateCtrl() {
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
		
		try {
			int strp_no = Integer.parseInt(request.getParameter("p_no"));
			ManagerPostSrv postService = new ManagerPostSrv();
			ManagerPostVo vo = postService.postDetail(strp_no);
			if(vo != null) {
				request.setAttribute("updateList", vo);
				request.getRequestDispatcher("/post/pUpdate.jsp").forward(request, response);
			} else {
				System.out.println("실패!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
