package coursework.views;

import coursework.BankCard;
import coursework.CreditCard;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomLabel;
import coursework.components.MyCustomTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.Font;

public class SetCreditLimit extends JFrame {

    MyCustomButton setCreditLimitButton, clearButton, backButton;
    MyCustomLabel  setCreditLimitLabel, cardIdLabel, newCreditLimitLabel, newGracePeriodLabel;

    MyCustomTextField   cardIdTextField, newCreditLimitTextField, newGracePeriodTextField;

    public SetCreditLimit(ArrayList<BankCard> bankCards){
        super("Set Credit Limit");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel panel = new JPanel();

        setCreditLimitLabel = new MyCustomLabel("Set Credit Limit");
        cardIdLabel = new MyCustomLabel("Card Id");
        newCreditLimitLabel = new MyCustomLabel("New Credit Limit");
        newGracePeriodLabel = new MyCustomLabel("New Grace Period");

        cardIdTextField = new MyCustomTextField("");
        newCreditLimitTextField = new MyCustomTextField("");
        newGracePeriodTextField = new MyCustomTextField("");

        setCreditLimitButton = new MyCustomButton("Set");
        clearButton = new MyCustomButton("Clear");
        backButton = new MyCustomButton("Back");

        setCreditLimitButton.addActionListener(e -> {
            //clear();
        });

        clearButton.addActionListener(e -> {
            clear();
        });

        backButton.addActionListener(e -> {
            dispose();
        });

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setLayout(gbl);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        setCreditLimitLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(setCreditLimitLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(cardIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(cardIdTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(newCreditLimitLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(newCreditLimitTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(newGracePeriodLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(newGracePeriodTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(setCreditLimitButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(clearButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(backButton, gbc);

        setCreditLimitButton.addActionListener(e -> {
            try {
                String cardId = cardIdTextField.getText();
                String creditLimit = newCreditLimitTextField.getText();
                String gracePeriod = newGracePeriodTextField.getText();

                if (bankCards.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please add credit card in Bank A/C first");
                    clear();
                } else if (cardId.isEmpty() || creditLimit.isEmpty() || gracePeriod.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up all the section");
                    clear();
                } else {
                    int cardId1 = Integer.parseInt(cardId);
                    double newCreditLimit = Double.parseDouble(creditLimit);
                    int newGracePeriod = Integer.parseInt(gracePeriod);
                    boolean foundcard = false;
                    CreditCard creditCard = null;
                    for (BankCard bankCard1 : bankCards) {
                        if (bankCard1 instanceof CreditCard) ;
                        creditCard = (CreditCard) bankCard1;

                        if (creditCard.getCardId() == cardId1) {
                            foundcard = true;
                            break;

                        }
                    }
                    if (foundcard) {
                        setCreditLimit(creditCard, newCreditLimit, newGracePeriod);
                        bankCards.set(bankCards.indexOf(creditCard), creditCard);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please fill the correct Card ID");
                        clear();
                    }
                }


            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please Fill up the fields in correct order");
                clear();
            }
        });
        add(panel);
    }


    public void setCreditLimit(CreditCard creditCard, double newCreditLimit, int newGracePeriod){
        if (newCreditLimit >= 2.5 * creditCard.getBalanceAmount()){
            JOptionPane.showMessageDialog(null,"Your credit limit cannot be more than 2.5 times the balance amount");
            clear();
        }else {
            creditCard.setCreditLimit(newCreditLimit, newGracePeriod);
            JOptionPane.showMessageDialog(null,"Your credit limit has been set");
            clear();
        }
    }




    public void clear(){
        cardIdTextField.setText("");
        newCreditLimitTextField.setText("");
        newGracePeriodTextField.setText("");
    }







}
