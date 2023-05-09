import java.util.*;

public class MatchingWords {
    public static void main(String[] args) {
        // Create a HashSet of words from the dictionary
        Set<String> dictionary = new HashSet<>(Arrays.asList(
                "lake", "hair", "year", "road", "tale", "food", "map", "ear",
                "poet", "hall", "sir", "menu", "son", "art", "exam", "city",
                "ad", "goal", "gene", "way", "math", "dirt", "loss", "debt",
                "dad", "mall", "love", "fact", "town", "king", "oven", "song",
                "lady", "area", "mode", "girl", "gate", "bird", "poem", "mom",
                "news", "meat", "desk", "bath", "wife", "data", "wood", "unit",
                "idea", "lab"));

        // Prompt the user to input a string of letters
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string of letters: ");
        String input = scanner.nextLine().toLowerCase();

        // Create a HashMap to store the frequency of each letter in the input string
        Map<Character, Integer> letterCounts = new HashMap<>();
        for (char c : input.toCharArray()) {
            letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
        }

        // Find matching words and unused letters
        List<String> matchingWords = new ArrayList<>();
        for (String word : dictionary) {
            Map<Character, Integer> wordLetterCounts = new HashMap<>(letterCounts);
            boolean canFormWord = true;
            for (char c : word.toCharArray()) {
                if (!wordLetterCounts.containsKey(c) || wordLetterCounts.get(c) == 0) {
                    canFormWord = false;
                    break;
                } else {
                    wordLetterCounts.put(c, wordLetterCounts.get(c) - 1);
                }
            }
            if (canFormWord) {
                matchingWords.add(word);
                for (char c : word.toCharArray()) {
                    letterCounts.put(c, letterCounts.get(c) - 1);
                }
            }
        }
        StringBuilder unusedLetters = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : letterCounts.entrySet()) {
            unusedLetters.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }

        // Print the results
        System.out.println("Matching words are " + matchingWords + " unused letters are " + unusedLetters);
    }
}
