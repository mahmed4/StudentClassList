package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student.class_list")
public class ClassList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLASS_ID")
	private int classId;

	@Column(name = "CLASS_NAME")
	private String className;

	@Column(name = "INSTRUCTOR_ID")
	private String instructorId;

	
	public ClassList() {
		super();
	}

	public ClassList(String className, String instructorId) {
		this.className = className;
		this.instructorId = instructorId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}

	public String returnItemDetails() {
		return className + " " + instructorId;
	}

	@Override
	public String toString() {
		return "Class [classId=" + classId + ", className=" + className + ", instructorId=" + instructorId + "]";
	}
}
