import java.util.LinkedList;

public class BlobBoundary {
    public static void main(String[] args) {
        boolean[] row0 = {true, false, false};
        boolean[] row1 = {true, true, false};
        boolean[] row2 = {false, true, false};
        boolean[][] input = {row0, row1, row2};
        BlobBoundary bb = new BlobBoundary();
        bb.solve(input);
    }

    private void solve(boolean[][] input) {
        LinkedList<Position> boundary = new LinkedList<>();
        int reads = 0;
        int top = 0;
        int bottom = input.length - 1;
        int left = input[0].length - 1;
        int right = 0;
        for (int rowIdx = 0; rowIdx < input.length; rowIdx++) {
            boolean[] row = input[rowIdx];
            boolean foundBlobH = false;
            inner:
            for (int colIdx = 0; colIdx < row.length; colIdx++) {
                reads++;
                if (row[colIdx]) {
                    boundary.add(new Position(rowIdx, colIdx));
                    foundBlobH = true;
                    if (colIdx <= left) {
                        left = colIdx;
                    }
                    if (colIdx >= right) {
                        right = colIdx;
                    }
                } else if (foundBlobH) {
                    break inner;
                }
            }
            if (foundBlobH) {
                if (rowIdx <= bottom) {
                    bottom = rowIdx;
                }
                if (rowIdx >= top) {
                    top = rowIdx;
                }
            }
        }
        pln(" Reads: " + reads);
        pln("  Left: " + left);
        pln(" Right: " + right);
        pln("   Top: " + top);
        pln("Bottom: " + bottom);
    }

    private static void pln(String s) {
        System.out.println(s);
    }

    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return String.valueOf(String.format("%d,%d", this.row, this.col));
        }
    }
}
