package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClassDetails;

/**
 * Servlet implementation class viewAllListsServlet
 */
@WebServlet("/viewAllStudentClassListServlet")
public class ViewAllStudentClassListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllStudentClassListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassDetailsHelper slh = new ClassDetailsHelper();
		List<ClassDetails> abc = slh.getLists();
		request.setAttribute("allLists", abc);
		if(abc.isEmpty()){
		request.setAttribute("allLists", " ");
		}
		getServletContext().getRequestDispatcher("/class-list-by-student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
