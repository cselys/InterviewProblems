package fantasist.InterviewProblems.leetcode.passed;

public class UniqueBST {

    public int numTrees(int n) {
        if (n < 2)
            return 1;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                cache[i] += cache[j] * cache[i - j - 1];
            }
        }
        int result = 0;
        for (int i = 1; i <= n; i++)
            result += cache[i - 1] * cache[n - i];
            
        return result;
    }
    
    public static void main(String[] args) {
        UniqueBST u = new UniqueBST();
        System.out.println(u.numTrees(1));
        System.out.println(u.numTrees(2));
        System.out.println(u.numTrees(3));
    }

}
