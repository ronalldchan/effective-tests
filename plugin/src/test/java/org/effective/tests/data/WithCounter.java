package org.effective.tests.data;

public class WithCounter {
    private int counter;
    public int incrementCounter() {
        counter = counter + 1;
        return counter;
    }
}

