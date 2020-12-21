package main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import main.model.service.MainService;
import main.model.vo.MainVO;

/**
 * Servlet implementation class MainToPlayListSrv
 */
@WebServlet("/mainToPlayListSrv")
public class MainToPlayListSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainToPlayListSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mu_no = request.getParameter("mu_no");
		PrintWriter out = response.getWriter();
		try {
			System.out.println(request.getParameter("mem_id"));
			System.out.println(request.getParameter("mu_no"));
			MainService mservice = new MainService();
			int result = mservice.addMyPlayList(mem_id, mu_no);
			if(result>=1) {
				System.out.println("플레이리스트 추가 성공!");
			} else {
				System.out.println("플레이리스트 추가 실패ㅠ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("캐치 익셉션 오류");
		} finally {
			out.flush();
			out.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
