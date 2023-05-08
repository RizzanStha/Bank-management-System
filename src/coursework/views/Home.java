package coursework.views;

import javax.swing.*;

import coursework.BankCard;
import coursework.DebitCard;
import coursework.components.MyCustomButton;
import coursework.components.MyCustomLabel;

import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.lightGray;

public class Home extends JFrame {

    ArrayList<BankCard> bankCards = new ArrayList<>();
    MyCustomButton AddDebitCardButton, AddCreditCardButton, WithdrawFromDebitCardButton, SetCreditLimitButton, CancelCreditCardButton, DisplayButton;
    MyCustomLabel questionLabel;
    public Home(){
        super("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);


        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setForeground(Color.BLACK);
        panel.setFont(new Font("Arial", Font.PLAIN, 20));
        AddDebitCardButton = new MyCustomButton("Add Debit Card");
        AddCreditCardButton = new MyCustomButton("Add Credit Card");
        WithdrawFromDebitCardButton = new MyCustomButton("Withdraw from Debit Card");
        SetCreditLimitButton = new MyCustomButton("Set the credit limit");
        CancelCreditCardButton = new MyCustomButton("Cancel credit card");
        DisplayButton = new MyCustomButton("Display");

        AddDebitCardButton.addActionListener(e -> {
            new AddDebitCard(bankCards);
        });

        AddCreditCardButton.addActionListener(e -> {
            new coursework.views.AddCreditCard(bankCards);
        });

        WithdrawFromDebitCardButton.addActionListener(e -> {
            new WithdrawFromDebitCard(bankCards);
        });

        SetCreditLimitButton.addActionListener(e -> {
            new SetCreditLimit(bankCards);
        });

        CancelCreditCardButton.addActionListener(e -> {
            new coursework.views.CancelCreditCard(bankCards);
        });

        DisplayButton.addActionListener(e -> {
            new coursework.views.Display(bankCards);
        });
        MyCustomLabel questionLabel1 = new MyCustomLabel("The Rizs Bank");
        MyCustomLabel questionLabel2 = new MyCustomLabel("Choose one of the options below to continue:");

// Set the  text color of questionLabel1
        questionLabel1.setForeground(Color.darkGray);

// Set the font and alignment of questionLabel1
        questionLabel1.setFont(new Font("Arial", Font.BOLD, 24));
        questionLabel1.setHorizontalAlignment(JLabel.CENTER);



        GridBagConstraints gbcHome = new GridBagConstraints();
        GridBagLayout gblHome = new GridBagLayout();
        setLayout(gblHome);

        gbcHome.gridx = 0;
        gbcHome.gridy = 0;
        gbcHome.gridwidth = GridBagConstraints.REMAINDER; // Take up the whole row
//        gbcHome.gridwidth = 1;
        gbcHome.insets = new Insets(10, 10, 10, 10);
        add(questionLabel1, gbcHome);

        gbcHome.gridy = 1;
        gbcHome.gridwidth = 2; // Reset the gridwidth
        gbcHome.insets = new Insets(20, 10, 10, 10);
        add(questionLabel2, gbcHome);

        gbcHome.gridx = 0;
        gbcHome.gridy = 2;
        gbcHome.gridwidth = 1;
        gbcHome.insets = new Insets(10, 10, 20, 10);
        gbcHome.anchor = GridBagConstraints.CENTER;
        gbcHome.fill = GridBagConstraints.HORIZONTAL;
        add(AddDebitCardButton, gbcHome);

        gbcHome.gridx = 1;
        add(AddCreditCardButton, gbcHome);

        gbcHome.gridx = 2;
        add(WithdrawFromDebitCardButton, gbcHome);

        gbcHome.gridx = 0;
        gbcHome.gridy = 3;
        add(SetCreditLimitButton, gbcHome);

        gbcHome.gridx = 1;
        add(CancelCreditCardButton, gbcHome);

        gbcHome.gridx = 2;
        add(DisplayButton, gbcHome);

        

// Set the background color of the panel
        setBackground(new Color(145, 134, 134));

    }
}
