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
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewSemesterServlet")
public class CreateNewSemesterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewSemesterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassHelper lih = new ClassHelper();
		String semesterName = request.getParameter("semesterName");
		System.out.println("Semester Name: "+ semesterName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String firstName =
		request.getParameter("firstName");
		String lastName =
				request.getParameter("lastName");
		LocalDate startDate;
		try {
			startDate = LocalDate.of(Integer.parseInt(year),
		Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			startDate = LocalDate.now();
		}
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<ClassList> selectedItemsInList = new ArrayList<ClassList>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0)
		{
		for(int i = 0; i<selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		ClassList c = lih.searchForClassByClassId(Integer.parseInt(selectedItems[i]));
		selectedItemsInList.add(c);
		}
		}
		StudentList student = new StudentList(firstName, lastName);
		ClassDetails sld = new ClassDetails(semesterName, startDate, student);
		sld.setListOfClass(selectedItemsInList);
		ClassDetailsHelper slh = new ClassDetailsHelper();
		slh.insertNewClassDetails(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllStudentClassListServlet").forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
