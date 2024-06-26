package Sorting;

public class HeapSort {
    private static int leftChild(int i) {
        return 2*i + 1;
    }

    private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] a, int i, int n) {
        int child;
        AnyType tmp;
        for(tmp = a[i];leftChild(i) < n; i=child) {
            child = leftChild(i);
            if(child != n-1 && a[child].compareTo(a[child+1])<0)
                child++;
            if(tmp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    public static <AnyType extends Comparable<? super AnyType>> void heapSort(AnyType[] a) {
        for(int i=a.length/2-1;i>=0;i--)
            percDown(a,i,a.length);
        for(int i=a.length-1;i>0;i--) {
            swapReferences( a, 0, i );
            percDown(a,0,i);
        }
    }

    private static <AnyType> void swapReferences(AnyType[] a, int i, int j) {
        AnyType tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = {134,23,11,666,123,15,88,76,1,32};
        heapSort(arr);

        for(Integer a:arr) {
            System.out.println(a);
        }
    }
}
