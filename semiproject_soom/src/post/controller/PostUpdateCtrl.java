package post.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import post.model.service.PostSrv;
import post.model.vo.PostVO;

/**
 * Servlet implementation class PostUpdateServlet
 */
@WebServlet("/postUpdateServlet.lo")
public class PostUpdateCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String realFolder = "";		// 웹상의 절대 경로
    private final String saveFolder = "/fileSave";
    private final String encType = "utf-8";	// 인코딩 타입
    private final int maxSize = 5*1024*1024;	// 최대 업로드 파일크기 5mb  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostUpdateCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		realFolder = "d:\\abc";
		System.out.println(request.getParameter("que_no"));
		System.out.println(request.getParameter("que_name"));
		System.out.println(request.getParameter("que_content"));
		try {
			// 저장 되는 타이밍
			MultipartRequest mRequest = new MultipartRequest(request, realFolder, maxSize, new DefaultFileRenamePolicy());
			
			// 전송된 파일 정보를 가져옴.
			String fileName1 ="";
			Enumeration<?> files = mRequest.getFileNames();
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();	//input file로 된 name="xxx"
				String filename= mRequest.getFilesystemName(name);	// 서버에 저장된 파일이름
				fileName1 = filename;
				String original = mRequest.getOriginalFileName(name); // 전송되어오기전 원래이름
				String type = mRequest.getContentType(name);	//전송된 파일의 타입
				File f1 = mRequest.getFile(name);	// name을 이용해서 파일 객체 생성  - 파일 저장 되었나 확인
				if(f1==null) {	//name을 이용해서 파일 객체 생성에 실패하면 
					System.out.println("파일 업로드 실패");	// 실패 오류 메시지
				} else{
					System.out.println(f1.length());	// 그 파일의 크기
				}
				System.out.println(name);
				System.out.println(filename);
				System.out.println(original);
				System.out.println(type);
			}
			PostVO vo = new PostVO();
			vo.setQue_no(Integer.parseInt(mRequest.getParameter("que_no")));
			vo.setQue_name(mRequest.getParameter("que_name"));
			vo.setQue_content(mRequest.getParameter("que_content"));
			vo.setQue_file(fileName1);
			/*
			 * int que_no = Integer.parseInt(request.getParameter("que_no"));
			 * System.out.println(que_no); String que_name =
			 * request.getParameter("que_name"); System.out.println(que_name); String
			 * que_content = request.getParameter("que_content");
			 * System.out.println(que_content); String que_file =
			 * request.getParameter("que_file"); System.out.println(que_file);
			 */
			
			PostSrv PService= new PostSrv();
			int result = PService.updateQues(vo.getQue_no(), vo.getQue_name(), vo.getQue_content(), vo.getQue_file());
			if(result>0) {
				response.sendRedirect("postListServlet");
			} else {
				request.getRequestDispatcher("./board/bwrite1.jsp"+"수정sql").forward(request, response);
			}
		} catch(NumberFormatException e) {
			e.printStackTrace();
			request.getRequestDispatcher("./board/bwrite2.jsp"+"수정넘버포맷").forward(request, response);
		} catch(NullPointerException e) {
			e.printStackTrace();
			request.getRequestDispatcher("./board/bwrite.jsp"+"수정널포인터").forward(request, response);
		}
		
	}

}
