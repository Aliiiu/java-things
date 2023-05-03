import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private String classname;
    private String id;
    private String name;
    private String subject;
    private int ca1;
    private int ca2;
    private int exam;
    private int total;
    private int position;

    public Student(String classname, String id, String name, String subject, int ca1, int ca2, int exam) {
        this.classname = classname;
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.ca1 = ca1;
        this.ca2 = ca2;
        this.exam = exam;
        this.total = ca1 + ca2 + exam;
    }

    public String getClassname() {
        return classname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public int getCA1() {
        return ca1;
    }

    public int getCA2() {
        return ca2;
    }

    public int getExam() {
        return exam;
    }

    public int getTotal() {
        return total;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%d,%d,%d,%d", classname, id, name, subject, ca1, ca2, exam, total, position);
    }
}

public class ResultComputation {
  private static final String CSV_DATA = "Class,Student ID,Student Name,Subject,CA1 Score,CA2 Score,Exam Score\n"
            + "SSS1,SN001,Adekunle Gold,Math,10,12,60\n"
            + "SSS1,SN002,Simi Gold,Math,15,13,49\n"
            + "SSS1,SN003,Adamu Abdul,Math,11,10,37\n"
            + "SSS1,SN004,Ada Amaka,Math,11,4,49\n"
            + "SSS1,SN005,Kelly Handsome,Math,12,5,56\n"
            + "SSS1,SN006,Billy King,Math,6,9,48\n"
            + "SSS2,SN007,Onyekachukwu Chiamaka,Math,7,12,65\n"
            + "SSS2,SN008,Chinyelu Onyekachi,Math,11,7,54\n"
            + "SSS2,SN009,Akuchi Ekwueme,Math,10,5,29\n"
            + "SSS2,SN010,Ekwueme Chibuike,Math,2,4,34\n"
            + "SSS2,SN011,Chidimma Nwanneka,Math,8,4,61\n"
            + "SSS2,SN012,Ifeoma Okeke,Math,9,3,56\n"
            + "SSS2,SN013,Bosede Ade,Math,8,11,34\n"
            + "SSS3,SN014,Bose Olufunmilayo,Math,9,10,12\n"
            + "SSS3,SN015,Funmilayo Bolanle,Math,14,2,49\n"
            + "SSS3,SN016,Yewande Olufunmilayo,Math,8,8,35\n"
            + "SSS3,SN017,Taiwo Bosede,Math,4,9,56\n"
            + "SSS3,SN018,Dada Oluwasegun,Math,9,4,34\n";
  	
  	private static ArrayList<Student> parseCsvString(String csvString) {
        ArrayList<Student> results = new ArrayList<>();
        String[] lines = csvString.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] fields = lines[i].split(",");
            int ca1Score = Integer.parseInt(fields[4].trim());
            int ca2Score = Integer.parseInt(fields[5].trim());
            int examScore = Integer.parseInt(fields[6].trim());
            Student result = new Student(fields[0].trim(), fields[1].trim(), fields[2].trim(), fields[3].trim(), ca1Score, ca2Score, examScore);
            results.add(result);
        }
        return results;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      // Create an ArrayList to store the student objects
      
      ArrayList<Student> students = parseCsvString(CSV_DATA);

      System.out.println("Enter 1 to show result for a class");
      System.out.println("Enter 2 to show result for a student");

      int option = scanner.nextInt();
      
      if (option == 1){
        System.out.println("Enter the name of the class:");
        scanner.nextLine();
        String className = scanner.nextLine();

        ArrayList<Student> classStudents = new ArrayList<Student>();

        for(Student student : students){
          if (student.getClassname().equals(className)){
            classStudents.add(student);
          }
        }


        Collections.sort(classStudents, new Comparator<Student>(){
          public int compare( Student s1, Student s2){
            return s2.getTotal() - s1.getTotal();
          }
        });

        int position = 1;

        for (Student student : classStudents){
          student.setPosition(position++);
        }

        // Display the result
            System.out.println("Class,Student ID,Student Name,Subject,CA1 Score,CA2 Score,Exam Score,Total Score,Position");
            for (Student student : classStudents) {
                System.out.println(student.toString());
            }

      } else if(option == 2) {
        System.out.println("Enter the student ID: ");
        scanner.nextLine();
        String studentId = scanner.nextLine();

        Student student = null;
        for (Student s : students){
          if (s.getId().equals(studentId)){
            student = s;
            break;
          }
        }

        if (student == null){
          System.out.println("Student with ID " + studentId + " not found");
        } else{
          // Display the result
          System.out.println("Class,Student ID,Student Name,Subject,CA1 Score,CA2 Score,Exam Score,Total Score,Position");
          System.out.println(student.toString());
        }
      } else {
            System.out.println("Invalid operation");
        }

      scanner.close();
    }
}
