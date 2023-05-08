package coursework;

public class CreditCard extends coursework.BankCard {

    //Attributes to store different data
    private int cvcNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;

    //constructor that accepts eight parameters: cardId, clientName, issuerBank, bankAccount, balanceAmount, cvcNumber, interestRate, expirationDate as expected
    public CreditCard(int cardId, String clientName, String issuerBank, String bankAccount, double balanceAmount, int cvcNumber, double interestRate, String expirationDate) {
        //call to the constructor of the superclass with four arguments
        super(balanceAmount,cardId, bankAccount, issuerBank);
        //call the setter method (client name) from the Bankcard
        super.setClientName(clientName);
        //call the setter method (balance amount) from the Bankcard
        super.setBalanceAmount(balanceAmount);
        // assign CVC number, interest rate, expiration date,credit limit,grace period with the parameter values
        this.cvcNumber =cvcNumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        // isGranted is set to false
        this.isGranted = false;
    }

    // accessor method for CVC number
    public int getCvcNumber() {
        return this.cvcNumber;
    }

    // accessor method for credit limit
    public double getCreditLimit() {
        return this.creditLimit;
    }

    // accessor method for interest rate
    public double getInterestRate() {
        return this.interestRate;
    }

    // accessor method for expiration date
    public String getExpirationDate() {
        return this.expirationDate;
    }

    // accessor method for grace period
    public int getGracePeriod() {
        return this.gracePeriod;
    }

    // accessor method for isGranted
    public boolean isGranted() {
        return this.isGranted;
    }
    //method to set the credit limit,the method accepts a new credit limit and new grace period as parameters.
    public void setCreditLimit(double newCreditLimit, int newGracePeriod) {
        /* if the credit limit is less than or equal to 2.5 times the debit amount,
        credit is issued to the client and new values are assigned to the credit limit's
        and grace period attributes
         **/
        if (newCreditLimit <= 2.5 * super.getBalanceAmount()) {
            this.creditLimit = newCreditLimit;
            this.gracePeriod = newGracePeriod;
            this.isGranted = true;
        } else {
            /* if the credit has not been granted to the client, a suitable message is output
            to the user indicating that the credit cannot be issued
             **/
            System.out.println("Credit cannot be issued to the client as s/he dosen't meet the requirement.");
        }
    }

    // Method to cancel the credit card this method will remove the client's credit card (only if the client has paid all the interest rates and credits within the given period)
    public void cancelCreditCard() {
        /* if the credit card has been granted and the attributes cvc number, credit limit, and grace period are set to zero
        and the attribute isGranted is set to false
         **/
        if (isGranted) {
            // initialize the attribute cvcNumber, creditLimit,gracePeriod as 0
            this.cvcNumber =0;
            this.creditLimit =0;
            this.gracePeriod =0;
            this.isGranted = false;
            System.out.println("Credit card not valid");
        }else{
            System.out.println("Credit card is valid");
        }
    }

    // Method to display the details of the coursework2.CreditCard object
    public void display() {
        System.out.println("Cvc Number: " + cvcNumber);
        System.out.println("Interest Rate: " +interestRate);
        System.out.println("Expiration Date: " +expirationDate);
        /* if is granted is true then this method will display the super class with grace period and credit limit else,
         * it will print cvc number,interest rate,expiration date with suitable message.
         * */
        if (isGranted==true) {
            super.display();
            System.out.println("Grace Period: " +gracePeriod);
            System.out.println("Credit Limit: " +creditLimit);
        } else{
            System.out.println("Credit has not been granted");
        }
    }

}