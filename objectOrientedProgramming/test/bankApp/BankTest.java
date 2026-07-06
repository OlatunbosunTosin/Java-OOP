package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankTest {

    private Bank myBank;
    private String pin;

    @BeforeEach
    public void setUp(){
        myBank = new Bank();
        pin = "mypin";
    }

    @Test
    public void register1Customer_1AccountIsCreated(){
        myBank.registerCustomer("tos","ola", pin);
        assertEquals(1, myBank.getNumberOfAccounts());
    }

    @Test
    public void register2Customers_2AccountsAreCreated(){
        myBank.registerCustomer("tos","ola", pin);
        assertEquals(1, myBank.getNumberOfAccounts());
        myBank.registerCustomer("ayo","mide", pin);
        assertEquals(2, myBank.getNumberOfAccounts());
    }

    @Test
    public void registerTwoAccounts_findAccountOfOneAccountTest(){
        Account customerOne = myBank.registerCustomer("tos","ola", pin);
        Account customerTwo = myBank.registerCustomer("ayo","mide", pin);
        assertEquals(customerTwo,myBank.findAccount("2"));
    }

    @Test
    public void registerTwoAccounts_findAccountThatDoesNotExistTest(){
        Account customerOne = myBank.registerCustomer("tos","ola", pin);
        Account customerTwo = myBank.registerCustomer("ayo","mide", pin);
        assertThrows(IllegalArgumentException.class, () -> myBank.findAccount("3"));
    }

    @Test
    public void deposit5000ToAccount2Test(){
        Account customerOne = myBank.registerCustomer("tos","ola", pin);
        Account customerTwo = myBank.registerCustomer("ayo","mide", pin);
        myBank.deposit("2", 5000);
        assertEquals(5000,myBank.checkBalance("2", pin));
        assertEquals(0,myBank.checkBalance("1", pin));
    }

    @Test
    public void deposit5000_withdraw2000_balaceIs3000Test(){
        Account customerOne = myBank.registerCustomer("tos","ola", pin);
        Account customerTwo = myBank.registerCustomer("ayo","mide", pin);
        myBank.deposit("2", 5000);
        myBank.withdraw("2", 2000, pin);
        assertEquals(3000,myBank.checkBalance("2", pin));
    }

    @Test
    public void deposit5000_transfer2500ToAnotherAccount(){
        Account customerOne = myBank.registerCustomer("tos","ola", pin);
        Account customerTwo = myBank.registerCustomer("ayo","mide", pin);
        myBank.deposit("1", 5000);
        myBank.transfer("1", "2", 2500, pin);
        assertEquals(2500,myBank.checkBalance("2", pin));
    }

    @Test
    public void removeAccountTest(){
        Account customerOne = myBank.registerCustomer("tos","ola", pin);
        Account customerTwo = myBank.registerCustomer("ayo","mide", pin);
        myBank.removeAccount("2", pin);
        assertEquals(1,myBank.getNumberOfAccounts());
    }
}