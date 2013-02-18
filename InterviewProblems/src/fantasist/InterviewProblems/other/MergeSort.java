package fantasist.InterviewProblems.other;

import java.util.Arrays;

public class MergeSort {
    
    private static void _sort(int[] A, int start, int end) {
        if (end - start < 1)
            return;
        
        int mid = (start + end) / 2;
        _sort(A, start, mid);
        _sort(A, mid + 1, end);
        
        int[] temp = Arrays.copyOfRange(A, start, end + 1);
        int idxA = 0, idxB = mid - start + 1;
        for (int i = start; i <= end; i++) {
            if (idxA + start <= mid && idxB + start <= end) {
                if (temp[idxA] <= temp[idxB])
                    A[i] = temp[idxA++];
                else
                    A[i] = temp[idxB++];
            } else if (idxA + start > mid) {
                A[i] = temp[idxB++];
            } else {
                A[i] = temp[idxA++];
            }
        }
    }
    
    public static void sort(int[] A) {
        if (A == null || A.length < 2)
            return ;
        
        _sort(A, 0, A.length - 1);
    }
    
    public static void main(String[] args) {
//        int[] A = {4, 2};
        int[] A = {3, 4, 2, 3, 6, 1, 7, 1, 5};
        MergeSort.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (i > 0)
                System.out.print(", ");
            System.out.print(A[i]);
        }
        System.out.println();
    }

}
