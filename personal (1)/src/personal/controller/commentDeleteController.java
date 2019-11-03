package personal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Item;
import personal.bean.Members;
import personal.repository.CommentRepository;

/**
 * Servlet implementation class commentDeleteController
 */
@WebServlet("/comment/delete")
public class commentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Members member = (Members) session.getAttribute("member");
		Item item = (Item) session.getAttribute("item");
		int commentid = Integer.parseInt(request.getParameter("id"));
		
		CommentRepository repo = new CommentRepository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		repo.removeComment(commentid, member.getUser());
		
		response.sendRedirect(request.getContextPath() 
				+ "/item?id=" + item.getId());
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
