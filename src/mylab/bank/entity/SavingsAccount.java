package mylab.bank.entity;

public class SavingsAccount extends Account {

    // 이자율
    private double interestRate;


    // 생성자
    public SavingsAccount(
            String accountNumber,
            String ownerName,
            double balance,
            double interestRate) {

        // 부모 Account 생성자 호출
        super(accountNumber, ownerName, balance);

        this.interestRate = interestRate;
    }


    // 이자율 반환
    public double getInterestRate() {
        return interestRate;
    }


    // 이자 적용
    public void applyInterest() {

        double interest =
                getBalance() * interestRate;

        deposit(interest);

        System.out.println(
            "이자 " + interest
            + "원이 적용되었습니다. 현재 잔액: "
            + getBalance() + "원"
        );
    }


    // 계좌 정보 출력
    @Override
    public String toString() {

        return super.toString()
                + ", 이자율: "
                + (interestRate * 100)
                + "%";
    }
}