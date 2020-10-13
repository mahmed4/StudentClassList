package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ClassList;

public class ClassHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("StudentClassList");

	public void insertClass(ClassList li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<ClassList> showAllClass() {
		EntityManager em = emfactory.createEntityManager();
		List<ClassList> allClass = em.createQuery("SELECT i	FROM ClassList i").getResultList();
		return allClass;
	}

	public void deleteClass(ClassList toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ClassList> typedQuery = em.createQuery(
				"select li from ClassList li where li.className = :selectedClassName and li.instructorId = :selectedInstructorId", ClassList.class);

		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedClassName", toDelete.getClassName());
		typedQuery.setParameter("selectedInstructorId", toDelete.getInstructorId());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		ClassList result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ClassList searchForClassByClassId(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ClassList found = em.find(ClassList.class, idToEdit);
		em.close();
		return found;
	}

	public void updateClassList(ClassList toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ClassList> searchForClassByClassName(String className) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ClassList> typedQuery = em.createQuery("select li from ClassList li where li.className = :selectedClassName",
				ClassList.class);
		typedQuery.setParameter("selectedClassName", className);

		List<ClassList> foundClassName = typedQuery.getResultList();
		em.close();
		return foundClassName;
	}

	public List<ClassList> searchForClassByInstructorId(String instructorId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ClassList> typedQuery = em.createQuery("select li from ClassList li where li.instructorId = :selectedInstructorId",
				ClassList.class);
		typedQuery.setParameter("selectedInstructorId", instructorId);

		List<ClassList> foundInstructorId = typedQuery.getResultList();
		em.close();
		return foundInstructorId;
	}


	public void cleanUp() {
		emfactory.close();
	}
}
