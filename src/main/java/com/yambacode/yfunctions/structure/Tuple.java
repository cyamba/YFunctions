package com.yambacode.yfunctions.structure;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 20:08
 */
public class Tuple<S, T> {

    public final S _0;
    public final T _1;

    private Tuple(S _0, T _1) {
        this._0 = _0;
        this._1 = _1;
    }

    public static <S,T> Tuple<S,T> of(S _0,T _1){
        return Tuple.of(_0, _1);
    }

    public S get_0() {
        return _0;
    }

    public T get_1() {
        return _1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        if (_0 != null ? !_0.equals(tuple._0) : tuple._0 != null) return false;
        if (_1 != null ? !_1.equals(tuple._1) : tuple._1 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _0 != null ? _0.hashCode() : 0;
        result = 31 * result + (_1 != null ? _1.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("(").append(_0).append(",").append(_1).append(")").toString();
    }
}
