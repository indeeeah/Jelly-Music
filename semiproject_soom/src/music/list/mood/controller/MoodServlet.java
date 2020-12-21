package music.list.mood.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.vo.MainVO;
import music.list.mood.model.service.MoodSrv;
import music.list.mood.model.vo.MoodVO;

/**
 * Servlet implementation class MoodServlet
 */
@WebServlet("/MoodServlet")
public class MoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mem_id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoodServlet() {
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
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=UTF-8");

      try {
         MoodSrv mSrv = new MoodSrv();
         List<MoodVO> mood = mSrv.setMoodAll();
//            List<MainVO> himem = mSrv.helloToMem(mem_id);
         List<MainVO> searlist = mSrv.searchWord();
         request.setAttribute("searlist", searlist);
         if (mood != null) {
            System.out.println("aaa");
            request.setAttribute("mood", mood);
            request.getRequestDispatcher("/Mood.jsp").forward(request, response);
         } else {
            System.out.println("bbb");
            request.setAttribute("errMsg", "현재 서비스를 이용할 수 없습니다. 추후 서비스 예정입니다.");
            request.getRequestDispatcher("/Mood.jsp").forward(request, response);
         }
      } catch (Exception e) {
         System.out.println("ccc");
         request.setAttribute("errMsg", "잠시후 다시 이용해 주세요.");
         request.getRequestDispatcher("/Mood.jsp").forward(request, response);
      }
   }

}
