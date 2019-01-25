package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SudokuChecker {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowHistories = new HashSet[9];
        Set<Character>[] colHistories = new HashSet[9];
        Set<Character>[] boxHistories = new HashSet[9];
        // initialize the histories
        for (int i = 0; i < 9; i++) {
            rowHistories[i] = new HashSet<>();
            colHistories[i] = new HashSet<>();
            boxHistories[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int boxHistoryIndex = (i/3)*3 + j/3;
                    Set<Character> rowHistory = rowHistories[i];
                    Set<Character> colHistory = colHistories[j];
                    Set<Character> boxHistory = boxHistories[boxHistoryIndex];
                    if (rowHistory.contains(num) || colHistory.contains(num) || boxHistory.contains(num)) {
                        return false;
                    } else {
                        rowHistory.add(num);
                        colHistory.add(num);
                        boxHistory.add(num);
                    }
                }
            }
        }
        return true;
    }
}
