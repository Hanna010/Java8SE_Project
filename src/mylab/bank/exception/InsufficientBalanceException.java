package mylab.bank.exception;

public class InsufficientBalanceException extends Exception {
	//잔액이 부족할 때 발생하는 예외클래스
    public InsufficientBalanceException(String message) {
        super(message);
    }
}