package leetcode;

import java.util.HashSet;

public class SudokuCheckerTry2 {
    public boolean isValidSudoku(char[][] board) {
        return validateRows(board) && validateColumns(board) && validateBoxes(board);
    }

    private boolean validateRows(char[][] board) {
        for (int rowNum = 0; rowNum < 9; rowNum++) {
            HashSet<Character> rowHistory = new HashSet<>();
            char[] row = board[rowNum];
            for (char num : row) {
                if (num != '.') {
                    if (rowHistory.contains(num)) {
                        return false;
                    } else {
                        rowHistory.add(num);
                    }
                }
            }
        }
        return true;
    }

    private boolean validateColumns(char[][] board) {
        for (int colNum = 0; colNum < 9; colNum++) {
            HashSet<Character> colHistory = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char num = board[row][colNum];
                if (num != '.') {
                    if (colHistory.contains(num)) {
                        return false;
                    } else {
                        colHistory.add(num);
                    }
                }
            }
        }
        return true;
    }

    private boolean validateBoxes(char[][] board) {
        for (int boxNum = 0; boxNum < 9; boxNum++) {
            int boxNumRowStart = (boxNum / 3) * 3;
            int boxNumColStart = (boxNum % 3) * 3;
            HashSet<Character> boxHistory = new HashSet<>();
            for (int i = boxNumRowStart; i < 3; i++) {
                for (int j = boxNumColStart; j < 3; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        if (boxHistory.contains(num)) {
                            return false;
                        } else {
                            boxHistory.add(num);
                        }
                    }
                }
            }
        }
        return true;
    }

}
