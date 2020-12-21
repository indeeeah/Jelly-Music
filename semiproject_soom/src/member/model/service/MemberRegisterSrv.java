package member.model.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberLoginDao;
import member.model.vo.MemberLoginVO;

/**
 * Servlet implementation class MemberRegisterSrvCtrl
 */
@WebServlet("/memberRegisterSrv.do")
public class MemberRegisterSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberRegisterSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter writer = response.getWriter(); //다음 보낼 위치에 스크립트문을 만들수있게 해줌
		String mem_id = request.getParameter("mem_id");
		String mem_pwd = request.getParameter("mem_pwd");
		String mem_name = request.getParameter("mem_name");
		String mem_email = request.getParameter("mem_email");
		String mem_birth = request.getParameter("mem_birth");
		String mem_phone = request.getParameter("mem_phone");
		String mem_gender = request.getParameter("mem_gender");

		String method = request.getMethod();
		if ("GET".equalsIgnoreCase(method)) {
			RequestDispatcher disp = request.getRequestDispatcher("../memberRegister.jsp");
			disp.forward(request, response);
		} else {
			if (!mem_id.equals("") && !mem_pwd.equals("") && !mem_name.equals("") && !mem_email.equals("") && !mem_phone.equals("") && !mem_gender.equals("")) {
				MemberLoginVO mvo = new MemberLoginVO();
//				mvo.setMem_birth(mem_birth);
				mvo.setMem_gender(Integer.parseInt(mem_gender));
				mvo.setMem_id(mem_id);
				mvo.setMem_name(mem_name);
				mvo.setMem_email(mem_email);
				mvo.setMem_phone(mem_phone);
				mvo.setMem_pwd(mem_pwd);
				try {
					MemberLoginDao dao = new MemberLoginDao();
					int result = dao.MemberRegisterSrv(mvo);
					if (result == 1) {
						request.setAttribute("mem_id", mem_id);
						System.out.println("mem_id 1" + mem_id);
						request.getRequestDispatcher("firstArtistCtrl.do").forward(request, response);
//						writer.println("<script>alert('다음 단계를 수행해주세요!');location.href='firstArtistCtrl.do';</script>");
//						writer.close();
//			
					} else {
						RequestDispatcher disp1 = request.getRequestDispatcher("../error.jsp");
						disp1.forward(request, response);
					}
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("errorMsg", "SQL 또는 예기치 못한 장애발생으로 데이터 입력 실패함!!!");
					RequestDispatcher disp2 = request.getRequestDispatcher("../error.jsp");
					disp2.forward(request, response);
				}
			} else {
				RequestDispatcher disp3 = request.getRequestDispatcher("../memberRegister.jsp");
				disp3.forward(request, response);
			}

		}
	}

}
