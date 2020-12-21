package manager.managerPost.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.managerPost.service.ManagerPostSrv;

/**
 * Servlet implementation class ManagerPostDeleteCtrl
 */
@WebServlet("/ManagerPostDeleteCtrl")
public class ManagerPostDeleteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPostDeleteCtrl() {
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
		ManagerPostSrv postService = new ManagerPostSrv();
		String p_no = request.getParameter("p_no");
		try {
			int result = postService.postDelete(p_no);
			if(result == 1) {
				response.sendRedirect("ManagerPostListCtrl");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
