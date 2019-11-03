package personal.controller.music;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Item2;
import personal.bean.Members;
import personal.repository.Item2Repository;

/**
 * Servlet implementation class mItemDeleteController
 */
@WebServlet("/mitem/delete")
public class mItemDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mItemDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		Item2 item = (Item2) session.getAttribute("item");
		Members member = (Members) session.getAttribute("member");
		
		if(member != null && item.getUserId2().equals(member.getUser())){
			Item2Repository repo = new Item2Repository();
			repo.setConnection(getServletContext().getAttribute("connection"));
			repo.removeItem(item);
			
			String path = application.getRealPath(
					"/image/"+ "/m/" + item.getId2());
			File folder = new File(path);
			File[] files = folder.listFiles();
			if (files != null) {
				for (File file : files) {
					file.delete();
				}
			}
			folder.delete();
			
			
			
			response.sendRedirect(request.getContextPath()+"/");
		} else {
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
