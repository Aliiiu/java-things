import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StaffSorter {
    public static void main(String[] args) {
        // Store the csv content in a string variable
        String csv = "First Name,Last Name,Age\n"
                + "Onome,Ehigiator,45\n"
                + "Adegoke,Akeem-omosanya,67\n"
                + "Bukola,Ehigiator,66\n"
                + "Olufunmi,Aremu,34\n"
                + "Ifeanyichukwu,Ekwueme,54\n"
                + "Isioma,Mustapha,57\n"
                + "Ayebatari,Joshua,25\n"
                + "Nnamdi,Olawale,76\n"
                + "Lola,Abosede,45\n"
                + "Emeka,Oyelude,34\n"
                + "Aminu,Ogunbanwo,67\n"
                + "Simisola,Ekwueme,98\n"
                + "Ayebatari,Busari,56\n"
                + "Chinyere,Uchechi,52\n"
                + "Adeboye,Jamiu,84\n"
                + "Titilayo,Kimberly,56\n"
                + "Chimamanda,Ehigiator,34\n"
                + "Bukola,Adegoke,57\n"
                + "Cherechi,Elebiyo,59\n"
                + "Titilayo,Afolabi,90\n";

        // Parse the staff records from the csv string
        List<Staff> staffList = parseCsv(csv);

        // Ask the user how they want to sort the staff records
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to sort by First Name");
        System.out.println("Enter 2 to sort by Last Name");
        System.out.println("Enter 3 to sort by Age");
        int option = scanner.nextInt();
        scanner.close();

        // Sort the staff records based on the user's selection
        Comparator<Staff> comparator = null;
        switch (option) {
            case 1:
                comparator = Comparator.comparing(Staff::getFirstName);
                break;
            case 2:
                comparator = Comparator.comparing(Staff::getLastName);
                break;
            case 3:
                comparator = Comparator.comparing(Staff::getAge);
                break;
            default:
                System.out.println("Invalid option");
                return;
        }
        Collections.sort(staffList, comparator);

        // Print the sorted staff records
        for (Staff staff : staffList) {
            System.out.println(staff);
        }
    }

    // Parse the staff records from the csv string
    private static List<Staff> parseCsv(String csv) {
        List<Staff> staffList = new ArrayList<>();
        String[] lines = csv.split("\n");
        String[] headers = lines[0].split(",");
        for (int i = 1; i < lines.length; i++) {
            String[] fields = lines[i].split(",");
            if (fields.length != headers.length) {
                System.out.println("Invalid record: " + lines[i]);
            } else {
                String firstName = fields[0];
                String lastName = fields[1];
                int age = Integer.parseInt(fields[2]);
                Staff staff = new Staff(firstName, lastName, age);
                staffList.add(staff);
            }
        }
        return staffList;
    }
}

