package fantasist.InterviewProblems.leetcode.passed;

import java.util.ArrayList;

public class NQueens {

	int n;
	boolean[] orth, diag;
	int[] selection;
	
	private void put(ArrayList<String[]> res, int level) {
		if (level == n) {
			String[] sol = new String[n];
			for (int i = 0; i < n; i++) {
				char[] line = new char[n];
				for (int j = 0; j < n; j++) {
					if (j == selection[i])
						line[j] = 'Q';
					else
						line[j] = '.';
				}
				sol[i] = String.copyValueOf(line);
			}
			res.add(sol);
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
				put(res, level+1);
				orth[i] = false;
				orth[n+level] = false;
				diag[i+level] = false;
				diag[i-level + 3*n] = false;
			}
		}
	}
	
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        if (n < 1)
        	return result;
        
        orth = new boolean[2 * n];
        diag = new boolean[4 * n];
        selection = new int[n];
        this.n = n;
        
        put(result, 0);
        
        return result;
    }
    
	public static void main(String[] args) {
		NQueens nq = new NQueens();
		
		ArrayList<String[]> result = nq.solveNQueens(8);
		for (int i = 0; i < result.size(); i++) {
			String[] sol = result.get(i);
			for (int j = 0; j < sol.length; j++) {
				System.out.println(sol[j]);
			}
			System.out.println();
		}
	}

}
