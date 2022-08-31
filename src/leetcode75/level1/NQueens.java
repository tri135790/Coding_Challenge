package leetcode75.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        backtrack(board, 0, res);
        return  res;
    }



    private void backtrack(char[][] board, int col, List<List<String>> res) {

        if (col == board.length) {
            res.add(construct(board));
        }

        for (int i = 0; i < board.length; i++) {
            if (isValidate(board,i,col)) {
                board[i][col] = 'Q';
                backtrack(board, col+1, res);
                board[i][col] = '.';
            }
        }
    }

    private boolean isValidate(char[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        for (int i = row, j =col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row, j =col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i =0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}
