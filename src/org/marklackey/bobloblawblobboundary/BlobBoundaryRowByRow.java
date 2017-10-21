package org.marklackey.bobloblawblobboundary;

import static org.marklackey.bobloblawblobboundary.Main.println;

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
        println(" Reads: " + reads);
        println("   Top: " + top);
        println("  Left: " + left);
        println("Bottom: " + bottom);
        println(" Right: " + right);
    }


}
