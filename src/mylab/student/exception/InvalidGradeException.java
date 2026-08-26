package mylab.student.exception;

public class InvalidGradeException extends Exception{
	private int currenGrade;
	
	public InvalidGradeException(String errormessage,int currenGrade) {
		super(errormessage);
		this.currenGrade = currenGrade;
	}
	public int getCrrenGrade() {
		return currenGrade;
	}
}
