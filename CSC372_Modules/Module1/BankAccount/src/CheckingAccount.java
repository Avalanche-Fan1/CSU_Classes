public class CheckingAccount extends BankAccount{
    private double interestRate;

    // Constructor
    public CheckingAccount() {
        super();
    }

    // Setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    public void processWithdrawl(double newWithdrawl) {
        Balance -= newWithdrawl;
        System.out.printf("You have made a withdrawl of: $%.2f%n", newWithdrawl);
        if (Balance < 0) {
            Balance -= 30.0;
            System.out.println("An Overdraft Fee of $30.00 has been assessed");
        }
        System.out.printf("Current balance: $%.2f%n", Balance);
    }

    // Display all account info including interest rate
    public void displayAccount() {
        accountSummary();
        System.out.printf("Interest Rate: %.2f%%%n", interestRate);
    }
}
