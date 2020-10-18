package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

@Entity
@Table(name = "class_details")
public class ClassDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEMESTER_ID")
	private int semesterId;
	@Column(name = "SEMESTER_NAME")
	private String semesterName;
	@Column(name = "START_DATE")
	private LocalDate startDate;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "STUDENT_ID")
	private StudentList student;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "student_on_list", joinColumns = {
			@JoinColumn(name = "SEMESTER_ID", referencedColumnName = "SEMESTER_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ID", referencedColumnName = "CLASS_ID", unique = true) })
	private List<ClassList> listOfClass;

	public ClassDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassDetails(int semesterId, String semesterName, LocalDate startDate, StudentList student, List<ClassList> listOfClass) {
		this.semesterId = semesterId;
		this.semesterName = semesterName;
		this.startDate = startDate;
		this.student = student;
		this.listOfClass = listOfClass;
	}

	public ClassDetails(String semesterName, LocalDate startDate, StudentList student, List<ClassList> listOfClass) {
		this.semesterName = semesterName;
		this.startDate = startDate;
		this.student = student;
		this.listOfClass = listOfClass;
	}
	
	public ClassDetails(String semesterName, LocalDate startDate, StudentList student) {
		this.semesterName = semesterName;
		this.startDate = startDate;
		this.student = student;
	}

	public int getSemesterId() {
		return semesterId;
	}

	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}

	public String getSemesterName() {
		return semesterName;
	}

	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public StudentList getStudent() {
		return student;
	}

	public void setStudent(StudentList student) {
		this.student = student;
	}

	public List<ClassList> getListOfClass() {
		return listOfClass;
	}

	public void setListOfClass(List<ClassList> listOfClass) {
		this.listOfClass = listOfClass;
	}

	@Override
	public String toString() {
		return "ClassDetails [semesterId=" + semesterId + ", semesterName=" + semesterName + ", startDate=" + startDate
				+ ", student=" + student + ", listOfClass=" + listOfClass + "]";
	}

}
