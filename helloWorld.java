import java.util.Scanner;

public class helloWorld{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter a command: ");
    String value = input.nextLine();
    switch(value){
      case "start":
        System.out.println("Machine started!");
        break;
      case "stop":
        System.out.println("Machine Stopped");
        break;
      default:
        System.out.println("Command not found");
    }

  }
}