package fantasist.InterviewProblems.leetcode.passed;

public class JumpGameII {
    
    public int jump(int[] A) {
        if (A == null || A.length < 2)
            return 0;
        int hops = 0, max = A[0], cur = A[0];
        for (int i = 0; i <= cur; i++) {
            if (max >= A.length - 1)
                return max > cur ? hops+2 : hops+1;
            if (A[i] + i > max)
                max = A[i] + i;
            if (i == cur) {
                hops++;
                cur = max;
            }
        }
        return hops;
    }
    
    public static void main(String[] args) {
        JumpGameII j = new JumpGameII();
        int[] A = {2,3,1,1,4};
        System.out.println(j.jump(A));
    }

}
