package personal.controller.music;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import personal.bean.Comment2;
import personal.bean.Item2;
import personal.bean.Members;
import personal.repository.Comment2Repository;

/**
 * Servlet implementation class comment2InsertController
 */
@WebServlet("/comment2/insert")
public class comment2InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comment2InsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		Members member = (Members) session.getAttribute("member");
		Item2 item = (Item2) session.getAttribute("item");
		
		Comment2 comment = new Comment2();
		comment.setComment2(request.getParameter("comment2"));
		comment.setItemId2(item.getId2());
		comment.setUserId2(member.getUser());
		
		Comment2Repository repo = new Comment2Repository();
		repo.setConnection(application.getAttribute("connection"));
		if (repo.addComment(comment)) {
			session.removeAttribute("comment2");
		} else {
			session.setAttribute("comment2", comment);
		}
		response.sendRedirect(request.getContextPath() 
				+ "/mitem?id=" + item.getId2());
	}

}
