package personal.controller.music;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Item2;
import personal.bean.Members;
import personal.repository.Comment2Repository;

/**
 * Servlet implementation class comment2DeleteController
 */
@WebServlet("/comment2/delete")
public class comment2DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comment2DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Members member = (Members) session.getAttribute("member");
		Item2 item = (Item2) session.getAttribute("item");
		int commentid = Integer.parseInt(request.getParameter("id"));
		
		Comment2Repository repo = new Comment2Repository();
		repo.setConnection(getServletContext().getAttribute("connection"));
		repo.removeComment(commentid, member.getUser());
		
		response.sendRedirect(request.getContextPath() 
				+ "/mitem?id=" + item.getId2());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
