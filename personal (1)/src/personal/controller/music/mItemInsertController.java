package personal.controller.music;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import personal.bean.Item2;
import personal.bean.Members;
import personal.repository.Item2Repository;

/**
 * Servlet implementation class mItemInsertController
 */
@WebServlet("/mitem/write")
@MultipartConfig
public class mItemInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mItemInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/mwrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session = request.getSession();
		
		ServletContext application = getServletContext();
		
		Members member = (Members) session.getAttribute("member");
		
	
		request.setCharacterEncoding("utf-8");
	
		Part filePart = request.getPart("file");
		
		String fileName = filePart.getSubmittedFileName();
		
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		
		String userId = member.getUser();	
		Item2 item = new Item2();
		item.setTitle2(title);
		item.setBody2(body);
		item.setUserId2(userId);
		item.setFile2(fileName);
		
		Item2Repository repo = new Item2Repository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		if (repo.addItem(item)){
			if(fileName.length() > 0) {
				String filePathStr = application.getRealPath("/image/" + "/m/" + item.getId2());
				
				File filePath = new File(filePathStr);
				if(!filePath.exists()) {
					filePath.mkdirs();
				}
				filePart.write(filePathStr + File.separator + fileName);
				
				System.out.println(filePathStr);
			}
			
			response.sendRedirect(request.getContextPath() + "/");
			return;
		} else {
			System.out.println("error");
			request.setAttribute("item", item);
			request.getRequestDispatcher("/WEB-INF/mpost.jsp").forward(request, response);
		}
	}

}
