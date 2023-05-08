package coursework.views;

import coursework.BankCard;
import coursework.DebitCard;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomLabel;
import coursework.components.MyCustomTextField;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Font;

public class AddDebitCard extends JFrame {
    MyCustomTextField balanceAmountTF, cardIdTF, bankAccountTF, issueBankTF, clientNameTF, pinNumberTF;
    MyCustomButton addButton, clearButton, displayButton, backButton;
    MyCustomLabel addDebitCardLabel, balanceAmountLabel, cardIdLabel, bankAccountLabel, issueBankLabel, clientNameLabel, pinNumberLabel;
    public AddDebitCard(ArrayList<BankCard> bankCards){
        super("Add Debit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 1000);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();

        addDebitCardLabel = new MyCustomLabel("Add Debit Card");
        balanceAmountLabel = new MyCustomLabel("Balance Amount");
        cardIdLabel = new MyCustomLabel("Card Id");
        bankAccountLabel = new MyCustomLabel("Bank Account");
        issueBankLabel = new MyCustomLabel("Issue Bank");
        clientNameLabel = new MyCustomLabel("Client Name");
        pinNumberLabel = new MyCustomLabel("Pin Number");

        balanceAmountTF = new MyCustomTextField("");
        cardIdTF = new MyCustomTextField("");
        bankAccountTF = new MyCustomTextField("");
        issueBankTF = new MyCustomTextField("");
        clientNameTF = new MyCustomTextField("");
        pinNumberTF = new MyCustomTextField("");

        addButton = new MyCustomButton("Add");
        clearButton = new MyCustomButton("Clear");
        displayButton = new MyCustomButton("Display");
        backButton = new MyCustomButton("Back");

        addButton.addActionListener(e -> {
            String balanceAmount = balanceAmountTF.getText();
            String cardId = cardIdTF.getText();
            String bankAccount = bankAccountTF.getText();
            String issueBank = issueBankTF.getText();
            String clientName = clientNameTF.getText();
            String pinNumber = pinNumberTF.getText();

            if (balanceAmount.equals("") || cardId.equals("") || bankAccount.equals("") || issueBank.equals("") || clientName.equals("") || pinNumber.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            } else if (pinNumber.equals("")){
                JOptionPane.showMessageDialog(null,"Please fill the value for the pin Number");
            } else {
                try {
                    double balance = Double.parseDouble(balanceAmount);
                    int card = Integer.parseInt(cardId);
                    int pin = Integer.parseInt(pinNumber);
                    DebitCard debitCard = new DebitCard(balance, card, bankAccount, issueBank, clientName, pin);
                    bankCards.add(debitCard);
                    JOptionPane.showMessageDialog(null, "Debit Card added successfully");
                    clear();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter the valid input for the fields");
                }
            }
        });

        clearButton.addActionListener(e -> {
            clear();
        });

        displayButton.addActionListener(e -> {
            new DisplayDebitCard(bankCards);
        });

        backButton.addActionListener( e ->{
            dispose();
        });

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.anchor = GridBagConstraints.CENTER;
        addDebitCardLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(addDebitCardLabel, gbc);

//        gbc.weighty = 1.0;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 0, 10);
        panel.add(balanceAmountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(balanceAmountTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(cardIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(cardIdTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(bankAccountLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(bankAccountTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(issueBankLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(issueBankTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(clientNameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(clientNameTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(pinNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel.add(pinNumberTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(clearButton, gbc);

//        gbc.gridwidth = 2;
//        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.insets = new Insets(10, -110, 0, 10);
        panel.add(addButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.insets = new Insets(10, -100, 0, 10);
        panel.add(displayButton, gbc);

        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.insets = new Insets(10, 0, 0, 10);
        panel.add(backButton, gbc);

        add(panel);

    }

    public void clear() {
        balanceAmountTF.setText("");
        cardIdTF.setText("");
        bankAccountTF.setText("");
        issueBankTF.setText("");
        clientNameTF.setText("");
        pinNumberTF.setText("");
    }
}
