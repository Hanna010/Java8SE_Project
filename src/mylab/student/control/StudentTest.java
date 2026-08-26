package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {
	public static void main(String[] args) {
		try {
			Student student = new Student();
			
			student.setGrade(3);
			student.setName("김민수");
			student.setMajor("컴퓨터공학");
			student.setStudentId("2211111");
			
			System.out.println("이름=" + student.getName() + ",전공="+student.getMajor()+",학번="+student.getStudentId()+",학년="+student.getGrade());
			
			System.out.println("학년 수정 후===============");
			System.out.println("이름=" + student.getName() + ",전공="+student.getMajor()+",학번="+student.getStudentId()+",학년="+student.getGrade());
			student.setGrade(5);
			
		}catch(InvalidGradeException exp) {
			System.out.println("Error 메시지 =" + exp.getMessage());
		}
	}

}
