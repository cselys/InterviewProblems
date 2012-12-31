package fantasist.InterviewProblems.leetcode.passed;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1)
        	return 0;
        int[] buff1 = new int[n];
        int[] buff2 = new int[n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i == 0) {
        			buff2[j] = 1;
        		} else {
        			buff2[j] = buff1[j];
        			if (j > 0)
        				buff2[j] += buff2[j-1];
        		}
        	}
        	for (int j = 0; j < n; j++)
        		buff1[j] = buff2[j];
        }
        
        return buff1[n-1];
    }
    
	public static void main(String[] args) {
		
	}

}
