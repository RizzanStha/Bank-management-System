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

public class CancelCreditCard extends JFrame {
    MyCustomLabel CancelCreditCardLabel, CardIdLabel;
    MyCustomButton SubmitButton, ClearButton, backbutton;
    MyCustomTextField CancelCreditCardTF;
    public CancelCreditCard(ArrayList<BankCard> bankCards){
        super("Cancel Credit Card");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();

        CancelCreditCardLabel = new MyCustomLabel("Cancel Credit Card");
        CardIdLabel = new MyCustomLabel("Card Id");

        CancelCreditCardTF = new MyCustomTextField("");

        SubmitButton = new MyCustomButton("Submit");
        ClearButton = new MyCustomButton("Clear");
        backbutton = new MyCustomButton("Back");


        ClearButton.addActionListener(e -> {
            clear();
        });

        backbutton.addActionListener(e ->{
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
        CancelCreditCardLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(CancelCreditCardLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(CardIdLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(CancelCreditCardTF, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(SubmitButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(ClearButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(backbutton, gbc);

        SubmitButton.addActionListener(e -> {
            try {
                String cardId = CancelCreditCardTF.getText();
                if (bankCards.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please add credit card in Bank A/C first");
                } else if (cardId.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill up the section");
                } else {
                    int cardId2 = Integer.parseInt(cardId);
                    boolean foundCardId = false;
                    CreditCard creditCard = null;

                    for (BankCard bankCard2 : bankCards){
                        if (bankCard2 instanceof  CreditCard){
                            creditCard = (CreditCard) bankCard2;
                            if (creditCard.getCardId() == cardId2){
                                foundCardId = true;
                                break;

                            }
                        }
                    }
                    if (foundCardId){
                        cancelCreditCard(creditCard);
                        bankCards.set(bankCards.indexOf(creditCard),creditCard);
                    } else {
                        JOptionPane.showMessageDialog(null,"Please enter the valid Id");
                    }
                }
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Please enter the valid input");
            }

        });

        add(panel);
    }

    public void cancelCreditCard(CreditCard creditCard){
        creditCard.cancelCreditCard();
        JOptionPane.showMessageDialog(null,"Your credit card has been cancelled");
        clear();
    }

    public void clear(){

        CancelCreditCardTF.setText("");
    }
}
