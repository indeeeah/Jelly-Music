package member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/main")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService mservice = new MemberService();

		// 전달 받은 파라미터 값을 변수에 담아 새로운 객체를 생성한다
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		// 변수에 미리 담아 두면 예외 처리하기 좋음
		try {
			System.out.println("ㅁㅁ");
			int result = mservice.insertMember(new Member(id, passwd, name, email));
			if (result == 1) {
				System.out.println("bbb");
				response.sendRedirect("index.jsp");
			} else {
				System.out.println("ccc");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// m == null
			// conn연결에 실패
			// sql 문 처리에 실패 , 컬럼이름 및 table 이름에 오타, 데이터 크기가 맞지 않는 경우,unique... constraints에 걸리는 경우
			
			// TODO: handle exception
			
		}

	}

}
