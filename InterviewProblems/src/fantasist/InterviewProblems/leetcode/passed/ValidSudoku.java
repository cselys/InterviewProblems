package fantasist.InterviewProblems.leetcode.passed;

public class ValidSudoku {

	private void reset(boolean[] check) {
		for (int i = 0; i < 9; i++)
			check[i] = false;
	}
    public boolean isValidSudoku(char[][] board) {
        boolean[] check1 = new boolean[9];
        boolean[] check2 = new boolean[9];
        for (int i = 0; i < 9; i++) {
        	reset(check1);
        	reset(check2);
        	for (int j = 0; j < 9; j++) {
        		char c = board[i][j];
        		if (c >= '1' && c <= '9') {
        			if (check1[c - '1'])
        				return false;
        			check1[c - '1'] = true;
        		}
        		
        		char c2 = board[j][i];
        		if (c2 >= '1' && c2 <= '9') {
        			if (check2[c2 - '1'])
        				return false;
        			check2[c2 - '1'] = true;
        		}
        	}
        }
        for (int i = 0; i < 9; i += 3) {
        	for (int j = 0; j < 9; j += 3) {
        		reset(check1);
        		for (int k = 0; k < 3; k++) {
        			for (int l = 0; l < 3; l++) {
		        		char c = board[i + k][j + l];
		        		if (c >= '1' && c <= '9') {
		        			if (check1[c - '1'])
		        				return false;
		        			check1[c - '1'] = true;
		        		}
        			}
        		}
        	}
        }
        
        return true;
    }

	public static void main(String[] args) {
		//String[] test = {".265...9.","5...79..4","3...1....","6.....8.7",".75.2..1.",".1....4..","...3.89.2","7...6..4.",".3.28.1.."};
		String[] test = {"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
		char[][] board = new char[9][];
		for (int i = 0; i < 9; i++) {
			board[i] = test[i].toCharArray();
			System.out.println(test[i]);
		}
		
		ValidSudoku v = new ValidSudoku();
		System.out.print(v.isValidSudoku(board) ? "True" : "False");
	}

}
