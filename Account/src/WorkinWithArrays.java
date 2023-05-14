public class WorkinWithArrays {

    public static void main (String[] args){
        int[] arr = new int[10];
        System.out.printf("%s%8s%n", "Index", "Value");
        for (int counter = 0; counter < arr.length; counter++)
            System.out.printf("%5d%8d%n", counter, arr[counter]);
    }
}
