package manager.allfile.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import manager.allfile.service.ManagerAllfileSrv;

/**
 * Servlet implementation class ManagerAllfileUploadCtrl
 */
@WebServlet("/UploadService")
public class ManagerAllfileUploadCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAllfileUploadCtrl() {
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
		execute(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("f_name");
		System.out.println(fileName);

		ServletContext context = getServletContext(); // 어플리케이션에 대한 정보를 ServletContext 객체가 갖게 됨. (서버의 절대경로를 구하는 데 필요)
		String saveDir = context.getRealPath("Upload"); // 절대경로를 가져옴
		
		System.out.println("절대경로 >> " + saveDir);

		int maxSize =  10 * 1024 * 1024; // 10MB
		String encoding = "UTF-8";

		// saveDir: 경로
		// maxSize: 크기제한 설정
		// encoding: 인코딩타입 설정
		// new DefaultFileRenamePolicy(): 동일한 이름일 경우 자동으로 (1),(2)..붙게 해줌

		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		if (isMulti) {
			MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
					new DefaultFileRenamePolicy());

			String f_no = multi.getParameter("f_no");
			String f_name = multi.getFilesystemName("f_name");

			try {
				ManagerAllfileSrv fileService = new ManagerAllfileSrv();
				int result = fileService.uploadFile(f_no, f_name);
				String moveUrl = "";
				if (result > 0) {
					System.out.println("저장완료");
					moveUrl = "selectService";
				} else {
					System.out.println("저장실패");
					moveUrl = "/allfile/allfileUpload.html";
				}
				response.sendRedirect(moveUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("일반 전송 form 입니다.");
		}

	}
}
