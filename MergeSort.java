package Sorting;

public class MergeSort {
    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a, AnyType[] tmpArray,
                                                                            int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        // Copy remaining elements from left subarray to temporary array
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }

        // Copy remaining elements from right subarray to temporary array
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        // Copy the sorted elements back to the original array
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }


    private static <AnyType extends Comparable<?super AnyType>> void mergeSort(AnyType[] a,AnyType[] tmpArray,
                                                                               int left, int right) {
        if(left < right) {
            int center = (left+right) / 2;
            mergeSort(a,tmpArray,left,center);
            mergeSort(a,tmpArray,center+1,right);
            merge(a,tmpArray,left,center+1,right);
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a) {
        AnyType[] tmpArray = (AnyType[]) new Comparable[a.length];
        mergeSort(a,tmpArray,0,a.length-1);
    }

    public static void main(String[] args) {
        Integer[] intArray = {123,342,125,23,66,34,1234543,5,9,27};
        mergeSort(intArray);
        for(Integer a:intArray) {
            System.out.println(a);
        }
    }
}
