package manager.allfile.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.allfile.service.ManagerAllfileSrv;
import manager.allfile.vo.ManagerAllfileVO;

/**
 * Servlet implementation class ManagerAllfileSelectOneCtrl
 */
@WebServlet("/SelectOne")
public class ManagerAllfileSelectOneCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAllfileSelectOneCtrl() {
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
		int num = Integer.parseInt(request.getParameter("num"));

		try {
			ManagerAllfileSrv fileService = new ManagerAllfileSrv();
			ManagerAllfileVO vo = fileService.selectOne(num);

			if (vo != null) {
				request.setAttribute("vo", vo);
			} else {
				System.out.println("조회실패..");
			}
			RequestDispatcher dis = request.getRequestDispatcher("/allfile/allfileView.jsp");
			dis.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
