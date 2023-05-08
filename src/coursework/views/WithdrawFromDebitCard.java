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

    public class WithdrawFromDebitCard extends JFrame {

        MyCustomButton withdrawMoneyButton, ClearButton, backButton;
        MyCustomTextField cardIdTF, withdrawalAmountTF  , pinNumberTF;
        MyCustomLabel withdrawFormDebitCardLabel, cardIdLabel, withdrawalAmountLabel, dateOffWithdrawalLabel, pinNumberLabel;

        JComboBox selectYear, selectMonth, selectDay;


        public WithdrawFromDebitCard(ArrayList<BankCard> bankCards){
            super("Withdraw from Debit Card");
            setSize(600, 700);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

            JPanel panel = new JPanel();

            withdrawFormDebitCardLabel = new MyCustomLabel("Withdraw from Debit Card");
            cardIdLabel = new MyCustomLabel("Card Id");
            withdrawalAmountLabel = new MyCustomLabel("Withdrawal Amount");
            dateOffWithdrawalLabel = new MyCustomLabel("Date of Withdrawal");
            pinNumberLabel = new MyCustomLabel("PIN Number");

            cardIdTF = new MyCustomTextField("");
            withdrawalAmountTF = new MyCustomTextField("");
            pinNumberTF = new MyCustomTextField("");

            String [] years = {"Select Year",
                    "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033"};
            String [] months = {"Select Month",
                    "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
            String [] days = {"Select Day",
                    "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
                    "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
                    "27", "28", "29", "30", "31"};


            selectYear = new JComboBox<>(years);
            selectMonth = new JComboBox<>(months);
            selectDay = new JComboBox<>(days);


            withdrawMoneyButton = new MyCustomButton("Withdraw");
            ClearButton = new MyCustomButton("Clear");
            backButton = new MyCustomButton("Back");

            withdrawMoneyButton.addActionListener(e -> {

            });

            ClearButton.addActionListener(e -> {
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
            withdrawFormDebitCardLabel.setFont(new Font("Arial", Font.BOLD, 14));
            panel.add(withdrawFormDebitCardLabel, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            panel.add(cardIdLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            panel.add(cardIdTF, gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            panel.add(withdrawalAmountLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            panel.add(withdrawalAmountTF, gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            panel.add(pinNumberLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            panel.add(pinNumberTF, gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            panel.add(dateOffWithdrawalLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            panel.add(selectYear, gbc);

            gbc.gridx = 1;
            gbc.gridy = 5;
            gbc.gridwidth = 1;
            panel.add(selectMonth, gbc);

            gbc.gridx = 1;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            panel.add(selectDay, gbc);


            gbc.gridx = 0;
            gbc.gridy = 8;
            gbc.gridwidth = 1;
            panel.add(ClearButton, gbc);

            gbc.gridx = 1;
            gbc.gridy = 8;
            gbc.gridwidth = 1;
            panel.add(withdrawMoneyButton, gbc);

            gbc.gridx = 2;
            gbc.gridy = 8;
            gbc.gridwidth = 1;
            panel.add(backButton, gbc);

            withdrawMoneyButton.addActionListener(e -> {
                try {
                    String cardIdForDebit = cardIdTF.getText();
                    String withdrawalAmtForDebit = withdrawalAmountTF.getText();
                    String pinNumberForDebit = pinNumberTF.getText();
                    String dateOfWithdrawal = days[selectYear.getSelectedIndex()] + "-" + months[selectMonth.getSelectedIndex()] + "-" + years[selectDay.getSelectedIndex()];


                    if (bankCards.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please add debit card in Bank A/C first");
                        clear();
                    } else if (cardIdForDebit.isEmpty() || withdrawalAmtForDebit.isEmpty() || pinNumberForDebit.isEmpty() || selectDay.getSelectedIndex() == 0 || selectMonth.getSelectedIndex() == 0 || selectYear.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "please kindly fill your all details");
                        clear();
                    } else {
                        //              changing the string values from text fields into required double, int values.
                        int cardId = Integer.parseInt(cardIdForDebit);
                        int pinNumber = Integer.parseInt(pinNumberForDebit);
                        int withdrawalAmount = Integer.parseInt(withdrawalAmtForDebit);
                        boolean getCard = false;
                        DebitCard debitCard = null;

                        for (BankCard bankCard1 : bankCards) {
                            //To get the access the object of bankcard down-casting is used
                            if (bankCard1 instanceof DebitCard) {
                                debitCard = (DebitCard) bankCard1;
                                if (debitCard.getCardId() == cardId) {
                                    getCard = true;
                                    break;
                                }
                            }
                        }
                        if (getCard) {
                            withdraw(debitCard, withdrawalAmount, dateOfWithdrawal, pinNumber);
//
                            bankCards.set(bankCards.indexOf(debitCard), debitCard);
                        } else {
                            JOptionPane.showMessageDialog(null, "Card not found.Please enter valid card Id.");
                            clear();
                        }
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please input valid number.");
                    clear();
                }
            });

            add(panel);
        }


        public void withdraw (DebitCard debitCard,int withdrawalAmount, String dateOfWithdrawal, int pinNumber){

            if (debitCard.getPinNumber() == pinNumber) {
                if (debitCard.getBalanceAmount() < withdrawalAmount) {
                    JOptionPane.showMessageDialog(null, "Your balance is not enough");
                    clear();
                    return;
                }
                debitCard.withdraw(withdrawalAmount, dateOfWithdrawal, pinNumber);
                JOptionPane.showMessageDialog(null, "Withdrawal of amount is successful");
                clear();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid PIN.Please enter the correct pin number");
                clear();
            }
        }

        public void clear(){
            cardIdTF.setText("");
            pinNumberTF.setText("");
            withdrawalAmountTF.setText("");
            selectYear.setSelectedIndex(0);
            selectMonth.setSelectedIndex(0);
            selectDay.setSelectedIndex(0);
        }
    }