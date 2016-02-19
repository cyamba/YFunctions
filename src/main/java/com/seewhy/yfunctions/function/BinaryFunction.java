package com.seewhy.yfunctions.function;

/**
 * @author cbyamba
 *         Date: 2013-06-18
 *         Time: 19:50
 */
public interface BinaryFunction<T, U, V> {

    V apply(T t, U u);
}
