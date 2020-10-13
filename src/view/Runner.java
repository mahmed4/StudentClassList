package view;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import controller.ClassHelper;
import model.ClassList;

public class Runner {
	// Md Ahmed
	static Scanner in = new Scanner(System.in);
	static ClassHelper Car = new ClassHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a className: ");
		String className = in.nextLine();
		System.out.print("Enter a instructorId: ");
		String instructorId = in.nextLine();
		

		ClassList toAdd = new ClassList(className, instructorId);
		Car.insertClass(toAdd);
	}

	private static void deleteAnItem() {

		System.out.print("Enter the className to delete: ");
		String className = in.nextLine();
		System.out.print("Enter the instructorId to delete: ");
		String instructorId = in.nextLine();
		ClassList toDelete = new ClassList(className, instructorId);
		Car.deleteClass(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by className");
		System.out.println("2 : Search by instructorId");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ClassList> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the className: ");
			String make = in.nextLine();
			foundItems = Car.searchForClassByClassName(make);
		} else {
			System.out.print("Enter the instructorId: ");
			String model = in.nextLine();
			foundItems = Car.searchForClassByInstructorId(model);
		} 
		
		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (ClassList l : foundItems) {
				System.out.println(l.getClassId() + " : " + l.returnItemDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ClassList toEdit = Car.searchForClassByClassId(idToEdit);
			System.out.println("Retrieved result className: " + toEdit.getClassName() + " InstructorId: " + toEdit.getInstructorId());
			System.out.println("1 : Update className");
			System.out.println("2 : Update instructorId");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Class: ");
				String newClass = in.nextLine();
				toEdit.setClassName(newClass);;
			} else if (update == 2) {
				System.out.print("New instructorId: ");
				String newInstructorId = in.nextLine();
				toEdit.setInstructorId(newInstructorId);;
			} 

			Car.updateClassList(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our awesome Class Registration list! ---");
		while (goAgain) {
			System.out.println("*  Select an Option:");
			System.out.println("*  1 -- Add a Class");
			System.out.println("*  2 -- Edit a Class");
			System.out.println("*  3 -- Delete a Class");
			System.out.println("*  4 -- View all the Classes");
			System.out.println("*  5 -- Exit the awesome Car program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				Car.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void viewTheList() {
		List<ClassList> allClass = Car.showAllClass();
		for (ClassList singleClass : allClass) {
			System.out.println(singleClass.returnItemDetails());
		}
	}
}
