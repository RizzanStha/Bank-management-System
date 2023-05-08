package coursework.views;

import coursework.BankCard;
import coursework.CreditCard;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomComboBox;
import coursework.components.MyCustomLabel;
import coursework.components.MyCustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Font;

public class AddCreditCard extends JFrame {
    MyCustomTextField   cardIDTF, clientNameTf, issueBankTF, bankAccountTF,balanceAmountTF, CVCNumberTF, interestRateTF;
    MyCustomComboBox yearComboBox, monthComboBox, dayComboBox;
    MyCustomLabel  addCreditCardLabel, cardIDLabel, clientNameLabel, issueBankLabel, bankAccountLabel, balanceAmountLabel, CVCNumberLabel, interestRateLabel, expirationDateLabel;
    MyCustomButton addButton, clearButton, displayButton, backButton;
    public AddCreditCard(ArrayList<BankCard> bankCards){
        super("Add Credit Card");
        setSize(500, 800);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        addCreditCardLabel = new MyCustomLabel("Add Credit Card");
        cardIDLabel = new MyCustomLabel("Card Id");
        clientNameLabel = new MyCustomLabel("Client Name");
        issueBankLabel = new MyCustomLabel("Issue Bank");
        bankAccountLabel = new MyCustomLabel("Bank Account");
        balanceAmountLabel = new MyCustomLabel("Balance Amount");
        CVCNumberLabel = new MyCustomLabel("CVC Number");
        interestRateLabel = new MyCustomLabel("Interest Rate");
        expirationDateLabel= new MyCustomLabel("Expiration Date");


        cardIDTF = new MyCustomTextField("");
        clientNameTf = new MyCustomTextField("");
        issueBankTF = new MyCustomTextField("");
        bankAccountTF = new MyCustomTextField("");
        balanceAmountTF = new MyCustomTextField("");
        CVCNumberTF = new MyCustomTextField("");
        interestRateTF = new MyCustomTextField("");


        //years
        yearComboBox = new MyCustomComboBox(new String[]{
                "select year", "2016", "2017", "2018", "2019",
                "2020", "2021", "2022", "2023", "2024", "2025"});
        //months
        monthComboBox = new MyCustomComboBox(new String[]{
                "select month",
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12"});
        //days
        dayComboBox = new MyCustomComboBox(new String[]{"select day",
                "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30","31"});


        addButton = new MyCustomButton("Add");
        clearButton = new MyCustomButton("Clear");
        displayButton = new MyCustomButton("Display");
        backButton = new MyCustomButton("Back");




        addButton.addActionListener(e -> {
            String cardId = cardIDTF.getText();
            String clientName = clientNameTf.getText();
            String issueBank = issueBankTF.getText();
            String bankAccount = bankAccountTF.getText();
            String balanceAmount = balanceAmountTF.getText();
            String cvcNumber = CVCNumberTF.getText();
            String interestRate = interestRateTF.getText();

            if (balanceAmount.equals("") || cardId.equals("") || bankAccount.equals("") || issueBank.equals("") || clientName.equals("")
                    || CVCNumberTF.equals("")|| interestRateTF.equals("") ||dayComboBox.getSelectedIndex() == 0 || monthComboBox.getSelectedIndex() == 0 || yearComboBox.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else {
                int card = Integer.parseInt(cardId);
                double balance = Double.parseDouble(balanceAmount);
                int cvc = Integer.parseInt(cvcNumber);
                double interest = Double.parseDouble(interestRate);
                String expirationDate = yearComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + dayComboBox.getSelectedItem();
                CreditCard creditCard = new CreditCard(card, clientName, issueBank, bankAccount, balance, cvc, interest, expirationDate);
                bankCards.add(creditCard);
                JOptionPane.showMessageDialog(null, "Credit Card added successfully");
                clear();
            }
        });

        addButton.addActionListener(e ->{

        });

        clearButton.addActionListener(e -> {
            clear();
        });

        displayButton.addActionListener(e -> {
                new DisplayCreditCard(bankCards);
        });

        backButton.addActionListener(e -> {
            dispose();
        });



        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        addCreditCardLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(addCreditCardLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIDLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIDTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(clientNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(clientNameTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(issueBankLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(issueBankTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(bankAccountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(bankAccountTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(balanceAmountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(balanceAmountTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(CVCNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        panel.add(CVCNumberTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(interestRateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel.add(interestRateTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(expirationDateLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        panel.add(yearComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        panel.add(monthComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        panel.add(dayComboBox, gbc);


        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(clearButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(addButton, gbc);


        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(backButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        panel.add(displayButton, gbc);

        add(panel);
    }

    public void clear(){

        cardIDTF.setText("");
        clientNameTf.setText("");
        issueBankTF.setText("");
        bankAccountTF.setText("");
        balanceAmountTF.setText("");
        CVCNumberTF.setText("");
        interestRateTF.setText("");
        yearComboBox.setSelectedIndex(0);
        monthComboBox.setSelectedIndex(0);
        dayComboBox.setSelectedIndex(0);
    }
}
