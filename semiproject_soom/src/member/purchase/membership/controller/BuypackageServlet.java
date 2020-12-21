package member.purchase.membership.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.purchase.membership.model.service.BuypackageSrv;
import member.purchase.membership.model.vo.BuypackageVO;

/**
 * Servlet implementation class BuypackageServlet
 */
@WebServlet("/BuypackageServlet")
public class BuypackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuypackageServlet() {
        super();
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

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String mem_id = "aaaa";
		String ms_no = "0";

		try {
			if (request.getSession().getAttribute("mem_id") != null) {
				mem_id = (String) request.getSession().getAttribute("mem_id");
			}
			if (request.getParameter("ms_no") != null) {
				ms_no = request.getParameter("ms_no");
			}
			java.util.Date lastday = calDate1(0, 1, 0);
			java.sql.Date ms_p_left = new java.sql.Date(lastday.getTime());

			BuypackageVO vo = new BuypackageVO(mem_id, ms_no, null, ms_p_left);
			System.out.println("a1");
			BuypackageSrv Bsrv = new BuypackageSrv();
			System.out.println("a2");
			int result = Bsrv.insertBuypackage(vo);
			System.out.println("a3:" + result);
			if (result != 0) {
				System.out.println("Buypackage 성공");
				if(ms_no.equals('3')) {
					out.append("Mp3_50 패키지 구매를 완료 했습니다.");
				} else if(ms_no.equals('4')) {
					out.append("Mp3_40 패키지 구매를 완료 했습니다.");
				}
				//request.getRequestDispatcher("/membership.jsp").forward(request, response);
			} else {
				System.out.println("bbb");
				if(ms_no.equals('3')) {
					out.append("Mp3_50 패키지 구매에 실패하셨습니다. 다시 시도해 주세요.");
				} else if(ms_no.equals('4')) {
					out.append("Mp3_40 패키지 구매에 실패하셨습니다. 다시 시도해 주세요.");
				}
			}
		} catch (Exception e) {
			System.out.println("ccc");
			out.append("오류가 발생했습니다. 문의해 주시기 바랍니다.");
		} finally {
			out.flush();
			out.close();
		}
	}
private Date calDate1(int year, int month, int day) {
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