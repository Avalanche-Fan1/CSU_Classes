import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scnr = new Scanner(System.in);
        // initiate weekly income variable //
        double weeklyIncome;
        double weeklyTax;
        double weeklyNet;

        System.out.print("Enter weekly income: "); //Gather weekly income from user //
        weeklyIncome = scnr.nextDouble();

        // Use the enum
        TaxBracket bracket = TaxBracket.getBracket(weeklyIncome);

        weeklyTax = weeklyIncome * bracket.getRate();
        weeklyNet = weeklyIncome - weeklyTax;

        System.out.printf("Your weekly tax withholdings is $%.2f%n", weeklyTax);
        System.out.printf("Your Weekly Net Income is $%.2f%n", weeklyNet);
    }
}
// Enum is in the SAME FILE, but OUTSIDE the Main class
enum TaxBracket {
    LOW(0, 500, 0.10),
    MEDIUM(500, 1500, 0.15),
    HIGH(1500, 2500, 0.20),
    VERY_HIGH(2500, Double.MAX_VALUE, 0.30);

    private final double min;
    private final double max;
    private final double rate;

    TaxBracket(double min, double max, double rate) {
        this.min = min;
        this.max = max;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public static TaxBracket getBracket(double income) {
        for (TaxBracket bracket : values()) {
            if (income >= bracket.min && income < bracket.max) {
                return bracket;
            }
        }
        return VERY_HIGH;
    }
}