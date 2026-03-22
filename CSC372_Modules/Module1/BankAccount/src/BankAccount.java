public class BankAccount {
    String firstName;
    String lastName;
    int accountID;
    double Balance;

    public BankAccount() {  // Default constructor
        Balance = 0;
    }

    public void deposit(double Deposit) {
        Balance += Deposit;
        System.out.printf("You have made a deposit of: $%.2f%n", Deposit);
        System.out.printf("Your new balance is: $%.2f%n", Balance);
        System.out.println();
    }

    public void withdrawl(double Withdrawl) {
        Balance -= Withdrawl;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAccountID(int accountID){
        this.accountID = accountID;
    }

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

    public void accountSummary(){
        System.out.println("Account ID: " + accountID);
        System.out.println(lastName + ", " + firstName);
        System.out.printf("Account Balance: $%.2f%n", Balance);
    }
}
