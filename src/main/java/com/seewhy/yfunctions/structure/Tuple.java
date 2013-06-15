package com.seewhy.yfunctions.structure;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 20:08
 */
public class Tuple<S, T> {

    private S first;
    private T second;

    public Tuple(S first, T second) {
        this.first = first;
        this.second = second;
    }

    public S getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("(").append(first).append(",").append(second).append(")").toString();
    }
}
