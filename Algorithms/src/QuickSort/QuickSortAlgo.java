package QuickSort;

public class QuickSortAlgo {


    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int startIndex = start - 1;
        for (int currentIndex = start; currentIndex < end; currentIndex++) {
            if (arr[currentIndex] <= pivot) {
                startIndex++;
                int tempSmallerThanPivot = arr[startIndex];
                arr[startIndex] = arr[currentIndex];
                arr[currentIndex] = tempSmallerThanPivot;
            }
        }
        int swapTemp = arr[startIndex + 1];
        arr[startIndex + 1] = arr[end];
        arr[end] = swapTemp;


        return (startIndex + 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            quickSort(arr, start, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {81, 72, 47, 61, 52, 66};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
