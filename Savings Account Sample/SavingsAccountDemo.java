import java.util.Scanner;

// class assignment
// Author: Meara Whitely
// Description: driver to test the SavingsAccount class

public class SavingsAccountDemo 
{
    // main function
    public static void main(String[] args) 
    {
        //variables
        double startingBalance;
        double annualInterestRate;
        double totalInterest = 0;
        double depositAmount;
        double withdrawAmount;
        int accountAge;
        Scanner userInput = new Scanner(System.in);
        SavingsAccount userSavings;

        //prompt user for accounts starting balance
        System.out.println("Enter the savings account's starting balance: ");
        //get and validate input
        startingBalance = userInput.nextDouble();
        userInput.nextLine(); //clearing keyboard buffer
        while (startingBalance <= 0)
        {
            System.out.println("You must enter a starting balance > 0.");
            System.out.println("Enter the savings account's starting balance: ");
            startingBalance = userInput.nextDouble();
            userInput.nextLine(); //clearing keyboard buffer
        }

        //prompt user for annual interest rate
        System.out.println("Enter the savings account's annual interest rate (ex: .05 = 5%): ");
        //get and validate input
        annualInterestRate = userInput.nextDouble();
        userInput.nextLine(); //clearing keyboard buffer
        while (annualInterestRate > 1 || annualInterestRate < 0)
        {
            System.out.println("You must enter an interest rate between 0 and 1"
                                + "For example 5% should be entered as .05.");
            System.out.println("Enter the savings account's annual interest rate (ex: .05 = 5%): ");
            annualInterestRate = userInput.nextDouble();
            userInput.nextLine(); //clearing keyboard buffer
        }

        //sustantiate savings account with user info
        userSavings = new SavingsAccount(startingBalance, annualInterestRate);

        //prompt user for account age
        System.out.println("How many months have passed since the account was opened? ");
        //get and validate input
        accountAge = userInput.nextInt();
        userInput.nextLine(); //clearing buffer
        while (accountAge <= 0)
        {
            System.out.println("Number of months should be > 0.");
            System.out.println("How many months have passed since the account was opened? ");
            accountAge = userInput.nextInt();
            userInput.nextLine();
        }

        //calculate account activity each month
        for (int months = 0; months < accountAge; months++)
        {
            //prompt user for amount deposited
            System.out.println("Enter the amount deposited during month " + (months + 1) + ": ");
            depositAmount = userInput.nextDouble();
            userInput.nextLine();
            while (depositAmount <= 0)
            {
                System.out.println("Deposit amount must be > 0.");
                System.out.println("Enter the amount deposited during month " + (months + 1) + ": ");
                depositAmount = userInput.nextDouble();
                userInput.nextLine();
            }

            //deposit amount
            userSavings.deposit(depositAmount);
            
            //prompt user for amount withdrawn
            System.out.println("Enter the amount withdrawn during month " + (months + 1) + ": ");
            withdrawAmount = userInput.nextDouble();
            userInput.nextLine();
            while (withdrawAmount <= 0)
            {
                System.out.println("Withdrawal amount must be > 0.");
                System.out.println("Enter the amount withdrawn during month " + (months + 1) + ": ");
                withdrawAmount = userInput.nextDouble();
                userInput.nextLine();
            }

            //withdraw amount
            userSavings.withdraw(withdrawAmount);

            //add to total interest earned
            totalInterest += userSavings.getBalance() * (userSavings.getInterestRate() / 12);
            userSavings.addInterest();
        }

        System.out.println("-------------------------------------------------");

        //display total interest earned
        System.out.printf("Interest earned: $%,.2f \n", totalInterest);

        //display ending balance
        System.out.printf("Ending balance: $%,.2f \n", userSavings.getBalance());
    }
}
