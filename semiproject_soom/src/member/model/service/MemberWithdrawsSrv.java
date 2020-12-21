package member.model.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dao.MemberLoginDao;
import member.model.vo.MemberLoginVO;

/**
 * Servlet implementation class MemberWithdrawsSrv
 */
@WebServlet("/MemberWithdrawsSrv")
public class MemberWithdrawsSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWithdrawsSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
 		execute(request, response);
     }
 	
 		protected void doPost(HttpServletRequest request, HttpServletResponse response)
 				throws ServletException, IOException {
 			execute(request, response);
 		}

 		private void execute(HttpServletRequest request, HttpServletResponse response)
 				throws ServletException, IOException {
 			request.setCharacterEncoding("UTF-8");
 			response.setContentType("text/html; charset=UTF-8");
 			PrintWriter writer = response.getWriter(); //다음 보낼 위치에 스크립트문을 만들수있게 해줌
 
 			String pwd=request.getParameter("mem_pwd");
 			
 			HttpSession session = request.getSession();
 			
 			MemberLoginVO vo = (MemberLoginVO)session.getAttribute("ssLogInfo"); //로그인 정보를 찾아옴
			System.out.println(vo.getMem_pwd());	//그중 pwd값을 찾아옴
			System.out.println(pwd);
			
			if(pwd.equals(vo.getMem_pwd())) {
				
				MemberLoginDao dao = new MemberLoginDao();
				int res = dao.MemberDelete(vo.getMem_id());
				if(res==1) {
					writer.println("<script>alert('회원탈퇴가 완료되었습니다.');location.href='memberLogin.jsp';</script>");
					writer.close();
				}
			}else {
				writer.println("<script>alert('비밀번호가 일치하지 않습니다');location.href='memberWithdraws.jsp';</script>");
				writer.close();
			}
			
			
 		}
}