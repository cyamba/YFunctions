package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.BinadTwoArgs;

/**
 * @author cbyamba
 *         Date: 2013-06-18
 *         Time: 19:55
 */
public class Accumulators {

    public static <S, T> T fold(YList<S> list, BinadTwoArgs<S, T> function, T initialValue) {
        AccumulatorParent<S, T> accumulator = new AccumulatorParent(function, initialValue);
        for (S s : list.getRawList()) {
            accumulator.accumulate(accumulator.getValue(), s);
        }
        return accumulator.getValue();
    }
}
