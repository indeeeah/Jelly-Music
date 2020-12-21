package manager.managerPost.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.managerPost.service.ManagerPostSrv;

/**
 * Servlet implementation class managerPostWriteCtrl
 */
@WebServlet("/ManagerPostWriteCtrl")
public class ManagerPostWriteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPostWriteCtrl() {
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
		
		String p_name = request.getParameter("p_name");
		String p_content = request.getParameter("p_content");
		String mng_id = request.getParameter("mng_id");
		PrintWriter out = response.getWriter();
		try {
			ManagerPostSrv postService = new ManagerPostSrv();
			int result = postService.postWrite(p_name, p_content, mng_id);
			if(result >=1) {
				System.out.println("aaa");
				response.sendRedirect("./ManagerPostListCtrl");
			} else {
				System.out.println("bbb");
				request.getRequestDispatcher("/post/pWrite.jsp").forward(request, response);
				out.println("<script>alert('다시 입력해 주세요.');</script>");
			}
		} catch (Exception e) {
			System.out.println("ccc");
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}

}
