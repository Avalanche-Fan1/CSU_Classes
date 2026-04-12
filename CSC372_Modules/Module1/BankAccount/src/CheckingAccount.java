public class CheckingAccount extends BankAccount{
    private double interestRate;


    // Setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    // Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // withdrawal overrides SuperClass method //
    @Override
    public void withdrawal(double withdrawal) {
        Balance -= withdrawal;
        System.out.printf("You have made a withdrawal of: $%.2f%n", withdrawal);
        processWithdrawal();
    }

    // Checks for overdraft and charges a fee //
    public void processWithdrawal() {

        if (Balance < 0) {
            Balance -= 30.0;
            System.out.println("An overdraft fee of $30.00 has been assessed.");
        }

        System.out.printf("Current balance: $%.2f%n", Balance);
    }



    // Display all account info including interest rate
    public void displayAccount() {
        accountSummary();
        System.out.printf("Interest Rate: %.2f%%%n", getInterestRate());
    }
}

