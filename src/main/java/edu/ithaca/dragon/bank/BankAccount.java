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
     * @throws InsufficientFundsException if amount is bigger than balance
     * @throws InsufficientFundsException if amount is 0
     * @throws InsufficientFundsException if amount is less than .01
     */
    public void withdraw (double amount)  throws InsufficientFundsException {
        if (amount < .01){
            throw new IllegalArgumentException("Amount " + amount + " is less than the acceptable amount");
        }
        else if (amount <= 0){
            throw new IllegalArgumentException("Amount " + amount + " is negative, must withdraw a positive amount");
        }
        else if (amount > balance) {
            throw new InsufficientFundsException("Amount " + amount + " is invalid, cannot withdraw amount");
        }
        else {
            balance -= amount;
        }
    }


    public static boolean isEmailValid(String email){
        if (email.length() == 0){
            return false;
        }
        if (email.indexOf('@') <= 0 || email.indexOf('@') != email.lastIndexOf('@')){
            return false;
        }else if (email.indexOf("-@") != -1){
            return false;
        }else if (email.indexOf("..") != -1){
            return false;
        }else if (email.indexOf(".") <= 0 || email.length() - email.lastIndexOf(".") < 3){
            return false;
        }else if (email.indexOf("#") != -1){
            return false;
        }
        int item;
        for(int i = 0; i < email.length(); i++){
            item = (int) email.charAt(i);
            if (item <= 44){
                return false;
            }else if(item > 122){
                return false;
            }else if(!(item == 45 || item == 46 || item == 95 || item == 64 || (item >= 97 && item < 123) || (item >= 65 && item < 91))){
                return false;
            }
        }
        return true;
    }
}
