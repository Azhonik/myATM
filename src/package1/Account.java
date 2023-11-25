package package1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    //Set the customer number
    private int customerNumber;
    public void setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;

    }

    //Get customer number
    public int getCustomerNumber(){
        return customerNumber;
    }

    private int pinNumber;


    //Get the pin number
    public int getPinNumber() {
        return pinNumber;
    }

    // Set the pin number
    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    private double checkingBalance;

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(int checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(int savingBalance) {
        this.savingBalance = savingBalance;
    }

    private double savingBalance;


    public double calcCheckingWithdraw(double amount){
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }


    public double calcSavingWithdraw(double amount){
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    public double calcCheckingTopUp(double amount){
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    public double calcSavingTopUp(double amount){
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    public void getCheckingWithdrawMoney(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Account: ");
        double amount = input.nextDouble();

        if((checkingBalance - amount) >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account balance: "+ checkingBalance + "\n");
        }else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getSavingWithdrawMoney(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving Account: ");
        double amount = input.nextDouble();

        if((savingBalance - amount) >= 0){
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account balance: "+ savingBalance + "\n");
        }else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getCheckingTopUp(){
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount you want to put to the Checking Account: ");
        double amount = input.nextDouble();
        if(amount > 0){
            calcCheckingTopUp(amount);
            System.out.println("New Checking Account balance: "+ checkingBalance + "\n");
        }else{
            System.out.println("Amount cannot be below than zero");
        }
    }

    public void getSavingTopUp(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to put to the Saving Account: ");
        double amount = input.nextDouble();
        if(amount > 0){
            calcSavingTopUp(amount);
            System.out.println("New Saving Account balance: "+ savingBalance + "\n");
        }else{
            System.out.println("Amount cannot be below than zero");
        }
    }


}
