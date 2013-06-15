package com.seewhy.yfunctions.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 21:53
 */
public class Tuples {

    //TODO generalize the split and zip operations and create code generators for every operation.

    //TODO zip of degree 3.

    public static <T0, T1, T2> Tuple3<YList<T0>, YList<T1>, YList<T2>> split(YList<Tuple3<T0, T1, T2>> tuples) {
        List<T0> list0 = new ArrayList<T0>();
        List<T1> list1 = new ArrayList<T1>();
        List<T2> list2 = new ArrayList<T2>();
        for (Tuple3<T0, T1, T2> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
        }
        return new Tuple3<YList<T0>, YList<T1>, YList<T2>>(new YList<T0>(list0), new YList<T1>(list1), new YList<T2>(list2));
    }
}
