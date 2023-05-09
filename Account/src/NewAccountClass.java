import java.util.*;
public class NewAccountClass {
    private static Map<String, String[]> accountInfo = new HashMap<>();
    private static ArrayList<String[]> accountTransactions = new ArrayList<String[]>();

    public static void main(String[] args){
        parseCsv();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the USSD Bank App. Please select an option:");
            System.out.println("1. to check account balance");
            System.out.println("2. to check account details");
            System.out.println("3. to print last 3 transactions");
            System.out.println("4. to change phone number");
            System.out.println("5. to exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    checkAccountBalance(scanner);
                    break;
                case 2:
                    checkAccountDetails(scanner);
                    break;
                case 3:
                    printTransactions(scanner);
                    break;
                case 4:
                    changePhoneNumber(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the USSD Bank App!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }
    }

    public static void checkAccountBalance(Scanner scanner) {
        System.out.println("Enter account number: ");
        String accountNumber = scanner.nextLine();
        double balance = 0;
        for (String[] transaction : accountTransactions) {
            if (transaction[1].equals(accountNumber)) {
                double amount = Double.parseDouble(transaction[2]);
                if (transaction[3].equals("Credit")) {
                    balance += amount;
                } else if (transaction[3].equals("Debit")) {
                    balance -= amount;
                }
            }
        }
        String[] details = accountInfo.get(accountNumber);
        System.out.printf("The account balance for %s %s is: %.2f\n", details[0], details[1], balance);
    }

    static void checkAccountDetails(Scanner scanner){
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        String[] details = accountInfo.get(accountNumber);
        if (details != null){
            System.out.printf("The account details for account number %s is:\n", accountNumber);
            System.out.printf("First Name: %s, Last Name: %s, Phone Number: %s", details[0], details[1], details[2]);
        } else {
            System.out.println("The Account Number is invalid");
        }
    }

    static void printTransactions(Scanner scanner){
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();
        ArrayList<String[]> transactions = new ArrayList<>();
        int count = 0;

        for(String[] transaction: accountTransactions){
            if(transaction[1].equals(accountNumber)){
                transactions.add(transaction);
                count++;

                if (count == 3){
                    break;
                }
            }
        }

        if (transactions.size() > 0){
            String[] details = accountInfo.get(accountNumber);
            System.out.println("The Last 3 transactions for " + details[0] + " is: ");
            System.out.println("--------------------------------------");
            System.out.println("|  Amount      |    Transaction Type |");
            System.out.println("--------------------------------------");

            for (String[] transaction : transactions) {
                System.out.printf("|  %-12s|    %-17s|\n", transaction[2], transaction[3]);
                System.out.println("--------------------------------------");
            }
        } else{
            System.out.println("No transactions found for account number " + accountNumber);
        }
    }

    static void changePhoneNumber(Scanner scanner){
        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();

        String[] accountDetail = accountInfo.get(accountNumber);

        if (accountDetail == null){
            System.out.println("Invalid account number.");
            return;
        }

        System.out.print("Enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();

        accountDetail[2] = newPhoneNumber;
        accountInfo.put(accountNumber, accountDetail);

        System.out.println("Your new phone number has been changed.");
    }

    private static void parseCsv() {
        // parse the customer info CSV string and store the data in the customerInfo array
        String customerInfoCSV = "First Name,Last Name,Account Number,Phone Number\n" +
                                 "Onome,Ehigiator,6152,08148975238\n" +
                                 "Adegoke,Akeem-omosanya,6972,07015181324\n" +
                                 "Bukola,Ehigiator,8467,07029300358\n" +
                                 "Olufunmi,Aremu,3976,08010170877\n" +
                                 "Ifeanyichukwu,Ekwueme,8965,07021118253\n" +
                                 "Isioma,Mustapha,8555,09164393835\n" +
                                 "Ayebatari,Joshua,8657,09050143877\n" +
                                 "Nnamdi,Olawale,3587,07021899665\n" +
                                 "Lola,Abosede,6807,07062943330\n" +
                                 "Emeka,Oyelude,6701,08190576207";
        String[] rows = customerInfoCSV.split("\n");
        for (int i = 1; i < rows.length; i++) {
            String[] cols = rows[i].split(",");
            String[] details = new String[] {cols[0], cols[1], cols[3]};
            accountInfo.put(cols[2], details);
        }
        // parse the account transactions CSV string and store the data in the accountTransactions array
        String accountTransactionsCSV = "SN,Account Number,Amount,Credit/Debit\n" +
                "1,6152,2008,Credit\n" +
                "2,6152,1173,Credit\n" +
                "3,6152,2994,Credit\n" +
                "4,6152,2147,Debit\n" +
                "5,6152,4989,Debit\n" +
                "6,6972,4344,Credit\n" +
                "7,6972,4545,Credit\n" +
                "8,6972,4021,Credit\n" +
                "9,6972,4991,Debit\n"  +
                "10,6972,2038,Credit\n" +
                "11,8467,2243,Credit\n" +
                "12,8467,3216,Credit\n" +
                "13,8467,2417,Debit\n" +
                "14,8467,2106,Credit\n" +
                "15,8467,4533,Debit\n" +
                "16,3976,4616,Credit\n" +
                "17,3976,4941,Credit\n" +
                "18,3976,1439,Debit\n" +
                "19,3976,4082,Credit\n" +
                "20,3976,2022,Debit\n" +
                "21,8965,3248,Credit\n" +
                "22,8965,3921,Credit\n" +
                "23,8965,3309,Debit\n" +
                "24,8965,1880,Credit\n" +
                "25,8965,3936,Debit\n" +
                "26,8555,4511,Credit\n" +
                "27,8555,1902,Credit\n" +
                "28,8555,1097,Debit\n" +
                "29,8555,2007,Credit\n" +
                "30,8555,3289,Credit\n" +
                "31,8657,3530,Debit\n" +
                "32,8657,4565,Debit\n" +
                "33,8657,1669,Credit\n" +
                "34,8657,1054,Credit\n" +
                "35,8657,4723,Debit\n" +
                "36,3587,4673,Debit\n" +
                "37,3587,2722,Credit\n" +
                "38,3587,3554,Credit\n" +
                "39,3587,2891,Debit\n" +
                "40,3587,3590,Credit\n" +
                "41,6807,1711,Credit\n" +
                "42,6807,4020,Credit\n" +
                "43,6807,1594,Debit\n" +
                "44,6807,4692,Debit\n" +
                "45,6807,1774,Credit\n" +
                "46,6701,4629,Credit\n" +
                "47,6701,3602,Debit\n" +
                "48,6701,1010,Credit\n" +
                "49,6701,3596,Credit\n" +
                "50,6701,1632,Debit\n";

        String[] detailsRows = accountTransactionsCSV.split("\n");
        for (int i = 1; i < detailsRows.length; i++) {
            String[] detailsCols = detailsRows[i].split(",");
            accountTransactions.add(detailsCols);
        }
    }
}
