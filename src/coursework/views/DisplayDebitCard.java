package coursework.views;

import coursework.BankCard;
import coursework.DebitCard;

import javax.swing.*;
import java.util.ArrayList;

public class DisplayDebitCard extends JFrame {

    public DisplayDebitCard(ArrayList<BankCard> bankCards){
        super("Display Debit Cards");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        //RESIZEABLE
        setResizable(true);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Issuer Bank","Client Name", "Card Type", "Pin",
                "Has Withdrawn", "WithdrawalAmount","DateOfWithdrawal"};
        ArrayList<DebitCard> debitCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof DebitCard) {
                debitCards.add((DebitCard) bankCard);
            }
        }
        String[][] data = new String[debitCards.size()][10];
        for (int i = 0; i < debitCards.size(); i++) {
            data[i][0] = String.valueOf(debitCards.get(i).getCardId());
            data[i][1] = String.valueOf(debitCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(debitCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(debitCards.get(i).getIssuerBank());
            data[i][4] = String.valueOf(debitCards.get(i).getClientName());
            data[i][5] =  "Debit Card";
            data[i][6] = String.valueOf(debitCards.get(i).getPinNumber());
            data[i][7] = String.valueOf(debitCards.get(i).hasWithdrawn());
            data[i][8] = String.valueOf(debitCards.get(i).getWithdrawalAmount());
            data[i][9] = String.valueOf(debitCards.get(i).getDateOfWithdrawal());
        }
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
    }
}
