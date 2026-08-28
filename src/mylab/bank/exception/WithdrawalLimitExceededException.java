package mylab.bank.exception;

// WithdrawalLimitExceededException.java
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
	//출금 한도를 초과할 때 발생하는 예외 클래스
    public WithdrawalLimitExceededException(String message) {
        super(message);
    }
}