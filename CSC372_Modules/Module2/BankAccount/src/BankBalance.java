import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class BankBalance {

    static double accountBalance = 0.0;
    static NumberFormat currency = NumberFormat.getCurrencyInstance();

    public static void updateBalanceLabel(JLabel label) {
        label.setText("Current Balance: " + currency.format(accountBalance));
    }

    public static void main (String[] args) {

        JFrame balanceFrame = new JFrame("Bank Balance App",null);
        balanceFrame.setLocationRelativeTo(null);
        balanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Input Panel (Top)//
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.LIGHT_GRAY);
        inputPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Button Panel (Second Row)//
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Container Panel for balancePanel and exitPanel) //
        JPanel containerPanel = new JPanel();
        containerPanel.setBackground(Color.LIGHT_GRAY);

        // Balance Panel (Third Row) //
        JPanel balancePanel = new JPanel();
        balancePanel.setBackground(Color.LIGHT_GRAY);
        balancePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Exit Panel (Fourth Row) //
        JPanel exitPanel = new JPanel();
        exitPanel.setBackground(Color.LIGHT_GRAY);
        exitPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Place Panels in Frame //
        balanceFrame.add(inputPanel,BorderLayout.NORTH);
        balanceFrame.add(buttonPanel,BorderLayout.CENTER);
        balanceFrame.add(containerPanel, BorderLayout.SOUTH);

        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(balancePanel, BorderLayout.NORTH);
        containerPanel.add(exitPanel,BorderLayout.SOUTH);

        // Create JLable to display Balance //
        JLabel balanceLabel = new JLabel("Current Balance: " + currency.format(accountBalance));

        // Create JTextField to input values //
        JTextField myTextField = new JTextField(10);
        myTextField.setEditable(true);

        // Place JLabel and JTextField into Proper Panels //
        balancePanel.add(balanceLabel);
        inputPanel.add(myTextField);

        // Create all JButtons //
        JButton initialBalanceButton = new JButton("Set Starting Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawalButton = new JButton("Withdrawal");
        JButton exitButton = new JButton("Exit");

        // Place all buttons into proper JPanels //
        buttonPanel.add(initialBalanceButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawalButton);
        exitPanel.add(exitButton);

        // Set size of JFrame for exact size of contents //
        balanceFrame.pack();

        // ActionListener Set Balance //
        initialBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                try {

                    double value = Double.parseDouble(myTextField.getText());
                    if (value <= 0) {
                        balanceLabel.setText("Enter a positive number.");
                        myTextField.setText("");
                    }
                    else {
                        accountBalance = value;
                        updateBalanceLabel(balanceLabel);
                        myTextField.setText("");   // clear the field
                        initialBalanceButton.setEnabled(false);
                    }
                }
                catch (NumberFormatException ex) {
                    balanceLabel.setText("Please enter a valid number.");
                    myTextField.setText("");
                }
            }
        });

        // ActionListener Deposit //
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                try {

                    double value = Double.parseDouble(myTextField.getText());
                    if (value <= 0) {
                        balanceLabel.setText("Enter a positive number.");
                        myTextField.setText("");
                    }
                    else {
                        accountBalance += value;
                        updateBalanceLabel(balanceLabel);
                        myTextField.setText("");// clears the field
                        initialBalanceButton.setEnabled(false);
                    }
                }
                catch (NumberFormatException ex) {
                    balanceLabel.setText("Please enter a valid number.");
                    myTextField.setText("");
                }
            }
        });

        // ActionListener Withdrawal //
        withdrawalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                try {
                    double value = Double.parseDouble(myTextField.getText());
                    if (value <= 0) {
                        balanceLabel.setText("Enter a positive number.");
                        myTextField.setText("");
                    }
                    else if (value > accountBalance) {
                        balanceLabel.setText("Insufficient funds.");
                        myTextField.setText("");
                    }
                    else {
                        accountBalance -= value;
                        updateBalanceLabel(balanceLabel);
                        myTextField.setText("");   // clears the field
                        initialBalanceButton.setEnabled(false);
                    }
                }
                catch (NumberFormatException ex) {
                    balanceLabel.setText("Please enter a valid number.");
                    myTextField.setText("");
                }
            }
        });

        // ActionListener Exit //
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(
                        balanceFrame,
                        "Final Balance: " + currency.format(accountBalance),
                        "Account Summary",
                        JOptionPane.PLAIN_MESSAGE
                );
                System.exit(0);
            }
        });

        // Allow Frame and contents to be visible (Must happen after creation of all) //
        balanceFrame.setVisible(true);
    }
}
