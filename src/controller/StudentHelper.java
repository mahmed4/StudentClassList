package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.StudentList;

public class StudentHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("StudentClassList");

	public void insertStudent(StudentList s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<StudentList> showAllStudents() {
		EntityManager em = emfactory.createEntityManager();
		List<StudentList> allStudents = em.createQuery("SELECT s FROM StudentList s").getResultList();
		return allStudents;
	}

	public StudentList findStudent(String firstNameToLookUp, String lastNameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<StudentList> typedQuery = em
				.createQuery("select sh from StudentList sh where sh.firstName = :selectedFirstName and sh.lastName = :selectedLastName", StudentList.class);
		typedQuery.setParameter("selectedFirstName", firstNameToLookUp);
		typedQuery.setParameter("selectedLastName", lastNameToLookUp);
		StudentList foundStudent;
		try {
			foundStudent = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundStudent = new StudentList(firstNameToLookUp, lastNameToLookUp);
		}
		em.close();
		return foundStudent;
	}

}
