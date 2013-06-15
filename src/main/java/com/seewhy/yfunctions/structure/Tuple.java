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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        if (first != null ? !first.equals(tuple.first) : tuple.first != null) return false;
        if (second != null ? !second.equals(tuple.second) : tuple.second != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
