package com.seewhy.yfunctions.structure;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 21:45
 */
public class TupleTest {

    @Test
    public void testEquals() {
        Tuple3<Integer, String, Character> tuple1 = new Tuple3<Integer, String, Character>(0, "test", 'a');
        Tuple3<Integer, String, Character> tuple2 = new Tuple3<Integer, String, Character>(0, "test", 'a');
        assertEquals(tuple1, tuple2);
    }
}
