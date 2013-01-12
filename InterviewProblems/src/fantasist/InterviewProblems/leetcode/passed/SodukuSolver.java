package fantasist.InterviewProblems.leetcode.passed;


public class SodukuSolver {

	char[][] board;
	
	private boolean checkValid(int x, int y) {
		boolean[] row = new boolean[9];
		boolean[] col = new boolean[9];
		for (int i = 0; i < 9; i++) {
			char rowChar = board[x][i];
			char colChar = board[i][y];
			if (rowChar != '.') {
				if (row[rowChar - '1'])
					return false;
				else
					row[rowChar - '1'] = true;
			}
			
			if (colChar != '.') {
				if (col[colChar - '1'])
					return false;
				else
					col[colChar - '1'] = true;
			}
		}
		
		for (int i = 0; i < 9; i++)
			row[i] = false;
		
		x = (x / 3) * 3;
		y = (y / 3) * 3;
		for (int k = 0; k < 9; k++) {
			char blockChar = board[x + (k/3)][y + (k%3)];
			if (blockChar != '.') {
				if (row[blockChar - '1'])
					return false;
				else
					row[blockChar - '1'] = true;
			}
		}
		
		return true;
	}
	
	private boolean solve(int x, int y) {
		if (x > 8)
			return true;
		if (board[x][y] != '.') {
			return solve((y == 8 ? (x+1) : x), (y == 8 ? 0 : (y+1)));
		} else {
			for (int i = 0; i < 9; i++) {
				board[x][y] = (char) ('1' + i);
				if (checkValid(x, y) && solve((y == 8 ? (x+1) : x), (y == 8 ? 0 : (y+1))))
					return true;
				board[x][y] = '.';
			}
			return false;
		}
	}
	
    public void solveSudoku(char[][] board) {
    	this.board = board;
    	solve(0, 0);
    }
    
	public static void main(String[] args) {
		String[] test = {"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
		char[][] board = new char[9][];
		for (int i = 0; i < 9; i++) {
			board[i] = test[i].toCharArray();
		}

		SodukuSolver v = new SodukuSolver();
		v.printBoard(board);
		
		v.solveSudoku(board);
		v.printBoard(board);
	}

	private void printBoard(char[][] b) {
		for (int i = 0; i < 9; i++) {
			String line = String.copyValueOf(b[i]);
			System.out.println(line);
		}
		
		System.out.println();
	}
}
