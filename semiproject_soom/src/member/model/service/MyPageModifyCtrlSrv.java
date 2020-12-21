package member.model.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dao.MemberLoginDao;
import member.model.vo.MemberLoginVO;

/**
 * Servlet implementation class MyPageModifyCtrlSrv
 */
@WebServlet("/MyPageModifyCtrlSrv")
public class MyPageModifyCtrlSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageModifyCtrlSrv() {
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
			MemberLoginDao dao = new MemberLoginDao();
			
			
			String mem_pwd=request.getParameter("mem_pwd");
			String mem_name=request.getParameter("mem_name");
			String mem_birth=request.getParameter("mem_birth");
			String mem_email=request.getParameter("mem_email");
			String mem_phone=request.getParameter("mem_phone");

			HttpSession session = request.getSession();
			
			System.out.println(mem_pwd);
			System.out.println(mem_name);
			System.out.println(mem_birth);
			System.out.println(mem_email);
			System.out.println(mem_phone);
			
			MemberLoginVO vo = (MemberLoginVO)session.getAttribute("ssLogInfo");
			System.out.println(vo.getMem_id());
			int rs = dao.updateinfo(vo.getMem_id(),mem_pwd,mem_name,mem_email,mem_phone);
			 
			if(rs>0){
				
				writer.println("<script>alert('수정에 성공했습니다');location.href='ttest.jsp';</script>");
				writer.close();
			} else {
				writer.println("<script>alert('수정에  실패했습니다');location.href='myPageModify.jsp';</script>");
				writer.close();
			}

		}
    }

