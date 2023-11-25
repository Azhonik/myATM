package package1;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account{
    Scanner menuInput = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /*Validate Login information customer number and pin number*/
    public void getLogin() throws IOException {
        int x  = 1;
        do{
            try{
                data.put(18738, 1234);
                data.put(24224, 1235);
                data.put(32454, 1236);
                data.put(23156, 1237);

                System.out.println("Welcome to the ATM project!");

                System.out.println("Enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your pin number: ");
                setPinNumber(menuInput.nextInt());

            }catch (Exception e){
                System.out.println("\n" + "Invalid character(s). Numbers only." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()){
                if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong customer number or pin number" + "\n");
        }while (x == 1);

    }


    //Display Account type menu with selections

    public  void getAccountType(){
        System.out.println("Select the option you want to access: ");
        System.out.println("Option 1 - Checking Account");
        System.out.println("Option 2 - Saving Account");
        System.out.println("Option 3 - Exit");

        System.out.println("Choice: ");
        selection  = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getAccountType();
        }
    }

    //Display Checking Account menu with selections

    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw money");
        System.out.println("Type 3 - Top up balance");
        System.out.println("Type 4 -  Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Account balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawMoney();
                getAccountType();
                break;

            case 3:
                getCheckingTopUp();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getChecking();
        }
    }

    //Display saving account menu with selections
    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View balance");
        System.out.println("Type 2 - Withdraw money");
        System.out.println("Type 3 - Top up balance");
        System.out.println("Type 4 -  Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawMoney();
                getAccountType();
                break;

            case 3:
                getSavingTopUp();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM, bye.");

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getChecking();
        }
    }


    int selection;

}
