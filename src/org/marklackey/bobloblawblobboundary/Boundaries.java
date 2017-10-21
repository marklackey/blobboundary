package org.marklackey.bobloblawblobboundary;

public class Boundaries {
    int top;
    int bottom;
    int left;
    int right;

    public Boundaries(int size) {
        top = size - 1;
        bottom = 0;
        left = size - 1;
        right = 0;
    }

    @Override
    public String toString() {
        String value = "";
        value += "\n   Top: " + top;
        value += "\n  Left: " + left;
        value += "\nBottom: " + bottom;
        value += "\n Right: " + right;
        return value;
    }
}
