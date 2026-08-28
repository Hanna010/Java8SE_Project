package workshop.account.entity;
import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custId; //private 사용했기에 다른 클래스에서 변수에 대해 직접 값을 읽거나 쓸 수 없다. 
	private String acctId; //AccountTest.java에서 account.custId="C002"가 불가능하다. 왜냐면 private 이니까. 
	private int balance;   //그래서 Getter와 Setter가 필요한 것이다. 
	
	//default construcotr 선언
	public Account() { //아래처럼 생성자를 직접 하나라도 만들면 자바가 자동으로 만들어주지 않음. 스스로 만들어야함.
		System.out.println("Account 기본생성자가 호출됨!");
	}
	
	//생성자 중복정의 (constructor overloading)
	public Account(String custId, String acctId, int balance) {
		System.out.print("오버로딩된 생성자 호출됨!");
		this.custId = custId; //고객번호
		this.acctId = acctId; //계좌번호
		this.balance = balance; //잔액
	}
	
	//getter method 
	public String getCustId() { //getCustId 치고 컨트롤 + 스페이스바
		return custId;
	}
	//setter
	public void setCustId(String custId) {
		this.custId = custId; //기존 번호를 바꾸겠다.
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public int getBalance() {
		return balance;
	}

	
	//입금
	public void deposit(int amount) {
		//this.balence = this.balance + amount;
		this.balance += amount;
	}
	
	//출금 
	//토요일에 하기.
		public void withdraw(int amount) 
				throws InsufficientBalanceException {
			if( amount > balance ) {
				//Exception을 강제로 발생시킴.
				throw new InsufficientBalanceException("잔액이 부족합니다. 현재 잔액은 = ", this.balance);
			}
			this.balance -= amount;
		}

	//선언부를 똑같이하고, 
	@Override
	public String toString() {
		return "Account [고객번호=" + custId + ", 계좌번호=" + acctId + ", 잔액=" + balance + "]";
	}
	
	
	
}
