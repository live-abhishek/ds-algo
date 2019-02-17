package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        List<Set<Character>> rowHistories = getEmptyHistories();
        List<Set<Character>> colHistories = getEmptyHistories();
        List<Set<Character>> boxHistories = getEmptyHistories();
        initHistories(board, rowHistories, colHistories, boxHistories);
        fill(board, rowHistories, colHistories, boxHistories);
    }

    private boolean fill(char[][] board,
                           List<Set<Character>> rowHistories,
                           List<Set<Character>> colHistories,
                           List<Set<Character>> boxHistories) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char n = '1'; n <= '9'; n++) {
                        if (isValid(rowHistories, colHistories, boxHistories, n, r,c)){
                            board[r][c] = n;
                            addInHistories(rowHistories, colHistories, boxHistories, n, r, c);
                            boolean result = fill(board, rowHistories, colHistories, boxHistories);
                            if (result) {
                                return true;
                            }
                            board[r][c] = '.';
                            removeFromHistories(rowHistories, colHistories, boxHistories, n, r, c);
                        }
                    }
                    // couldn't find appropriate number for this cell
                    return false;
                }
            }
        }
        return true;
    }

    private List<Set<Character>> getEmptyHistories() {
        List<Set<Character>> histories = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            histories.add(new HashSet<>());
        }
        return histories;
    }

    private void initHistories(char[][] board,
                               List<Set<Character>> rowHistories,
                               List<Set<Character>> colHistories,
                               List<Set<Character>> boxHistories) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch != '.') {
                    rowHistories.get(r).add(ch);
                    colHistories.get(c).add(ch);
                    boxHistories.get(getBoxNum(r, c)).add(ch);
                }
            }
        }
    }

    private boolean isValid(List<Set<Character>> rowHistories,
                            List<Set<Character>> colHistories,
                            List<Set<Character>> boxHistories,
                            char ch, int row, int col) {
        return !rowHistories.get(row).contains(ch)
                && !colHistories.get(col).contains(ch)
                && !boxHistories.get(getBoxNum(row, col)).contains(ch);
    }

    private void addInHistories(List<Set<Character>> rowHistories,
                                List<Set<Character>> colHistories,
                                List<Set<Character>> boxHistories,
                                char ch, int row, int col) {
        rowHistories.get(row).add(ch);
        colHistories.get(col).add(ch);
        boxHistories.get(getBoxNum(row, col)).add(ch);
    }

    private void removeFromHistories(List<Set<Character>> rowHistories,
                                List<Set<Character>> colHistories,
                                List<Set<Character>> boxHistories,
                                char ch, int row, int col) {
        rowHistories.get(row).remove(ch);
        colHistories.get(col).remove(ch);
        boxHistories.get(getBoxNum(row, col)).remove(ch);
    }

    private int getBoxNum(int row, int col) {
        return 3*(row/3) + col/3;
    }
}
