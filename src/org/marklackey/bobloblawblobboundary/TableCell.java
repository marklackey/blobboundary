package org.marklackey.bobloblawblobboundary;

import java.util.List;

class TableCell {
    private final List<TableCell> cells;
    private final int dim;
    private final int index;
    private final ListWithGetCounting<Boolean> input;
    private final int listSize;
    private Boolean cachedValue;
    private boolean visited;

    TableCell(List<TableCell> cells, ListWithGetCounting<Boolean> input, int index) {
        this.cells = cells;
        this.index = index;
        this.input = input;
        this.listSize = input.size();
        this.dim = (int) Math.sqrt(this.listSize);
    }

    void visit(Boundaries boundaries) {
        visited = true;
        if (cachedValue == null) {
            cachedValue = expensiveOperationToGetCellValue();
        }
        if (cachedValue) {
            updateBoundaryValues(boundaries);
            visitAdjacent(boundaries);
        }
    }

    public boolean readExpensiveCellValue() {
        if (cachedValue == null) { //currently unnecessary logic, but good in principle
            cachedValue = expensiveOperationToGetCellValue();
        }
        return cachedValue;
    }

    //This method is not actually expensive, but it's named like this to remind us of our objectives in this exercise
    private boolean expensiveOperationToGetCellValue() {
        return input.get(index);
    }

    private void updateBoundaryValues(Boundaries boundaries) {
        if (row() <= boundaries.top) {
            boundaries.top = index / dim;
        }
        if (row() >= boundaries.bottom) {
            boundaries.bottom = index / dim;
        }
        if (column() <= boundaries.left) {
            boundaries.left = index % dim;
        }
        if (column() >= boundaries.right) {
            boundaries.right = index % dim;
        }
    }

    private void visitAdjacent(Boundaries boundaries) {
        TableCell up = up();
        TableCell down = down();
        TableCell left = left();
        TableCell right = right();
        if (shouldVisit(up)) {
            up.visit(boundaries);
        }
        if (shouldVisit(down)) {
            down.visit(boundaries);
        }
        if (shouldVisit(left)) {
            left.visit(boundaries);
        }
        if (shouldVisit(right)) {
            right.visit(boundaries);
        }
    }

    private boolean shouldVisit(TableCell tableCell) {
        return tableCell != null && !tableCell.isVisited();
    }

    private TableCell up() {
        int upIndex = upIndex();
        return upIndex >= 0 ? cells.get(upIndex) : null;
    }

    private TableCell down() {
        int downIndex = downIndex();
        return downIndex < listSize ? cells.get(downIndex()) : null;
    }

    private TableCell left() {
        boolean isFirstIndex = index == 0;
        boolean isLeftEdge = index % dim == 0;
        return !isFirstIndex && !isLeftEdge ? cells.get(leftIndex()) : null;
    }

    private TableCell right() {
        boolean isLastIndex = index == (listSize - 1);
        boolean isRightEdge = (rightIndex() % dim) == 0;
        return (!isLastIndex && !isRightEdge) ? cells.get(rightIndex()) : null;
    }

    private int upIndex() {
        return index - dim;
    }

    private int downIndex() {
        return index + dim;
    }

    private int leftIndex() {
        return index - 1;
    }

    private int rightIndex() {
        return index + 1;
    }

    private boolean isVisited() {
        return visited;
    }

    private int row() {
        return index / dim;
    }

    private int column() {
        return index % dim;
    }

}
