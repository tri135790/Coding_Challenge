package leetcode75.level1;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet();
        for (int i = 0; i < 9; i ++) {
            for (int j =0; j < 9; j++) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!set.add(b + i) || !set.add(j + b) || !set.add(j/3 + b + i/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
