package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.Accumulator;
import com.seewhy.yfunctions.function.BinaryFunction;

/**
 * @author cbyamba
 *         Date: 2013-06-18
 *         Time: 19:57
 */
public class AccumulatorParent<T, U> implements Accumulator<T, U> {

    private BinaryFunction<T, U, U> function;

    private U value;

    public AccumulatorParent(BinaryFunction<T, U, U> function, U initialValue) {
        this.function = function;
        this.value = initialValue;
    }

    public AccumulatorParent<T, U> accumulate(U accumulation, T current) {
        value = function.apply(current, accumulation);
        return this;
    }

    public U getValue() {
        return value;
    }
}
