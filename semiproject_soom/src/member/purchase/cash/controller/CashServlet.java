package member.purchase.cash.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.purchase.cash.model.service.CashSrv;
import member.purchase.cash.model.vo.CashVO;

/**
 * Servlet implementation class cashServlet
 */
@WebServlet("/cashServlet")
public class CashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashServlet() {
        super();
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String mem_id = "aaa";
		int cs_price = 0;
		int cs_left = 0;

		try {
			if (request.getSession().getAttribute("mem_id") != null) {
				mem_id = (String) request.getSession().getAttribute("mem_id");
			}
			if (request.getParameter("price") == null) {
				out.append("구매금액이 선택되지 않았습니다.선택해주세요.");

			} else {
				cs_price = Integer.parseInt(request.getParameter("price"));

				CashVO vo = new CashVO(mem_id, cs_price, cs_left);
				System.out.println("a1");
				CashSrv cSrv = new CashSrv();
				System.out.println("a2");
				int result = cSrv.insertCash(vo);
				System.out.println("a3: " + result);
				if (result != 0) {
					System.out.println("insertCash 성공");
					out.append("캐쉬 충전이 완료되었습니다.");
					request.getRequestDispatcher("/membership.jsp").forward(request, response);
				} else {
					System.out.println("bbb");
					out.append("insertCash충전에 실패하셨습니다. 다시 시도해 주세요.");

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
}
