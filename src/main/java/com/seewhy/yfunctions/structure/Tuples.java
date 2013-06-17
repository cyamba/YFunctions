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

    public static <T0, T1, T2> YList<Tuple3<T0, T1, T2>> zip(Tuple3<YList<T0>, YList<T1>, YList<T2>> tuple) {
        List<T0> list0 = tuple._0().getRawList();
        List<T1> list1 = tuple._1().getRawList();
        List<T2> list2 = tuple._2().getRawList();
        int length = maximum(list0.size(), list1.size(), list2.size());
        List<Tuple3<T0, T1, T2>> tuples = new ArrayList<Tuple3<T0, T1, T2>>(length);
        for (int i = 0; i < tuples.size(); i++) {
            tuples.add(new Tuple3<T0, T1, T2>(list0.get(i), list1.get(i), list2.get(0)));
        }
        return new YList<Tuple3<T0, T1, T2>>(tuples);
    }

    public static int maximum(int... k) {
        int max = k[0];
        for (int i = 1; i < k.length; i++) {
            if (k[i] > max) {
                max = k[i];
            }
        }
        return max;
    }

    public static void main(String... args) {
        YList<Tuple3<Integer, Boolean, String>> tuples = YList
                .list(new Tuple3<Integer, Boolean, String>(1, true, "one"),
                        new Tuple3<Integer, Boolean, String>(2, false, "two"),
                        new Tuple3<Integer, Boolean, String>(3, true, "three")).print();
        nl();
        split(tuples)._0().print();
        nl();
        split(tuples)._1().print();
        nl();
        split(tuples)._2().print();

    }

    public static int minimum(int... k) {
        if (k.length == 0) {
            return 0;
        }
        int min = k[0];
        for (int i = 0; i < k.length; i++) {
            if (k[i] > min) {
                min = k[i];
            }
        }
        return min;
    }

    public static <T0, T1, T2, T3> YList<Tuple4<T0, T1, T2, T3>> zip(Tuple4<YList<T0>, YList<T1>, YList<T2>, YList<T3>> tupleOfLists) {
        YList<T0> list0 = tupleOfLists._0();
        YList<T1> list1 = tupleOfLists._1();
        YList<T2> list2 = tupleOfLists._2();
        YList<T3> list3 = tupleOfLists._3();
        List<Tuple4<T0, T1, T2, T3>> listOfTuples = new ArrayList<Tuple4<T0, T1, T2, T3>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length());
        for (int i = 0; i < length; i++) {
            listOfTuples.add(new Tuple4<T0, T1, T2, T3>(list0.get(i), list1.get(i), list2.get(i), list3.get(i)));
        }
        return new YList<Tuple4<T0, T1, T2, T3>>(listOfTuples);
    }

    static void nl() {
        System.out.println();
    }

}
