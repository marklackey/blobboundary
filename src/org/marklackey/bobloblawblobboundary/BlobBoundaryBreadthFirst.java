package org.marklackey.bobloblawblobboundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.marklackey.bobloblawblobboundary.Main.pln;

public class BlobBoundaryBreadthFirst {

    private Boundaries boundaries;

    private List<TableCell> cells;
    private final Random randomNumberGenerator = new Random();

    Boundaries solve(ListWithGetCounting<Boolean> input) {
        initialize(input);
        TableCell currentCell;
        int randomReads = 0;
        do {
            int currentIndex = randomNumberGenerator.nextInt(cells.size());
            currentCell = cells.get(currentIndex);
            randomReads++;
        } while (!currentCell.readExpensiveCellValue());
        pln("Random Reads:" + randomReads);
        currentCell.visit(boundaries);
        return boundaries;
    }

    private void initialize(ListWithGetCounting<Boolean> input) {
        boundaries = new Boundaries(input.size());
        if (!isValidInput(input)) {
            throw new IllegalArgumentException("Invalid Blob Definition.");
        }
        cells = new ArrayList<>();
        for (int index = 0; index < input.size(); index++) {
            cells.add(new TableCell(cells, input, index));
        }
    }

    /**
     * Does not provide thorough validation, only that we receive a square grid and it's not empty.
     *
     * @param input
     * @return
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
