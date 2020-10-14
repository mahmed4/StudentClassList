package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="class_details")
public class ClassDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SEMESTER_ID")
	private int id;
	@Column(name="SEMESTER_NAME")
	private String semesterName;
	@Column(name="START_DATE")
	private LocalDate startDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="STUDENT_ID")
	private ClassList classList;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="CLASS_LIST",
	      joinColumns={ @JoinColumn(name="CLASS_ID", referencedColumnName="CLASS_ID") },
	      inverseJoinColumns={ @JoinColumn(name="INSTRUCTOR_ID", referencedColumnName="INSTRUCTOR_ID", unique=true) }
	  )
    private List<ClassList> listOfClasses;

	
	public ClassDetails() {
		super();
	}
	
	public ClassDetails(int id, String semesterName, LocalDate startDate, ClassList classList, List<ClassList> listOfClasses) {
		super();
		this.id = id;
		this.semesterName = semesterName;
		this.startDate = startDate;
		this.classList = classList;
		this.listOfClasses = listOfClasses;
	}

	public ClassDetails(String listName, LocalDate tripDate, ClassList classList, List<ClassList> listOfClasses) {
		super();
		this.semesterName = listName;
		this.startDate = tripDate;
		this.classList = classList;
		this.listOfClasses = listOfClasses;
	}

	public ClassDetails(String listName, LocalDate tripDate, ClassList classList) {
		super();
		this.semesterName = listName;
		this.startDate = tripDate;
		this.classList = classList;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return semesterName;
	}
	public void setListName(String listName) {
		this.semesterName = listName;
	}
	public LocalDate getTripDate() {
		return startDate;
	}
	public void setTripDate(LocalDate tripDate) {
		this.startDate = tripDate;
	}
	public ClassList getClassList() {
		return classList;
	}
	public void setShopper(ClassList classList) {
		this.classList = classList;
	}

	public List<ClassList> getListOfClasses() {
		return listOfClasses;
	}

	public void setListOfItems(List<ClassList> listOfClasses) {
		this.listOfClasses = listOfClasses;
	}

	@Override
	public String toString() {
		return "ClassListDetails [id=" + id + ", SemesterName=" + semesterName + ", startDate=" + startDate + ", classlist="
				+ classList + ", listOfClasses=" + listOfClasses + "]";
	}
	
}