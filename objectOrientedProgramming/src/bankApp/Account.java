package bankApp;

public class Account {

    private int balance;

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
        if(validatePin(userPin) == true) {
            if (amountIsLessThanBalance && amountIsPositive) balance = balance - amount;
        }
        else throw new IllegalArgumentException("Invalid Pin");

    }

    private boolean validatePin(String userPin) {
        String pin = "1234";
        if(userPin.equals(pin))
            return true;
        return false;
    }
}
