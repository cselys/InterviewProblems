package fantasist.InterviewProblems.other;

public class FlipPieces {

    char[][] board;
    boolean[][] visited;
    
    public FlipPieces(char[][] board) {
        this.board = board;
    }
    
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void flip() {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O' && DFS(i, j)) {
                    visited[i][j] = true;
                    flood(i, j);
                }
            }
        }
    }
    
    private boolean DFS(int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return false;
        boolean ans = true;
        if (!visited[x][y] && board[x][y] == 'O') {
            visited[x][y] = true;
            ans &= DFS(x+1, y);
            ans &= DFS(x-1, y);
            ans &= DFS(x, y+1);
            ans &= DFS(x, y-1);
        }
        return ans;
    }
    
    private void flood(int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length)
            return;
        if (board[x][y] == 'X')
            return;
        else {
            board[x][y] = 'X';
            flood(x-1, y);
            flood(x+1, y);
            flood(x, y+1);
            flood(x, y-1);
        }
    }
    
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X'}
        };
        
        FlipPieces f = new FlipPieces(board);
        f.printBoard();
        System.out.println();
        f.flip();
        f.printBoard();
    }

}
