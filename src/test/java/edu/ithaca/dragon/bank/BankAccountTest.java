package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getBalanceTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    void withdrawTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);
        bankAccount.withdraw(100);

        assertEquals(100, bankAccount.getBalance());
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(1000)); // invalid case (partition of amount > balance; not border case)
        assertThrows(IllegalArgumentException.class, ()-> bankAccount.withdraw(-100)); // invalid case (partition of amount < 0; not border case)
    }

    @Test
    void isEmailValidTest(){
        assertTrue(BankAccount.isEmailValid( "a@b.com")); // valid case (partition of "no violations"; not border case)
        assertFalse(BankAccount.isEmailValid( "abc-@blah.com" )); // invalid case (partition of "cannot have - before @"; not border case)
        assertFalse(BankAccount.isEmailValid( "" )); // invalid case (partition of "cannot be blank"; not border case)
        assertFalse(BankAccount.isEmailValid( "abc..def@blah.com" )); // invalid case (partition of "cannot have more than 1 . consecutively"; not border case)
        assertFalse(BankAccount.isEmailValid( ".abc@blah.com" )); // invalid case (partition of "cannot begin with a ."; not border case)
        assertFalse(BankAccount.isEmailValid( "abc#def@blah.com" )); // invalid case (partition of "cannot have special characters"; not border case)
        assertFalse(BankAccount.isEmailValid( "abc@mail.c" )); // invalid case (partition of "after last . has to have at least 3 characters"; not border case)
        assertFalse(BankAccount.isEmailValid( "abc@mail#archive.com" )); // invalid case (partition of "cannot have special characters"; not border case)
        assertFalse(BankAccount.isEmailValid( "abc@mail" )); // invalid case (partition of "has to have at least 1 ."; not border case)
        assertFalse(BankAccount.isEmailValid( "abc@mail..com" )); // invalid case (partition of "cannot have more than 1 . consecutively"; not border case)
    }

    @Test
    void constructorTest() {
        BankAccount bankAccount = new BankAccount("a@b.com", 200);

        assertEquals("a@b.com", bankAccount.getEmail());
        assertEquals(200, bankAccount.getBalance());
        //check for exception thrown correctly
        assertThrows(IllegalArgumentException.class, ()-> new BankAccount("", 100));
    }

}