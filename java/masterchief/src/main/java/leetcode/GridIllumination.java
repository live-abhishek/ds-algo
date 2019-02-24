package leetcode;

public class GridIllumination {
    enum CellState{
        notPresent, on, off
    }

    static class Cell {
        int power = 0;
        CellState state;
        Cell(){
            state = CellState.notPresent;
        }
    }

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Cell[][] cells = new Cell[N][N];
        // init cells
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                cells[r][c] = new Cell();
            }
        }
        int[][] dirs = {{-1,-1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {-1,-1}, {-1,0}};
        // turn lamp cells on and set power in corresponding cells
        for (int[] lamp : lamps) {
            int lampRow = lamp[0];
            int lampCol = lamp[1];
            cells[lampRow][lampCol].state = CellState.on;
            cells[lampRow][lampCol].power += 1;
            for (int[] dir : dirs) {
                int newRow = lampRow + dir[0];
                int newCol = lampCol + dir[1];
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                    cells[newRow][newCol].power += 1;
                }
            }
        }
        int[] output = new int[queries.length];
        for (int i = 0; i< queries.length; i++) {
            int[] query = queries[i];
            int qr = query[0];
            int qc = query[1];
            if (cells[qr][qc].power > 0) {
                output[i] = 1;
            }
            cells[qr][qc].power -= 1;
            if (cells[qr][qc].state == CellState.on) {
                cells[qr][qc].state = CellState.off;

            }

            if (cells[qr][qc].state == CellState.on) {
                cells[qr][qc].state = CellState.off;
                changeState(cells, qr, qc, N);
            }
            if (qr > 0 && cells[qr - 1][qc].state == CellState.on) {
                cells[qr - 1][qc].state = CellState.off;
                changeState(cells, qr - 1, qc, N);
            }
            if (qr < N - 1 && cells[qr + 1][qc].state == CellState.on) {
                cells[qr + 1][qc].state = CellState.off;
                changeState(cells, qr + 1, qc, N);
            }
            if (qc > 0 && cells[qr][qc - 1].state == CellState.on) {
                cells[qr][qc - 1].state = CellState.off;
                changeState(cells, qr, qc - 1, N);
            }
            if (qc < N - 1 && cells[qr][qc + 1].state == CellState.on) {
                cells[qr][qc + 1].state = CellState.off;
                changeState(cells, qr, qc + 1, N);
            }
            if (qr > 0 && qc > 0 && cells[qr-1][qc-1].state == CellState.on) {
                cells[qr - 1][qc - 1].state = CellState.off;
                changeState(cells, qr-1, qc-1, N);
            }
            if (qr > 0 && qc < N - 1 && cells[qr - 1][qc + 1].state == CellState.on) {
                cells[qr - 1][qc + 1].state = CellState.off;
                changeState(cells, qr - 1, qc + 1, N);
            }
            if (qr < N - 1 && qc > 0 && cells[qr + 1][qc - 1].state == CellState.on) {
                cells[qr + 1][qc - 1].state = CellState.off;
                changeState(cells, qr + 1, qc - 1, N);
            }
            if (qr < N - 1 && qc < N - 1 && cells[qr + 1][qc + 1].state == CellState.on) {
                cells[qr + 1][qc + 1].state = CellState.off;
                changeState(cells, qr + 1, qc + 1, N);
            }
        }
        return output;
    }

    private void changeState(Cell[][] cells, int lampRow, int lampCol, int N) {
        int[][] dirs = {{-1,-1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {-1,-1}, {-1,0}};

        if (lampRow > 0) {
            for (int cr = lampRow - 1; cr >= 0; cr--) {
                cells[cr][lampCol].power -= 1;
            }
        }
        if (lampRow < N - 1) {
            for (int cr = lampRow + 1; cr < N; cr++) {
                cells[cr][lampCol].power -= 1;
            }
        }
        if (lampCol > 0) {
            for (int cc = lampCol - 1; cc >= 0; cc--) {
                cells[lampRow][cc].power -= 1;
            }
        }
        if (lampCol < N - 1) {
            for (int cc = lampCol + 1; cc < N; cc++) {
                cells[lampRow][cc].power -= 1;
            }
        }
        if (lampRow > 0 && lampCol > 0) {
            for (int cr = lampRow - 1, cc = lampCol - 1; cr >= 0 && cc >= 0; cr--, cc--) {
                cells[cr][cc].power -= 1;
            }
        }
        if (lampRow > 0 && lampCol < N - 1) {
            for (int cr = lampCol - 1, cc = lampCol + 1; cr >= 0 && cc < N; cr--, cc++) {
                cells[cr][cc].power -= 1;
            }
        }
        if (lampRow < N - 1 && lampCol > 0) {
            for (int cr = lampRow + 1, cc = lampCol - 1; cr < N && cc >= 0; cr++, cc--) {
                cells[cr][cc].power -= 1;
            }
        }
        if (lampRow < N - 1 && lampCol < N-1) {
            for (int cr = lampRow + 1, cc = lampCol + 1; cr < N && cc < N; cr++, cc++) {
                cells[cr][cc].power -= 1;
            }
        }
    }
}
