package coursework.views;

import coursework.BankCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JFrame {
    JTable table;
    public Display(ArrayList<BankCard> bankCards){
        super("Display");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type"};
        String[][] data = new String[bankCards.size()][6];
        for (int i = 0; i < bankCards.size(); i++) {
            data[i][0] = String.valueOf(bankCards.get(i).getCardId());
            data[i][1] = String.valueOf(bankCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(bankCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(bankCards.get(i).getClientName());
            data[i][4] = String.valueOf(bankCards.get(i).getIssuerBank());
            data[i][5] = bankCards.get(i) instanceof coursework.DebitCard ? "Debit Card" : "Credit Card";
        }
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        add(panel);
    }
}
