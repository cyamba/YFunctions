package com.seewhy.yfunctions.structure;

import static java.util.Arrays.asList;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 21:30
 */
public class Tuple7<T0, T1, T2, T3, T4, T5, T6> {

    private T0 _0;
    private T1 _1;
    private T2 _2;
    private T3 _3;
    private T4 _4;
    private T5 _5;
    private T6 _6;

    public Tuple7(T0 _0, T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6) {
        this._0 = _0;
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
        this._5 = _5;
        this._6 = _6;
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

    public T3 _3() {
        return _3;
    }

    public T4 _4() {
        return _4;
    }

    public T5 _5() {
        return _5;
    }

    public T6 _6() {
        return _6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple7 tuple7 = (Tuple7) o;

        if (_0 != null ? !_0.equals(tuple7._0) : tuple7._0 != null) return false;
        if (_1 != null ? !_1.equals(tuple7._1) : tuple7._1 != null) return false;
        if (_2 != null ? !_2.equals(tuple7._2) : tuple7._2 != null) return false;
        if (_3 != null ? !_3.equals(tuple7._3) : tuple7._3 != null) return false;
        if (_4 != null ? !_4.equals(tuple7._4) : tuple7._4 != null) return false;
        if (_5 != null ? !_5.equals(tuple7._5) : tuple7._5 != null) return false;
        if (_6 != null ? !_6.equals(tuple7._6) : tuple7._6 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _0 != null ? _0.hashCode() : 0;
        result = 31 * result + (_1 != null ? _1.hashCode() : 0);
        result = 31 * result + (_2 != null ? _2.hashCode() : 0);
        result = 31 * result + (_3 != null ? _3.hashCode() : 0);
        result = 31 * result + (_4 != null ? _4.hashCode() : 0);
        result = 31 * result + (_5 != null ? _5.hashCode() : 0);
        result = 31 * result + (_6 != null ? _6.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return asList(_0, _1, _2, _3, _4, _5, _6).toString();
    }
}