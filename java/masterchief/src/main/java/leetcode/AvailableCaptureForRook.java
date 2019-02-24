package leetcode;

public class AvailableCaptureForRook {
    public int numRookCaptures(char[][] board) {
        int rr = -1, rc = -1;
        // find rook position
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'R') {
                    rr = r;
                    rc = c;
                }
            }
        }

        // move up
        int pawnCount = 0;
        if (rr > 0) {
            for (int cr = rr - 1; cr >= 0; cr--) {
                if (board[cr][rc] == '.') {
                    continue;
                } else if (board[cr][rc] == 'B') {
                    break;
                } else if (board[cr][rc] == 'p') {
                    pawnCount++;
                    break;
                }

            }
        }
        // move down
        if (rr < board.length - 1) {
            for (int cr = rr + 1; cr < board.length; cr++) {
                if (board[cr][rc] == '.') {
                    continue;
                } else if (board[cr][rc] == 'B') {
                    break;
                } else if (board[cr][rc] == 'p') {
                    pawnCount++;
                    break;
                }
            }
        }
        // move left
        if (rc > 0) {
            for (int cc = rc - 1; cc >= 0; cc--) {
                if (board[rr][cc] == '.') {
                    continue;
                } else if (board[rr][cc] == 'B') {
                    break;
                } else if (board[rr][cc] == 'p') {
                    pawnCount++;
                    break;
                }
            }
        }
        // move right
        if (rc < board[0].length - 1) {
            for (int cc = rc + 1; cc < board[0].length; cc++) {
                if (board[rr][cc] == '.') {
                    continue;
                } else if (board[rr][cc] == 'B') {
                    break;
                } else if (board[rr][cc] == 'p') {
                    pawnCount++;
                    break;
                }
            }
        }
        return pawnCount;
    }
}
