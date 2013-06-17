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

    public static void main(String... args) {
        YList<Tuple3<Integer, Boolean, String>> tuples = YList
                .list(
                        new Tuple3<Integer, Boolean, String>(1, true, "one"),
                        new Tuple3<Integer, Boolean, String>(2, false, "two"),
                        new Tuple3<Integer, Boolean, String>(3, true, "three"))
                .print();
        nl();
        split(tuples)._0().print();
        nl();
        split(tuples)._1().print();
        nl();
        split(tuples)._2().print();

    }

    static void nl() {
        System.out.println();
    }

    /**
     * @param k
     * @return
     */
    public static int minimum(int... k) {
        if (k.length == 0) {
            return 0;
        }
        int min = k[0];
        for (int i = 0; i < k.length; i++) {
            if (k[i] < min) {
                min = k[i];
            }
        }
        return min;
    }


    /**
     * @param tuple
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @return
     */
    public static <T0, T1, T2> YList<Tuple3<T0, T1, T2>> zip(Tuple3<YList<T0>, YList<T1>, YList<T2>> tuple) {
        List<T0> list0 = tuple._0().getRawList();
        List<T1> list1 = tuple._1().getRawList();
        List<T2> list2 = tuple._2().getRawList();
        int length = minimum(list0.size(), list1.size(), list2.size());
        List<Tuple3<T0, T1, T2>> tuples = new ArrayList<Tuple3<T0, T1, T2>>(length);
        for (int i = 0; i < tuples.size(); i++) {
            tuples.add(new Tuple3<T0, T1, T2>(list0.get(i), list1.get(i), list2.get(0)));
        }
        return new YList<Tuple3<T0, T1, T2>>(tuples);
    }


    /**
     * @param tupleOfLists
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @return
     */
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


    /**
     * @param tupleOfYList
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <T4>
     * @return
     */
    public static <T0, T1, T2, T3, T4> YList<Tuple5<T0, T1, T2, T3, T4>> zip(Tuple5<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        List<Tuple5<T0, T1, T2, T3, T4>> listOfYTuples = new ArrayList<Tuple5<T0, T1, T2, T3, T4>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple5<T0, T1, T2, T3, T4>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i));
        }
        return new YList<Tuple5<T0, T1, T2, T3, T4>>(listOfYTuples);
    }

    /**
     * @param tupleOfYList
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <T4>
     * @param <T5>
     * @param <T6>
     * @return
     */
    public static <T0, T1, T2, T3, T4, T5, T6> YList<Tuple7<T0, T1, T2, T3, T4, T5, T6>> zip(Tuple7<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        YList<T5> list5 = tupleOfYList._5();
        YList<T6> list6 = tupleOfYList._6();
        List<Tuple7<T0, T1, T2, T3, T4, T5, T6>> listOfYTuples = new ArrayList<Tuple7<T0, T1, T2, T3, T4, T5, T6>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length(), list5.length(), list6.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple7<T0, T1, T2, T3, T4, T5, T6>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i));
        }
        return new YList<Tuple7<T0, T1, T2, T3, T4, T5, T6>>(listOfYTuples);
    }

    /**
     * @param tupleOfYList
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <T4>
     * @param <T5>
     * @param <T6>
     * @param <T7>
     * @return
     */
    public static <T0, T1, T2, T3, T4, T5, T6, T7> YList<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>> zip(Tuple8<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>, YList<T7>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        YList<T5> list5 = tupleOfYList._5();
        YList<T6> list6 = tupleOfYList._6();
        YList<T7> list7 = tupleOfYList._7();
        List<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>> listOfYTuples = new ArrayList<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length(), list5.length(), list6.length(), list7.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i));
        }
        return new YList<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>>(listOfYTuples);
    }

    /**
     * @param tupleOfYList
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <T4>
     * @param <T5>
     * @param <T6>
     * @param <T7>
     * @param <T8>
     * @return
     */
    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> YList<Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8>> zip(Tuple9<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>, YList<T7>, YList<T8>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        YList<T5> list5 = tupleOfYList._5();
        YList<T6> list6 = tupleOfYList._6();
        YList<T7> list7 = tupleOfYList._7();
        YList<T8> list8 = tupleOfYList._8();
        List<Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8>> listOfYTuples = new ArrayList<Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length(), list5.length(), list6.length(), list7.length(), list8.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i));
        }
        return new YList<Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8>>(listOfYTuples);
    }


    /**
     * @param tupleOfYList
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <T4>
     * @param <T5>
     * @return
     */
    public static <T0, T1, T2, T3, T4, T5> YList<Tuple6<T0, T1, T2, T3, T4, T5>> zip(Tuple6<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        YList<T5> list5 = tupleOfYList._5();
        List<Tuple6<T0, T1, T2, T3, T4, T5>> listOfYTuples = new ArrayList<Tuple6<T0, T1, T2, T3, T4, T5>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length(), list5.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple6<T0, T1, T2, T3, T4, T5>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i));
        }
        return new YList<Tuple6<T0, T1, T2, T3, T4, T5>>(listOfYTuples);
    }

    /**
     * @param tuples
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @return
     */
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
