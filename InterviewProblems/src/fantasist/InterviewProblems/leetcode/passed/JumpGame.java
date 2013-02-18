package fantasist.InterviewProblems.leetcode.passed;

public class JumpGame {

    public boolean canJump(int[] A) {
        if (A == null || A.length < 2)
            return true;
        int farest = A[0];
        for (int i = 1; i <= farest; i++) {
            if (farest >= A.length - 1)
                return true;
            if (A[i] + i > farest)
                farest = A[i] + i;
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0};
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(A));
    }

}
