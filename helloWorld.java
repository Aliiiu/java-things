class Person {
  String name;
  int age;

  void speak() {
    System.out.println("My name is: " + name + " and I am " + age + " years old");
  }
}
public class helloWorld{
  public static void main(String[] args) {
    Person person1 = new Person();
    person1.name = "Aliu Salaudeen";
    person1.age = 20;
    person1.speak();

  }
}