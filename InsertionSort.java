package Sorting;

public class InsertionSort {

    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
        int j;

        for(int i=1;i<arr.length;i++) {
            T tmp = arr[i];
            for(j=i;j>0 &&tmp.compareTo(arr[j-1])<0;j--)
                arr[j] = arr[j-1];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{345,2,8,45,223};
        insertionSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }




}
