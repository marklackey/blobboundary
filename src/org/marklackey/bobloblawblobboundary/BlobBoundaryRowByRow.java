package org.marklackey.bobloblawblobboundary;

class BlobBoundaryRowByRow {
    void solve(boolean[][] input) {

        int reads = 0;
        int top = input.length - 1;
        int bottom = 0;
        int left = input[0].length - 1;
        int right = 0;
        for (int rowIdx = 0; rowIdx < input.length; rowIdx++) {
            boolean[] row = input[rowIdx];
            boolean foundBlobH = false;
            inner:
            for (int colIdx = 0; colIdx < row.length; colIdx++) {
                reads++;
                if (row[colIdx]) {
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
                if (rowIdx <= top) {
                    top = rowIdx;
                }
                if (rowIdx >= bottom) {
                    bottom = rowIdx;
                }
            }
        }
        pln(" Reads: " + reads);
        pln("   Top: " + top);
        pln("  Left: " + left);
        pln("Bottom: " + bottom);
        pln(" Right: " + right);
    }

    private static void pln(String s) {
        System.out.println(s);
    }

}
