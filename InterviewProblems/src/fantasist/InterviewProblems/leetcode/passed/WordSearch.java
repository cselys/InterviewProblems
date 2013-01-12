package fantasist.InterviewProblems.leetcode.passed;

public class WordSearch {

	int width, height;
	boolean[][] used;
	
	private boolean checkExist(char[][] board, int i, int j, String word, int pos) {
		if (pos == word.length())
			return true;
		if (i < 0 || i >= height || j < 0 || j >= width)
			return false;
		if (board[i][j] != word.charAt(pos) || used[i][j])
			return false;
		
		boolean res = false;
		used[i][j] = true;
		res = checkExist(board, i-1, j, word, pos+1) ||
				checkExist(board, i, j+1, word, pos+1) ||
				checkExist(board, i+1, j, word, pos+1) ||
				checkExist(board, i, j-1, word, pos+1);
		used[i][j] = false;
		return res;
	}
	
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
        	return false;
        
        width = board[0].length;
        height = board.length;
        used = new boolean[height][width];
        for (int i = 0; i < height; i++) {
        	for (int j = 0; j < width; j++) {
        		if (checkExist(board, i, j, word, 0))
        			return true;
        	}
        }
        return false;
    }
    
	public static void main(String[] args) {
	}

}
