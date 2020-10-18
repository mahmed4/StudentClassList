package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClassDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/semesterNavigationServlet")
public class SemesterNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SemesterNavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassDetailsHelper dao = new ClassDetailsHelper();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllStudentClassListServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("semesterId"));
				ClassDetails listToDelete = dao.searchForClassDetailsBySemesterId(tempId);
				dao.deleteList(listToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllStudentClassListServlet").forward(request, response);
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("semesterId"));
				ClassDetails listToEdit = dao.searchForClassDetailsBySemesterId(tempId);
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("month", listToEdit.getStartDate().getMonthValue());
				request.setAttribute("date", listToEdit.getStartDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getStartDate().getYear());
				ClassHelper daoForItems = new ClassHelper();
				request.setAttribute("allItems", daoForItems.showAllClass());
				if (daoForItems.showAllClass().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/edit-semester.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllStudentClassListServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-semester.jsp").forward(request, response);
		}
	}

}
