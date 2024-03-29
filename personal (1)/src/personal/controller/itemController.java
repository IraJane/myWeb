package personal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Comment;
import personal.bean.Item;
import personal.repository.CommentRepository;
import personal.repository.ItemRepository;

/**
 * Servlet implementation class itemController
 */
@WebServlet("/item")
public class itemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public itemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object con = getServletContext().getAttribute("connection");
		int id = Integer.valueOf(request.getParameter("id"));
		
		ItemRepository repo = new ItemRepository();
		repo.setConnection(con);
		Item item = repo.getItem(id);
		
		if(item!=null){
			
			
			CommentRepository crepo = new CommentRepository();
			crepo.setConnection(con);
			List<Comment> comments = crepo.list(item.getId());
			
			request.setAttribute("comments", comments);
			
			
			
			
			
			session.setAttribute("item", item);
			request.getRequestDispatcher("/WEB-INF/item.jsp").forward(request, response);
		} else {
			System.out.println("문제발생");
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
