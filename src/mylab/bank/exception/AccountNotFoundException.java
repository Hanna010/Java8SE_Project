package mylab.bank.exception;

public class AccountNotFoundException extends Exception {
	//계좌를 찾을 수 없을때 발생하는 예외 클래스 
    public AccountNotFoundException(String message) {
        super(message);
    }
}