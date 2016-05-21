package com.yambacode.yfunctions.function;

/**
 * @author cbyamba
 *         Date: 2013-06-18
 *         Time: 19:58
 */
public interface Accumulator<S, T> {
    Accumulator<S, T> accumulate(T accumulation, S current);
}
