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
 * Servlet implementation class PostWriteServlet
 */
@WebServlet("/postWriteServlet.lo")
public class PostWriteCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String realFolder = "";		// 웹상의 절대 경로
    private final String saveFolder = "/fileSave";
    private final String encType = "utf-8";	// 인코딩 타입
    private final int maxSize = 5*1024*1024;	// 최대 업로드 파일크기 5mb  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostWriteCtrl() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		//request.getContextPath();	// -->프로젝트 이름 / url상의 context root 이름
		realFolder = "/Users/indeeah/Desktop/jelly_post";
		System.out.println(realFolder);

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
			//form에서 받아온 데이터 목록을 가져와서 하나씩 꺼냄.
//			Enumeration<?> params = mRequest.getParameterNames();
//			while(params.hasMoreElements()) {
//				String name=(String)params.nextElement();
//				String value = mRequest.getParameter(name);
//				
//			}
			
			PostVO vo = new PostVO();
			
			//hidden으로 들고 들어온 데이터 - 원본글, 댓글에 대한 정보를 가지고 있음.
			vo.setQue_no(Integer.parseInt(mRequest.getParameter("que_no")));
			vo.setQue_ref(Integer.parseInt(mRequest.getParameter("que_ref")));
			vo.setQue_step(Integer.parseInt(mRequest.getParameter("que_step")));
			vo.setQue_level(Integer.parseInt(mRequest.getParameter("que_level")));
			
			//직접입력한 데이터들
			vo.setMem_id(mRequest.getParameter("writer"));
			vo.setQue_name(mRequest.getParameter("que_name"));
			vo.setQue_content(mRequest.getParameter("que_content"));
			vo.setQue_secret(mRequest.getParameter("que_secret"));
			vo.setQue_file(fileName1);
			
			
			System.out.println("비밀글 : "+mRequest.getParameter("que_secret"));
			PostSrv PService= new PostSrv();
			int result = PService.writeQues(vo);
			if(result>=1) {
				System.out.println("aaa");
				response.sendRedirect("postListServlet");
			} else {
				System.out.println("bbb");
				request.getRequestDispatcher("./memberQuesWrite.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println("ccc");
			request.getRequestDispatcher("./memberQuesWrite.jsp").forward(request, response);
		} catch (NullPointerException e) {
			System.out.println("ddd");
			request.getRequestDispatcher("./memberQuesWrite.jsp").forward(request, response);
		}
		
	}

}
