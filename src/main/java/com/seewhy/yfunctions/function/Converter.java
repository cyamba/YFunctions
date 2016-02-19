package com.seewhy.yfunctions.function;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 20:02
 */
public interface Converter<S, T> {
    T apply(S s);
}
