package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {

    // 은행이 관리하는 계좌 목록
    private List<Account> accounts;

    // 다음 계좌번호
    private int nextAccountNumber;


    // 생성자
    public Bank() {

        // 빈 계좌 목록 생성
        accounts = new ArrayList<>();

        // 계좌번호 시작
        nextAccountNumber = 1000;
    }


    // 저축 계좌 생성
    public String createSavingsAccount(
            String ownerName,
            double initialBalance,
            double interestRate) {

        // 계좌번호 생성
        String accountNumber =
                "AC" + nextAccountNumber;

        // 저축 계좌 생성
        SavingsAccount account =
                new SavingsAccount(
                        accountNumber,
                        ownerName,
                        initialBalance,
                        interestRate
                );

        // 계좌 목록에 추가
        accounts.add(account);

        // 다음 계좌번호 증가
        nextAccountNumber++;

        System.out.println(
            "저축 계좌가 생성되었습니다: "
            + account
        );

        return accountNumber;
    }


    // 체킹 계좌 생성
    public String createCheckingAccount(
            String ownerName,
            double initialBalance,
            double withdrawalLimit) {

        // 계좌번호 생성
        String accountNumber =
                "AC" + nextAccountNumber;

        // 체킹 계좌 생성
        CheckingAccount account =
                new CheckingAccount(
                        accountNumber,
                        ownerName,
                        initialBalance,
                        withdrawalLimit
                );

        // 목록에 추가
        accounts.add(account);

        // 다음 계좌번호 증가
        nextAccountNumber++;

        System.out.println(
            "체킹 계좌가 생성되었습니다: "
            + account
        );

        return accountNumber;
    }


    // 계좌 검색
    public Account findAccount(String accountNumber)
            throws AccountNotFoundException {

        // 모든 계좌를 하나씩 검색
        for (Account account : accounts) {

            if (account.getAccountNumber()
                    .equals(accountNumber)) {

                return account;
            }
        }

        // 찾지 못한 경우
        throw new AccountNotFoundException(
            "계좌번호 " + accountNumber
            + "에 해당하는 계좌를 찾을 수 없습니다."
        );
    }


    // 입금
    public void deposit(
            String accountNumber,
            double amount)
            throws AccountNotFoundException {

        // 계좌 찾기
        Account account =
                findAccount(accountNumber);

        // 입금
        account.deposit(amount);
    }


    // 출금
    public void withdraw(
            String accountNumber,
            double amount)
            throws AccountNotFoundException,
                   InsufficientBalanceException {

        // 계좌 찾기
        Account account =
                findAccount(accountNumber);

        // 출금
        account.withdraw(amount);
    }


    // 계좌 이체
    public void transfer(
            String fromAccountNumber,
            String toAccountNumber,
            double amount)
            throws AccountNotFoundException,
                   InsufficientBalanceException {

        // 보내는 계좌 찾기
        Account fromAccount =
                findAccount(fromAccountNumber);

        // 받는 계좌 찾기
        Account toAccount =
                findAccount(toAccountNumber);

        // 보내는 계좌에서 출금
        fromAccount.withdraw(amount);

        // 받는 계좌에 입금
        toAccount.deposit(amount);

        System.out.println(
            amount + "원이 "
            + fromAccountNumber
            + "에서 "
            + toAccountNumber
            + "로 송금되었습니다."
        );
    }


    // 모든 계좌 출력
    public void printAllAccounts() {

        System.out.println(
            "=== 모든 계좌 목록 ==="
        );

        for (Account account : accounts) {

            System.out.println(account);
        }

        System.out.println(
            "==================="
        );
    }
}