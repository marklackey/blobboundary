package org.marklackey.bobloblawblobboundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlobBoundaryBreadthFirst {

    private Boundaries boundaries;
    private List<TableCell> cells;

    Boundaries solve(ListWithGetCounting<Boolean> input) {
        initialize(input);
        TableCell startingCell = findAnOccupiedCell();
        startingCell.visit(boundaries);
        return boundaries;
    }

    private TableCell findAnOccupiedCell() {
        TableCell currentCell;
        int randomReadCnt = 0;
        boolean occupied;
        Random randomNumberGenerator = new Random();
        do {
            currentCell = randomCell(randomNumberGenerator);
            occupied = currentCell.readExpensiveCellValue();
            randomReadCnt++;
        } while (!occupied);
        Main.println("Random Reads:" + randomReadCnt);
        return currentCell;
    }

    private TableCell randomCell(Random randomNumberGenerator) {
        int currentIndex = randomNumberGenerator.nextInt(cells.size());
        return cells.get(currentIndex);
    }

    private void initialize(ListWithGetCounting<Boolean> input) {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("Invalid Blob Definition.");
        }
        boundaries = new Boundaries(input.size());
        cells = new ArrayList<>();
        for (int index = 0; index < input.size(); index++) {
            cells.add(new TableCell(cells, input, index));
        }
    }

    /*
     * Does not provide thorough validation, only that we receive a square grid and it's not empty.
     * If it were empty, we'd have to modify our algorithm to find an initial cell of the blob.
     */
    private boolean isValidInput(List<Boolean> input) {
        return isValidSize(input) && isNotEmpty(input);
    }

    private boolean isNotEmpty(List<Boolean> input) {
        return input.stream().anyMatch(Boolean::booleanValue);
    }

    private boolean isValidSize(List cells) {
        double sqrt = Math.sqrt(cells.size());
        double sqrtIntEquivalent = Math.floor(sqrt);
        return sqrt == sqrtIntEquivalent;
    }

}
