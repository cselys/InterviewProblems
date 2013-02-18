package fantasist.InterviewProblems.other;

public class QuickSort {
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    private static void _sort(int[] A, int start, int end) {
        if (start >= end)
            return;
        int pivot = A[end];
        int larger = end;
        for (int i = start; i < larger; i++) {
            if (A[i] > pivot) {
                swap(A, i, --larger);
                i--;
            }
        }
        if (larger < end)
            swap(A, larger, end);
        _sort(A, start, larger - 1);
        _sort(A, larger + 1, end);
    }
    
    public static void sort(int[] A) {
        if (A == null || A.length < 2)
            return;
        _sort(A, 0, A.length - 1);
    }
    
    public static void main(String[] args) {
        int[] A = {3, 4, 2, 3, 6, 1, 7, 1, 5};
        QuickSort.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i > 0)
                System.out.print(", ");
            System.out.print(A[i]);
        }
        System.out.println();
    }
}
