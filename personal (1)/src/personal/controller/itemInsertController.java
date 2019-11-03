package personal.controller;

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


import personal.bean.Item;
import personal.bean.Members;
import personal.repository.ItemRepository;

/**
 * Servlet implementation class itemInsertController
 */
@WebServlet("/item/write")
@MultipartConfig
public class itemInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public itemInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/write.jsp").forward(request, response);
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
		Item item = new Item();
		item.setTitle(title);
		item.setBody(body);
		item.setUserId(userId);
		item.setFile(fileName);
		
		ItemRepository repo = new ItemRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		if (repo.addItem(item)){
			if(fileName.length() > 0) {
				String filePathStr = application.getRealPath("/image/" + "/i/" + item.getId());
				
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
			request.getRequestDispatcher("/WEB-INF/post.jsp").forward(request, response);
		}
	}

}
