package coursework.views;

import coursework.BankCard;
import coursework.CreditCard;
import coursework.DebitCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayCreditCard extends JFrame {
    public DisplayCreditCard(ArrayList<BankCard> bankCards){
        super("Display Debit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] columnNames = {"cardId", "clientName", "bankAccount","balanceAmount", "issuer Bank",
                               "Card type" ,"expirationDate","cvcNumber","Credit Limit","interestRate", "Grace Period","is granted"};
        ArrayList<CreditCard> creditCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof CreditCard) {
                creditCards.add((CreditCard) bankCard);
            }
        }
        String[][] data = new String[creditCards.size()][12];
        for (int i = 0; i < creditCards.size(); i++) {
            data[i][0] = String.valueOf(creditCards.get(i).getCardId());
            data[i][1] = String.valueOf(creditCards.get(i).getClientName());
            data[i][2] = String.valueOf(creditCards.get(i).getBankAccount());
            data[i][3] = String.valueOf(creditCards.get(i).getBalanceAmount());
            data[i][4] = String.valueOf(creditCards.get(i).getIssuerBank());
            data[i][5] =  "Credit Card";
            data[i][6] = String.valueOf(creditCards.get(i).getExpirationDate());
            data[i][7] = String.valueOf(creditCards.get(i).getCvcNumber());
            data[i][8] = String.valueOf(creditCards.get(i).getCreditLimit());
            data[i][9] = String.valueOf(creditCards.get(i).getInterestRate());
            data[i][10] = String.valueOf(creditCards.get(i).getGracePeriod());
            data[i][11] = String.valueOf(creditCards.get(i).isGranted());

        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
    }
}


