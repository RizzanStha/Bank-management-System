package coursework;

public class DebitCard extends coursework.BankCard {

    // Attribute to store the PIN number of the debit card
    private int pinNumber;
    // Attribute to store the amount withdrawn from the account
    private int withdrawalAmount;
    // Attribute to store the date of the withdrawal
    private String dateOfWithdrawal;
    // Attribute to store the date of the withdrawal
    private boolean hasWithdrawn;

    // Constructor for the coursework2.DebitCard class, which accepts six parameters and calls the superclass constructor
    public DebitCard(double balanceAmount, int cardId, String bankAccount, String issuerBank, String clientName,int pinNumber ) {
        // Call the superclass constructor with the parameters it expects
        super(balanceAmount, cardId, bankAccount, issuerBank);
        //call the setter method (client name) from the Bankcard
        super.setClientName(clientName);
        //call the setter method (balance amount) from the Bankcard
        super.setBalanceAmount(balanceAmount);
        // Assign the value of the pinNumber parameter to the pinNumber attribute
        this.pinNumber = pinNumber;
        // Initialize the hasWithdrawn attribute to false
        this.hasWithdrawn = false;
    }

    // Accessor methods for the attributes
    public int getPinNumber() {
        return pinNumber;
    }
    // Accessor method for the withdrawalAmount attribute
    public int getWithdrawalAmount() {
        return withdrawalAmount;
    }
    // Accessor method for the dateOfWithdrawal attribute
    public String getDateOfWithdrawal() {
        return dateOfWithdrawal;
    }
    // Accessor method for the hasWithdrawn attribute
    public boolean hasWithdrawn() {
        return hasWithdrawn;
    }
    // Mutator method for the withdrawal amount attribute
    public void setWithdrawalAmount(int withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }
    //Method to withdraw money from the account, if a valid PIN is entered and sufficient balance is available
    public void withdraw(int withdrawalAmount, String dateOfWithdrawal, int pinNumber) {
        // Check if the entered PIN is valid and there is sufficient balance for the withdrawal
        if (this.pinNumber == pinNumber) {
            if(super.getBalanceAmount() >= withdrawalAmount){
                this.hasWithdrawn = true;
                // Deduct the withdrawal amount from the balance
                setBalanceAmount(getBalanceAmount()-withdrawalAmount);
                // Update the values of the withdrawalAmount and dateOfWithdrawal attributes
                this.dateOfWithdrawal = dateOfWithdrawal;
                // Update the values of has withdrawan
                this.withdrawalAmount=withdrawalAmount;

            }else {
                System.out.println(" Insufficient Balance.");
            }
        }else{
            System.out.println("Invalid PIN");
        }

    }
    // Method to display the details of the Debit Card
    public void display() {
        // Call the display method of the superclass to display the cardId, clientName, issuerBank, and bankAccount attributes
        super.display();
        // Display the PIN attribute
        System.out.println("PIN: " + this.pinNumber);
        // If a withdrawal has been made, display the withdrawalAmount and dateOfWithdrawal attributes
        if (this.hasWithdrawn==true) {
            System.out.println("Withdrawal Amount: " + this.withdrawalAmount);
            System.out.println("Date of Withdrawal: " + this.dateOfWithdrawal);
            // If no withdrawal has been made, display No withdrawal has been made yet.
        } else {
            System.out.println("Balance Amount:"+getBalanceAmount());
            System.out.println("No withdrawal has been made yet.");
        }
    }
}