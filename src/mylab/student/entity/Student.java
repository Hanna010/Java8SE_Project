package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;
import workshop.account.exception.InsufficientBalanceException;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student() {
		System.out.println("Student 기본생성자가 호출됨!");
	}
	
	public Student(String studentId, String name, String major) {
		System.out.println("오버로딩 생성자 호출.");
		this.studentId=studentId;
		this.name=name;
		this.major=major;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) throws InvalidGradeException {
	    if (grade < 1 || grade > 4) {
	        throw new InvalidGradeException("학년은 1에서 4 사이여야 합니다.", grade);
	    }
	    this.grade = grade;
	}
	
	
	
	
	
}
