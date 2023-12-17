package Sorting;

public class MergeSort {
    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a, AnyType[] tmpArray,
                                                                            int leftPos,int rightPos,int rightEnd) {
        int leftEnd = rightPos -1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftEnd +1;

        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if(a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        while(leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while(rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }
        for(int i=0;i<numElements;i++,rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
        //12
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
        for(int i=0;i<intArray.length;i++) {
            System.out.println(intArray[i]);
        }
    }

    /*public static void mergeSort(int[] array) {
        int n = array.length;
        if(n > 1) {
            int mid = n/2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[n-mid];

            System.arraycopy(array, 0, leftArray, 0, mid);
            System.arraycopy(array, mid, rightArray, 0, n - mid);

            // Recursively sort the two halves
            mergeSort(leftArray);
            mergeSort(rightArray);

            // Merge the sorted halves
            merge(array, leftArray, rightArray);
        }
    }

    public static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int i = 0, j = 0, k = 0;
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }*/
}
