public class BankAccount {
    String firstName;
    String lastName;
    int accountID;
    double Balance;


    // Constructor //
    public BankAccount() {
        Balance = 0;
    }


    // Deposit Method //
    public void deposit(double Deposit) {
        Balance += Deposit;
        System.out.printf("You have made a deposit of: $%.2f%n", Deposit);
        System.out.printf("Your new balance is: $%.2f%n", Balance);
        System.out.println();
    }


    // withdrawal Method //
    public void withdrawal(double withdrawal) {
        Balance -= withdrawal;
    }


    //Setters for first name, last name, and Account ID //
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }


    public void setAccountID(int accountID){
        this.accountID = accountID;
    }


    //Getters for first name, last name, Account ID, and Balance //
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }


    public int getAccountID(){
        return accountID;
    }


    public double getBalance(){
        return Balance;
    }


    // Print Account Summary //
    public void accountSummary(){
        System.out.println("Account ID: " + getAccountID());
        System.out.println(getLastName() + ", " + getFirstName());
        System.out.printf("Account Balance: $%.2f%n", getBalance());
    }
}
