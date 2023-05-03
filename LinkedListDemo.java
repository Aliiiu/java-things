public class LinkedListDemo {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    list.insertAtHead(6);
    list.insertAtHead(7);
    list.insertAtHead(8);
    list.insertAtHead(9);
    list.insertAtHead(5);
    list.insertAtHead(10);

    System.out.println(list);
    System.out.println("Length: " + list.length());
  }
}
