// Class Assignment
// Author: Meara Whitely
// Project: create a savings account class to store annual interest rate and balance

public class SavingsAccount 
{
    //constructor//
    public SavingsAccount(double bal, double intRate)
    {
        balance = bal;
        interestRate = intRate;
    }

    //variables//
    private double balance;
    private double interestRate;

    //methods//
    public void withdraw(double amount)
    {
        if (amount > 0)
            balance = balance - amount;
    }
    public void deposit(double amount)
    {
         if (amount > 0)
            balance = balance + amount;
    }
    public void addInterest()
    {
        balance += balance * (interestRate / 12);
    }
    public double getBalance()
    {

        return balance;
    }
    public double getInterestRate()
    {

        return interestRate;
    }
}
