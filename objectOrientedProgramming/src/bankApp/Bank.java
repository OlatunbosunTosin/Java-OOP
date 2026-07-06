package bankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private int count;
    private String firstName;
    private String lastName;
    private String name;
    private List<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }

    public Account registerCustomer(String firstName, String lastName, String pin){
        String accountNumber = generateAccountNumber();
        Account customerAccount = new Account(accountNumber, firstName, lastName, pin);
        accounts.add(customerAccount);
        return customerAccount;
    }

    private String generateAccountNumber(){
        return ++count + "";
    }

    public int getNumberOfAccounts(){
        return accounts.size();
    }

    public Account findAccount(String accountNumber){
        for(Account account : accounts){
            if(account.getAccountNumber().equals(accountNumber))
                return account;
        }throw new IllegalArgumentException("Account not found");
    }

    public void deposit(String accountNumber, int amount){
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public int checkBalance(String accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        return account.getBalance(pin);
    }

    public void withdraw(String accountNumber, int amount, String pin) {
        Account account = findAccount(accountNumber);
        account.withdraw(amount, pin);
    }

    public void transfer(String senderAccountNumber, String receiverAccountNumber, int amount, String pin) {
        Account senderAccount = findAccount(senderAccountNumber);
        senderAccount.withdraw(amount, pin);
        Account receiverAccount = findAccount(receiverAccountNumber);
        receiverAccount.deposit(amount);
    }

    public void removeAccount(String accountNumber, String pin) {
        Account account = findAccount(accountNumber);
        accounts.remove(account);
    }
}
