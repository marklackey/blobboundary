package org.marklackey.bobloblawblobboundary;

import java.util.ArrayList;

public class ListWithGetCounting<E> extends ArrayList<E> {

    private int getCount;

    @Override
    public E get(int index) {
        getCount++;
        return super.get(index);
    }

    public int getGetCount() {
        return getCount;
    }
}
