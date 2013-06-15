package com.seewhy.yfunctions.structure;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 21:30
 */
public class Tuple3<T0, T1, T2> {

    private T0 _0;
    private T1 _1;
    private T2 _2;

    public Tuple3(T0 _0, T1 _1, T2 _2) {
        this._0 = _0;
        this._1 = _1;
        this._2 = _2;
    }

    public T0 _0() {
        return _0;
    }

    public T1 _1() {
        return _1;
    }

    public T2 _2() {
        return _2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple3 tuple3 = (Tuple3) o;

        if (_0 != null ? !_0.equals(tuple3._0) : tuple3._0 != null) return false;
        if (_1 != null ? !_1.equals(tuple3._1) : tuple3._1 != null) return false;
        if (_2 != null ? !_2.equals(tuple3._2) : tuple3._2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _0 != null ? _0.hashCode() : 0;
        result = 31 * result + (_1 != null ? _1.hashCode() : 0);
        result = 31 * result + (_2 != null ? _2.hashCode() : 0);
        return result;
    }
}

