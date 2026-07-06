package bankApp;

public class Account {

    private String name;
    private int balance;
    private String pin;
    private String accountNumber;


    public Account(String accountNumber, String firstName, String lastName, String pin){
        this.pin = pin;
        this.name = firstName +" "+ lastName;
        this.accountNumber = accountNumber;
    }

    public int getBalance(String userPin)
    {
        if(validatePin(userPin)) return balance;
        else throw new IllegalArgumentException("Invalid Pin");

    }

    public void deposit(int amount){
        boolean amountIsPositive = amount > 0;
        if(amountIsPositive)balance = balance + amount;
    }

    public void withdraw(int amount, String userPin){
        boolean amountIsLessThanBalance = amount < balance;
        boolean amountIsPositive = amount > 0;
        if(validatePin(userPin)) {
            if (amountIsLessThanBalance && amountIsPositive) balance = balance - amount;
        }
        else throw new IllegalArgumentException("Invalid Pin");
    }

    private boolean validatePin(String userPin) {
        return this.pin.equals(userPin);

    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
