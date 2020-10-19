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

import model.*;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewClassListServlet")
public class createNewClassListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewClassListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClassHelper lih = new ClassHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: "+ listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String instructorId = request.getParameter("instructorId");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedClasses = request.getParameterValues("allClassesToAdd");
		List<ClassList> selectedClassesInList = new ArrayList<ClassList>();
		
		for(int i = 0; i<selectedClasses.length; i++) {
			System.out.println(selectedClasses[i]);
			ClassList c = lih.searchForClassByClassId(Integer.parseInt(selectedClasses[i]));
			selectedClassesInList.add(c);
			
		}
		
		ClassList student = new ClassList(instructorId);
		ClassDetails sld = new ClassDetails(listName, ld, student);
		sld.setListOfClass(selectedClassesInList);
		ClassListDetailsHelper slh = new ClassListDetailsHelper();
		slh.insertNewClassListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllClassServlet").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}