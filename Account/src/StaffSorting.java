import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StaffSorting {
    public static void main(String[] args) {
        String csvData = "First Name,Last Name,Age\n" +
                "Onome,Ehigiator,45\n" +
                "Adegoke,Akeem-omosanya,67\n" +
                "Bukola,Ehigiator,66\n" +
                "Olufunmi,Aremu,34\n" +
                "Ifeanyichukwu,Ekwueme,54\n" +
                "Isioma,Mustapha,57\n" +
                "Ayebatari,Joshua,25\n" +
                "Nnamdi,Olawale,76\n" +
                "Lola,Abosede,45\n" +
                "Emeka,Oyelude,34\n" +
                "Aminu,Ogunbanwo,67\n" +
                "Simisola,Ekwueme,98\n" +
                "Ayebatari,Busari,56\n" +
                "Chinyere,Uchechi,52\n" +
                "Adeboye,Jamiu,84\n" +
                "Titilayo,Kimberly,56\n" +
                "Chimamanda,Ehigiator,34\n" +
                "Bukola,Adegoke,57\n" +
                "Cherechi,Elebiyo,59\n" +
                "Titilayo,Afolabi,90\n";

        String[] lines = csvData.split("\n");
        String[] headers = lines[0].split(",");

        List<Staff> staffList = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String[] fields = lines[i].split(",");
            Staff staff = new Staff(fields[0], fields[1], Integer.parseInt(fields[2]));
            staffList.add(staff);
        }

        System.out.println("Enter 1 to sort by First Name");
        System.out.println("Enter 2 to sort by Last Name");
        System.out.println("Enter 3 to sort by Age");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                staffList.sort(Comparator.comparing(Staff::getFirstName));
                break;
            case 2:
                staffList.sort(Comparator.comparing(Staff::getLastName));
                break;
            case 3:
                staffList.sort(Comparator.comparing(Staff::getAge));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }
        System.out.println("----------------------------------------------------");
        System.out.println("|  First Name      |   Last Name        |  Age     |");
        System.out.println("----------------------------------------------------");
        for (Staff staff : staffList) {
            System.out.printf("|  %-16s|    %-16s|  %-6d  |\n", staff.getFirstName(), staff.getLastName(), staff.getAge());
            System.out.println("----------------------------------------------------");
        }
    }
}

class Staff {
    private String firstName;
    private String lastName;
    private int age;

    public Staff(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

}
