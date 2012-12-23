package fantasist.InterviewProblems.leetcode.passed;


public class NQueensII {
	int n;
	boolean[] orth, diag;
	int[] selection;
	int count;
	
	private void put(int level) {
		if (level == n) {
			count++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (orth[i] == false && orth[level+n] == false
				&& diag[i+level] == false && diag[i-level + 3*n] == false) {
				orth[i] = true;
				orth[n+level] = true;
				diag[i+level] = true;
				diag[i-level + 3*n] = true;
				selection[level] = i;
				put(level+1);
				orth[i] = false;
				orth[n+level] = false;
				diag[i+level] = false;
				diag[i-level + 3*n] = false;
			}
		}
	}
	
    public int totalNQueens(int n) {
        if (n < 1)
        	return 0;
        
        orth = new boolean[2 * n];
        diag = new boolean[4 * n];
        selection = new int[n];
        this.n = n;
        count = 0;
        
        put(0);
        return count;
    }
    
	public static void main(String[] args) {
		NQueensII nq = new NQueensII();
		System.out.println(nq.totalNQueens(8));
	}

}
