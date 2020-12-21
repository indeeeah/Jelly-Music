package music.list.memberRec.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.vo.MainVO;
import music.list.memberRec.model.service.MemberRecSrv;
import music.list.memberRec.model.vo.MemberRecVO;

/**
 * Servlet implementation class memberRecServlet
 */
@WebServlet("/memberRecServlet")
public class MemberRecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mu_no = request.getParameter("mu_no");
		PrintWriter out = response.getWriter();
		try {
			System.out.println(request.getParameter("mem_id"));
			System.out.println(request.getParameter("mu_no"));
			MemberRecSrv MemberRec = new MemberRecSrv();
			List<MemberRecVO> rvo = MemberRec.setMemberRecAll();
		      List<MainVO> searlist = MemberRec.searchWord();
		         request.setAttribute("searlist", searlist);
			if(rvo != null) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}