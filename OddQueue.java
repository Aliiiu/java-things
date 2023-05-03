import java.util.LinkedList;
import java.util.Queue;

public class OddQueue {
   public static void generate(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        while (n-- > 0) {
            String s = queue.poll();
            if (Integer.parseInt(s, 2) % 2 != 0){
              System.out.print(s + " ");
            }

            queue.add(s + "0");
            queue.add(s + "1");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        generate(n);
    }
}
