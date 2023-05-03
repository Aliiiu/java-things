
import java.util.Scanner;

public class stringSplitter {
  public static void name(String args[]) {
    Scanner scanner = new Scanner(System.in);
      
    System.out.println("Enter the csv string: ");

    String csvData = scanner.nextLine();  

    String[] lines = csvData.split("\\r\\n");

    // Print out the input string before and after the split
    System.out.println("Original input: " + csvData);
    System.out.println("After split: ");
    for (String line : lines) {
        System.out.println(line);
    }

    scanner.close();
  }
}
