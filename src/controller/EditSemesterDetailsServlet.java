package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClassDetails;
import model.ClassList;
import model.StudentList;

/**
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editSemesterDetailsServlet")
public class EditSemesterDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSemesterDetailsServlet() {
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
		ClassDetailsHelper dao = new ClassDetailsHelper();
		ClassHelper lih = new ClassHelper();
		StudentHelper sh = new StudentHelper();
		Integer tempId = Integer.parseInt(request.getParameter("semesterId"));
		ClassDetails listToUpdate = dao.searchForClassDetailsBySemesterId(tempId);
		String newSemesterName = request.getParameter("semesterName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		//find our add the new owner
		StudentList newStudent = sh.findStudent(firstName, lastName);
		LocalDate startDate;
		try {
			startDate = LocalDate.of(Integer.parseInt(year),
		Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			startDate = LocalDate.now();
		}
		try {
		//items are selected in list to add
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<ClassList> selectedItemsInList = new
		ArrayList<ClassList>();
		for (int i = 0; i < selectedItems.length; i++) {
		System.out .println(selectedItems[i]);
		ClassList c = lih.searchForClassByClassId(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(c);
		}
		listToUpdate.setListOfClass(selectedItemsInList);
		} catch (NullPointerException ex) {
		// no items selected in list - set to an empty list
		List<ClassList> selectedItemsInList = new
		ArrayList<ClassList>();
		listToUpdate.setListOfClass(selectedItemsInList);
		}
		listToUpdate.setSemesterName(newSemesterName);
		listToUpdate.setStartDate(startDate);
		listToUpdate.setStudent(newStudent);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/viewAllStudentClassListServlet").forward(request, response);
		}
	

}
