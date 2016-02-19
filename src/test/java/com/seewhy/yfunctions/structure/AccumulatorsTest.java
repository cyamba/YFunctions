package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.BinaryFunction;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by christopheryamba on 19/02/16.
 */
public class AccumulatorsTest {

    @Test
    public void shouldReturnAccumulatedValue() {
        //Given
        YList<Integer> integers = YLists.list(1, 7);
        BinaryFunction<Integer, Double, Double> binaryFunction = new BinaryFunction<Integer, Double, Double>() {
            public Double apply(Integer integer, Double accumulated) {
                return 1d / integer + accumulated;
            }
        };

        //When
        Double folded = Accumulators.fold(integers, binaryFunction, 0d);

        //Then
        assertEquals("",Double.valueOf(2.5928571428571425d),folded);
    }

}