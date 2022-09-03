package leetcode75.level1;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtrack(board, word, i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word,int row, int col, int count) {


        if (board[row][col] == word.charAt(count)) {
            if (count == word.length()-1) {
                return true;
            }

            boolean bool1 = false ,bool2 = false,bool3 = false,bool4= false;
            board[row][col] = '0';
            if (col < board[row].length - 1) {
                bool1 = backtrack(board,word,row, col +1, count+1);
            }
            if (col > 0) {
                bool2 = backtrack(board,word,row, col -1, count+1);
            }

            if (row > 0) {
                bool3 = backtrack(board,word,row - 1, col, count+1);
            }

            if (row < board.length - 1) {
                bool4 = backtrack(board,word,row + 1, col, count+1);
            }

            if (bool1 || bool2 || bool3 || bool4) return true;
            board[row][col] = word.charAt(count);
        }
        return false;
    }
}
