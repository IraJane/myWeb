package personal.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Item;
import personal.bean.Members;
import personal.repository.ItemRepository;

/**
 * Servlet implementation class itemDeleteController
 */
@WebServlet("/item/delete")
public class itemDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public itemDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		Item item = (Item) session.getAttribute("item");
		Members member = (Members) session.getAttribute("member");
		
		if(member != null && item.getUserId().equals(member.getUser())){
			ItemRepository repo = new ItemRepository();
			repo.setConnection(getServletContext().getAttribute("connection"));
			repo.removeItem(item);
			
			String path = application.getRealPath(
					"/image/"+ "/i/" + item.getId());
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
