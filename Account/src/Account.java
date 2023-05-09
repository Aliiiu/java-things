import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Account {

    private String name;
    private double balance;

    public Account(String name, double balance){
        this.name = name;

        if(balance > 0){
            this.balance = balance;
        }
    }

    public void deposit(double depositAmount){
        if (depositAmount > 0){
            this.balance += depositAmount;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void withdraw(double amount){
        if (amount <= this.balance && amount > 0){
            this.balance -= amount;
        } else{
            System.out.println("Withdrawal amount exceeded account balance.");
        }
    }

    public static void displayAccount(Account accountToDisplay){
        System.out.printf("%s balance: $%.2f%n",
                accountToDisplay.getName(), accountToDisplay.getBalance());
    }

    public static void main(String[] args) {
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -7.53);

        // display initial balance of each object
        displayAccount(account1);
        displayAccount(account2);
        // create a Scanner to obtain input from the command window
        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount for account1: "); // prompt
        double depositAmount = input.nextDouble(); // obtain user input
        System.out.printf("%nadding %.2f to account1 balance%n%n",
                depositAmount);
        account1.deposit(depositAmount); // add to account1's balance

        // display balances
        displayAccount(account1);
        displayAccount(account2);

        System.out.print("Enter deposit amount for account2: "); // prompt
        depositAmount = input.nextDouble(); // obtain user input
        System.out.printf("%nadding %.2f to account2 balance%n%n",
                depositAmount);
        account2.deposit(depositAmount); // add to account2 balance

        // display balances
        displayAccount(account1);
        displayAccount(account2);
    }
}