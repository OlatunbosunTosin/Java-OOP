package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

        private Account myAccount;
        private String correctPin = "1234";;

        @BeforeEach
        public void setUp(){
                myAccount = new Account("accountNumber", "firstName", "lastName", correctPin);
        }

        @Test
        public void validateCorrectPin_checkBalance_balanceIs0(){
                assertEquals(0, myAccount.getBalance(correctPin));
        }

        @Test
        public void enterIncorrectPin_throwError(){
                assertThrows(IllegalArgumentException.class, () -> myAccount.getBalance("1243"));
        }

        @Test
        public void depositIs200_balanceIs200(){
                assertEquals(0, myAccount.getBalance(correctPin));
                myAccount.deposit(200);
                assertEquals(200, myAccount.getBalance(correctPin));

        }

        @Test
        public void depositIsMinus50_balanceIs0(){
                myAccount.deposit(-50);
                assertEquals(0, myAccount.getBalance(correctPin));

        }

        @Test
        public void deposit200And500_balanceIs700(){
                myAccount.deposit(200);
                myAccount.deposit(500);
                assertEquals(700, myAccount.getBalance(correctPin));
        }

        @Test
        public void withdraw50WhenBalanceIsZero_balanceIsZero(){
                myAccount.withdraw(50,correctPin);
                assertEquals(0, myAccount.getBalance(correctPin));
        }

        @Test
        public void enterInvalidPin_withdraw200WhenBalanceIs500_throwError(){
                myAccount.deposit(500);
                assertThrows(IllegalArgumentException.class, () -> myAccount.withdraw(200,"0034"));
        }

        @Test
        public void withdraw200WhenBalanceIs500_balanceIs300(){
                myAccount.deposit(500);
                myAccount.withdraw(200,correctPin);
                assertEquals(300, myAccount.getBalance(correctPin));
        }

        @Test
        public void withdrawMinus100WhenBalanceIs500_balanceIs500(){
                myAccount.deposit(500);
                myAccount.withdraw(-100,correctPin);
                assertEquals(500, myAccount.getBalance(correctPin));
        }


}
