package edu.ithaca.dragon.bank;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance){
        if (isEmailValid(email)){
            this.email = email;
            this.balance = startingBalance;
        }
        else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getEmail(){
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     * @throws IllegalArgumentException if amount is non-negative
     * @throws IllegalArgumentException if amount is bigger than balance
     */
    public void withdraw (double amount)  {
        if (amount > balance || amount < 0){
            throw new IllegalArgumentException("Amount " + amount + " is invalid, cannot withdraw amount");
        }
        balance -= amount;
    }


    public static boolean isEmailValid(String email){
        if (email.indexOf('@') == -1){
            return false;
        }else if (email.indexOf("-@") != -1){
            return false;
        }else if (email.length() == 0){
            return false;
        }else if (email.indexOf("..") != -1){
            return false;
        }else if (email.indexOf(".") <= 0 || email.length() - email.indexOf(".") <= 3){
            return false;
        }else if (email.indexOf("#") != -1){
            return false;
        }
        else {
            return true;
        }
    }
}
