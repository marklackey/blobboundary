package org.marklackey.bobloblawblobboundary;

import com.google.common.collect.Lists;

public class Main {
    public static void main(String[] args) {
        boolean[] row0 = {false, false, false};
        boolean[] row1 = {true, true, false};
        boolean[] row2 = {false, false, false};
        boolean[][] inputArray = {row0, row1, row2};

        BlobBoundaryRowByRow bbRR = new BlobBoundaryRowByRow();
        bbRR.solve(inputArray);

        ListWithGetCounting<Boolean> input = new ListWithGetCounting<>();
        input.addAll(Lists.newArrayList(
            false, false, false, true, true, false, false, false, false));
        Boundaries boundaries = new BlobBoundaryBreadthFirst().solve(input);
        println("Results for input: false, false, false, true, true, false, false, false, false\n");
        println("Cell Reads: " + input.getGetCount());
        println(boundaries);

        String inputStr =
            "0000000000 0011100000 0011111000 0010001000 0011111000" +
                "0000101000 0000101000 0000111000 0000000000 0000000000";
        input.clear();
        for (int index = 0; index < inputStr.length(); index++) {
            if (inputStr.charAt(index) == '0') {
                input.add(false);
            } else if (inputStr.charAt(index) == '1') {
                input.add(true);
            }
        }
        println("\nResults for input:" + inputStr + "\n");
        boundaries = new BlobBoundaryBreadthFirst().solve(input);
        println("Cell Reads: " + input.getGetCount());
        println(boundaries);
    }

    public static void println(Object value) {
        System.out.println(value);
    }

    public static void println(int value) {
        System.out.println(value);
    }
}
