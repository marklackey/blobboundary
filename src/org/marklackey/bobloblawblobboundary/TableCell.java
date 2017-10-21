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
        if (!visited) {
            visited = true;
            if (cachedValue == null) {
                cachedValue = expensiveOperationToGetCellValue();
            }
        }
        if (cachedValue) {
            if ((index / dim) <= boundaries.top) {
                boundaries.top = index / dim;
            }
            if ((index / dim) >= boundaries.bottom) {
                boundaries.bottom = index / dim;
            }
            if ((index % dim) <= boundaries.left) {
                boundaries.left = index % dim;
            }
            if ((index % dim) >= boundaries.right) {
                boundaries.right = index % dim;
            }
            visitAdjacent(boundaries);
        }
    }

    private void visitAdjacent(Boundaries boundaries) {
        TableCell up = up();
        TableCell down = down();
        TableCell left = left();
        TableCell right = right();
        if (up != null && !up.isVisited()) {
            up.visit(boundaries);
        }
        if (down != null && !down.isVisited()) {
            down.visit(boundaries);
        }
        if (left != null && !left.isVisited()) {
            left.visit(boundaries);
        }
        if (right != null && !right.isVisited()) {
            right.visit(boundaries);
        }
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
        boolean isRightEdge = rightIndex() % dim == 0;
        return !isLastIndex && !isRightEdge ? cells.get(rightIndex()) : null;
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

    public boolean readExpensiveCellValue() {
        if (cachedValue == null) {
            cachedValue = expensiveOperationToGetCellValue();
        }
        return cachedValue;
    }

    private boolean expensiveOperationToGetCellValue() {
        return input.get(index);
    }

    private boolean isVisited() {
        return visited;
    }

}
