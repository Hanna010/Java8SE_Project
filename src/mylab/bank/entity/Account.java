package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {

    // 계좌번호
    private String accountNumber;

    // 계좌 소유자 이름
    private String ownerName;

    // 현재 잔액
    private double balance;


    // 생성자
    public Account(String accountNumber, String ownerName, double balance) {

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }


    // 계좌번호 반환
    public String getAccountNumber() {
        return accountNumber;
    }


    // 소유자 이름 반환
    public String getOwnerName() {
        return ownerName;
    }


    // 잔액 반환
    public double getBalance() {
        return balance;
    }


    // 입금
    public void deposit(double amount) {

        balance += amount;

        System.out.println(
            amount + "원이 입금되었습니다. 현재 잔액: "
            + balance + "원"
        );
    }


    // 출금
    public void withdraw(double amount)
            throws InsufficientBalanceException {

        if (balance < amount) {

            throw new InsufficientBalanceException(
                "잔액이 부족합니다. 현재 잔액: "
                + balance + "원"
            );
        }

        balance -= amount;

        System.out.println(
            amount + "원이 출금되었습니다. 현재 잔액: "
            + balance + "원"
        );
    }


    // 계좌 정보 문자열 반환
    @Override
    public String toString() {

        return "계좌번호: " + accountNumber
                + ", 소유자: " + ownerName
                + ", 잔액: " + balance + "원";
    }
}