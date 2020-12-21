package member.purchase.membership.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.purchase.membership.model.service.MemberShipSrv;
import member.purchase.membership.model.service.StreamingSrv;
import member.purchase.membership.model.vo.MembershipVO;
import member.purchase.membership.model.vo.StreamingVO;

/**
 * Servlet implementation class StreamingServlet
 */
@WebServlet("/StreamingServlet")
public class StreamingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StreamingServlet() {
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
		// TODO Auto-generated method stub
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      String mem_id ="aaaa";
	      String ms_no = "0";

	      try {
	    	  if(request.getSession().getAttribute("mem_id") !=null){
	    		  mem_id =(String) request.getSession().getAttribute("mem_id");
	    	  }
				if(request.getParameter("ms_no") !=null) {
					ms_no = request.getParameter("ms_no");
				}
	//3개월 오늘 날짜로 부터 3개훨 후 날짜로 입력
			java.util.Date lastday = calDate(0, 3, 0);
			java.sql.Date ms_str_left = new java.sql.Date(lastday.getTime());
//			java.util.Date u = new java.util.Date();
//			java.sql.Date s = new java.sql.Date(u.getTime());
			StreamingVO vo = new StreamingVO(mem_id, ms_no, null, ms_str_left);
			System.out.println("a1");
			StreamingSrv msSrv = new StreamingSrv();  
			System.out.println("a2");
			int result = msSrv.insertStreaming(vo);
			System.out.println("a3: " + result);
			if (result != 0) {   // insert 성공
				System.out.println("insertStreaming 성공");			
				out.append("streaming 구매를 완료했습니다.");
//				request.getRequestDispatcher("/membership.jsp").forward(request, response);
			} else {   // insert 실패
				System.out.println("bbb");
				out.append("insertStreaming 구매에 실패하셨습니다. 다시 시도해 주세요.");
//				request.setAttribute("errMsg", "  ");
//				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("ccc");
			out.append("오류가 발생했습니다. 문의해 주시기 바랍니다.");
//			request.setAttribute("errMsg", "잠시후 다시 이용해 주세요.");
//			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		} finally {
			out.flush();
			out.close();
		}
	}
	
//	public class StreamingSrv {
//		public int insertStreaming(StreamingVO vo) {

    private Date calDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("current: " + df.format(cal.getTime()));
        cal.add(Calendar.MONTH, year);
        cal.add(Calendar.MONTH, month);
        cal.add(Calendar.DATE, day);
        System.out.println("after: " + df.format(cal.getTime()));
        return cal.getTime();
    }
    }

