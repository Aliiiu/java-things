public class QuickSort {
  public static void quickSort(int[] arr, int left, int right){
    if (left < right){
      int pivotIndex = partition(arr, left, right);
      quickSort(arr, left, pivotIndex - 1);
      quickSort(arr, pivotIndex + 1, right);
    }
  }
  
  public static int partition(int[] arr, int left, int right){
    int pivotValue = arr[right];
    int pivotIndex = left;
    
    for (int i = left; i < right; i++){
      if (arr[i] < pivotValue){
        swap(arr, i, pivotIndex);
        pivotIndex++;
      }
    }
    swap(arr, right, pivotIndex);
    return pivotIndex;
  }


  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {9, -3, 5, 2, 6, 8, -6, 1, 3};

    System.out.println("Before sorting:");
    for (int num : arr) {
      System.out.print(num + " ");
    }

    quickSort(arr, 0, arr.length - 1);

    System.out.println("\nAfter sorting:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
    
  }
}
