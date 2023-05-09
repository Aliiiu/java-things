import java.util.*;

public class WordCloud {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter one or more paragraphs of text:");
        String input = scanner.nextLine();

        Map<String, Integer> wordCounts = new HashMap<>();
        String[] words = input.split("[^a-zA-Z']+"); // split on non-alphabetic characters
        for (String word : words) {
            word = word.toLowerCase();
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCounts.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed()); // sort by value in descending order
        System.out.println("--------------------------");
        System.out.println("| Word      |  Count     |");
        System.out.println("--------------------------");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.printf("| %-10s| %-10d |%n", entry.getKey(), entry.getValue());
            System.out.println("--------------------------");
        }
    }
}



