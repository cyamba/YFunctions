package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.BinaryFunction;

/**
 * @author cbyamba
 *         Date: 2013-06-18
 *         Time: 19:55
 */
public class Accumulators {

    public static <T, U> U fold(YList<T> list, BinaryFunction<T, U, U> function, U initialValue) {
        AccumulatorParent<T, U> accumulator = new AccumulatorParent(function, initialValue);
        for (T t : list.getRawList()) {
            accumulator.accumulate(accumulator.getValue(), t);
        }
        return accumulator.getValue();
    }

    public static <T, U> U fold2(YList<T> list, BinaryFunction<T, U, U> function, U accumulatedValue) {
        if (list.isEmpty()) {
            return accumulatedValue;
        }
        accumulatedValue = function.apply(list.head(), accumulatedValue);
        return fold2(list.tail(), function, accumulatedValue);
    }
}
