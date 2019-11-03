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
import personal.repository.Item2Repository;

/**
 * Servlet implementation class mItemUpdateController
 */
@WebServlet("/mitem/update")
@MultipartConfig
public class mItemUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mItemUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/mitemUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		Part filePart = request.getPart("file");
		String updateOrRemove = request.getParameter("file-update");
		
		
		
		Item2 originItem = (Item2) session.getAttribute("item");
		Item2Repository repo = new Item2Repository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		Item2 targetItem = new Item2();
		targetItem.setId2(originItem.getId2());
		targetItem.setTitle2(request.getParameter("title"));
		targetItem.setBody2(request.getParameter("body"));
		targetItem.setUserId2(originItem.getUserId2());
		
		
		
		
		if (updateOrRemove.equals("remove")) {
			targetItem.setFile2("");
			
			String path = application.getRealPath(
					"/image/" + "/m/" + originItem.getId2());
			File folder = new File(path);
			File[] files = folder.listFiles();
			if (files != null) {
				for (File file : files) {
					file.delete();
				}
			}
			folder.delete();
			
		} else {
			String fileName = filePart.getSubmittedFileName();
			if (fileName.length() > 0) {
				targetItem.setFile2(fileName);
				String filePathStr = application
						.getRealPath("/image/" + "/m/" + originItem.getId2());
				File filePath = new File(filePathStr);
				if (!filePath.exists()) {
					filePath.mkdirs();
				}
				filePart.write(filePathStr 
						+ File.separator + fileName);
				
				System.out.println(filePathStr);
			} else {
				targetItem.setFile2(originItem.getFile2());
			}
		}
		
		
		
		
		
		if(repo.updateItem(targetItem)){
			response.sendRedirect(request.getContextPath() + "/mpost");
			return;
		} else {
			request.setAttribute("item", targetItem);
			request.getRequestDispatcher("/WEB-INF/mitemUpdate.jsp")
			.forward(request, response);
		}
		
		
		
		
		
		
	}
	

}
