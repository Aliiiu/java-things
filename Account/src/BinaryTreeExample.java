import java.util.Scanner;

public class BinaryTreeExample {
    public static void main(String[] args) {
        // create the Binary Tree
        TreeNode root = new TreeNode("start");
        root.left = new TreeNode("child");
        root.right = new TreeNode("steak");
        root.left.left = new TreeNode("movie");
        root.left.right = new TreeNode("menu");
        root.right.left = new TreeNode("map");
        root.right.right = new TreeNode("pizza");
        root.left.left.left = new TreeNode("steak");
        root.left.left.right = new TreeNode("child");
        root.left.right.left = new TreeNode("pizza");
        root.left.right.right = new TreeNode("steak");
        root.right.left.left = new TreeNode("start");
        root.right.left.right = new TreeNode("pizza");
        root.right.right.left = new TreeNode("menu");
        root.right.right.right = new TreeNode("steak");

        // ask the user to enter a word
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();

        // search for the word in the Binary Tree
        int count = countOccurrences(root, word);

        // output the result to the user
        if (count == 0) {
            System.out.println("The word does not exist in the Binary Tree.");
        } else {
            System.out.println("The word \"" + word + "\" occurs " + count + " time(s) in the Binary Tree.");
        }
    }

    public static int countOccurrences(TreeNode node, String word) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.value.equals(word)) {
            count++;
        }
        count += countOccurrences(node.left, word);
        count += countOccurrences(node.right, word);
        return count;
    }
}

class TreeNode {
    String value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String value) {
        this.value = value;
    }
}
