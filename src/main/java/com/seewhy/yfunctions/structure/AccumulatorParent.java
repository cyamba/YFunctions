package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.Accumulator;
import com.seewhy.yfunctions.function.BinadTwoArgs;

/**
 * @author cbyamba
 *         Date: 2013-06-18
 *         Time: 19:57
 */
public class AccumulatorParent<S, T> implements Accumulator<S, T> {

    private BinadTwoArgs<S, T> function;

    private T value;

    public AccumulatorParent(BinadTwoArgs<S, T> function, T initialValue) {
        this.function = function;
        this.value = initialValue;
    }

    public AccumulatorParent<S, T> accumulate(T accumulation, S current) {
        value = function.f(accumulation, current);
        return this;
    }

    public T getValue() {
        return value;
    }
}
