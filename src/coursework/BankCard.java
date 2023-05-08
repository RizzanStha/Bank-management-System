package coursework;

public class BankCard {

    //Attributes to store cardId of client of the coursework2.BankCard
    private int cardId;
    //Attributes to store the customer or clientName
    private String clientName;
    //Attributes to store name of the issuer Bank
    private String issuerBank;
    //Attributes to store the bank account of the client
    private String bankAccount;
    //Attributes to store the balance amount of the client
    private double balanceAmount;

    //Constructor for bankCard with four parameters balanceAmount, cardId, bankAccount,issuerBank.
    protected BankCard(double balanceAmount, int cardId, String bankAccount,String issuerBank) {
        this.balanceAmount = balanceAmount;
        this.cardId = cardId;
        this.bankAccount = bankAccount;
        this.issuerBank = issuerBank;
        //An empty string shall be initialized as the client name.
        this.clientName = "";
    }

    // Accessor method for card id
    public int getCardId() {
        return cardId;
    }

    // Accessor method for bank account
    public String getClientName() {
        return clientName;
    }
    // Accessor method for bank account
    public String getIssuerBank() {
        return issuerBank;
    }
    // Accessor method for bank account
    public String getBankAccount() {
        return bankAccount;
    }
    // Accessor method for balance amount
    public double getBalanceAmount() {
        return balanceAmount;
    }
    // method to set the client name
    // this method accepts a new client name as a parameter
    public void setClientName(String newClientName) {
        this.clientName = newClientName;
    }
    // method to set the Balance amount
    // this method accepts a new  as a balance amount meter
    public void setBalanceAmount(double newBalanceAmount){
        this.balanceAmount= newBalanceAmount;

    }
    // method to display the details of the bank card
    public void display() {
        //if the client name is not given and empty
        if (this.clientName.isEmpty()) {
            System.out.println("Client name not valid.");
        }else{
            //display the output card I'd, client name, issuer bank, bank account, and BalanceAmount.
            System.out.println("Card ID: " + this.cardId);
            System.out.println("Client name: " + this.clientName);
            System.out.println("Issuer bank: " + this.issuerBank);
            System.out.println("Bank account: " + this.bankAccount);
            System.out.println("Balance amount: " + this.balanceAmount);
        }
    }
}