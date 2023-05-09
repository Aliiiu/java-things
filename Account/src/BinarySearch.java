import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        // create the Binary Tree
        Node root = new Node("dog",
                new Node("cat",
                        new Node("bat"),
                        new Node("rat")),
                new Node("pig",
                        new Node("dog"),
                        new Node("cat",
                                new Node("bat"),
                                new Node("dog"))));

        // prompt the user to enter a word
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String word = input.nextLine();

        // search for the word in the Binary Tree
        int count = search(root, word);

        // output the number of occurrences of the word
        if (count == 0) {
            System.out.println("The word does not exist.");
        } else {
            System.out.printf("The word '%s' occurs %d time(s).\n", word, count);
        }
    }

    public static int search(Node node, String word) {
        if (node == null) {
            return 0;
        }
        int count = node.value.equals(word) ? 1 : 0;
        count += search(node.left, word);
        count += search(node.right, word);
        return count;
    }

    static class Node {
        String value;
        Node left, right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(String value) {
            this(value, null, null);
        }
    }
}
