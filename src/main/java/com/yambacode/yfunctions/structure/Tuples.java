package com.yambacode.yfunctions.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 21:53
 */
public class Tuples {

    //TODO generalize the split and zip operations and create code generators for every operation.

    /**
     * @param tupleOfYList
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @return
     */
    public static <T0, T1, T2> YList<Tuple3<T0, T1, T2>> zip3(Tuple3<YList<T0>, YList<T1>, YList<T2>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        List<Tuple3<T0, T1, T2>> listOfYTuples = new ArrayList<Tuple3<T0, T1, T2>>();
        int length = minimum(list0.length(), list1.length(), list2.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple3<>(list0.get(i), list1.get(i), list2.get(i)));
        }
        return new YList<>(listOfYTuples);
    }

    /**
     * @param tuples
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @return
     */
    public static <T0, T1, T2> Tuple3<YList<T0>, YList<T1>, YList<T2>> split3(YList<Tuple3<T0, T1, T2>> tuples) {
        List<T0> list0 = new ArrayList<>();
        List<T1> list1 = new ArrayList<>();
        List<T2> list2 = new ArrayList<>();
        for (Tuple3<T0, T1, T2> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
        }
        return new Tuple3<>(new YList<>(list0), new YList<>(list1), new YList<>(list2));
    }

    /**
     * @param tupleOfYList
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @return
     */
    public static <T0, T1, T2, T3> YList<Tuple4<T0, T1, T2, T3>> zip4(Tuple4<YList<T0>, YList<T1>, YList<T2>, YList<T3>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        List<Tuple4<T0, T1, T2, T3>> listOfYTuples = new ArrayList<Tuple4<T0, T1, T2, T3>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple4<>(list0.get(i), list1.get(i), list2.get(i), list3.get(i)));
        }
        return new YList<>(listOfYTuples);
    }

    /**
     * @param tuples
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @return
     */
    public static <T0, T1, T2, T3> Tuple4<YList<T0>, YList<T1>, YList<T2>, YList<T3>> split4(YList<Tuple4<T0, T1, T2, T3>> tuples) {
        List<T0> list0 = new ArrayList<>();
        List<T1> list1 = new ArrayList<>();
        List<T2> list2 = new ArrayList<>();
        List<T3> list3 = new ArrayList<>();
        for (Tuple4<T0, T1, T2, T3> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
            list3.add(t._3());
        }
        return new Tuple4<>(new YList<>(list0), new YList<>(list1), new YList<>(list2), new YList<>(list3));
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
    public static <T0, T1, T2, T3, T4> YList<Tuple5<T0, T1, T2, T3, T4>> zip5(Tuple5<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        List<Tuple5<T0, T1, T2, T3, T4>> listOfYTuples = new ArrayList<Tuple5<T0, T1, T2, T3, T4>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple5<>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i)));
        }
        return new YList<>(listOfYTuples);
    }

    /**
     * @param tuples
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <T4>
     * @return
     */
    public static <T0, T1, T2, T3, T4> Tuple5<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>> split5(YList<Tuple5<T0, T1, T2, T3, T4>> tuples) {
        List<T0> list0 = new ArrayList<>();
        List<T1> list1 = new ArrayList<>();
        List<T2> list2 = new ArrayList<>();
        List<T3> list3 = new ArrayList<>();
        List<T4> list4 = new ArrayList<>();
        for (Tuple5<T0, T1, T2, T3, T4> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
            list3.add(t._3());
            list4.add(t._4());
        }
        return new Tuple5<>(new YList<>(list0), new YList<>(list1), new YList<>(list2), new YList<>(list3), new YList<>(list4));
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
    public static <T0, T1, T2, T3, T4, T5> YList<Tuple6<T0, T1, T2, T3, T4, T5>> zip6(Tuple6<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        YList<T5> list5 = tupleOfYList._5();
        List<Tuple6<T0, T1, T2, T3, T4, T5>> listOfYTuples = new ArrayList<Tuple6<T0, T1, T2, T3, T4, T5>>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length(), list5.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple6<>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i)));
        }
        return new YList<>(listOfYTuples);
    }

    /**
     * @param tuples
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <T4>
     * @param <T5>
     * @return
     */
    public static <T0, T1, T2, T3, T4, T5> Tuple6<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>> split6(YList<Tuple6<T0, T1, T2, T3, T4, T5>> tuples) {
        List<T0> list0 = new ArrayList<>();
        List<T1> list1 = new ArrayList<>();
        List<T2> list2 = new ArrayList<>();
        List<T3> list3 = new ArrayList<>();
        List<T4> list4 = new ArrayList<>();
        List<T5> list5 = new ArrayList<>();
        for (Tuple6<T0, T1, T2, T3, T4, T5> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
            list3.add(t._3());
            list4.add(t._4());
            list5.add(t._5());
        }
        return new Tuple6<>(new YList<T0>(list0), new YList<>(list1), new YList<>(list2), new YList<>(list3), new YList<>(list4), new YList<>(list5));
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
    public static <T0, T1, T2, T3, T4, T5, T6> YList<Tuple7<T0, T1, T2, T3, T4, T5, T6>> zip7(Tuple7<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        YList<T5> list5 = tupleOfYList._5();
        YList<T6> list6 = tupleOfYList._6();
        List<Tuple7<T0, T1, T2, T3, T4, T5, T6>> listOfYTuples = new ArrayList<>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length(), list5.length(), list6.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple7<>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i)));
        }
        return new YList<>(listOfYTuples);
    }

    /**
     * @param tuples
     * @param <T0>
     * @param <T1>
     * @param <T2>
     * @param <T3>
     * @param <T4>
     * @param <T5>
     * @param <T6>
     * @return
     */
    public static <T0, T1, T2, T3, T4, T5, T6> Tuple7<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>> split7(YList<Tuple7<T0, T1, T2, T3, T4, T5, T6>> tuples) {
        List<T0> list0 = new ArrayList<>();
        List<T1> list1 = new ArrayList<>();
        List<T2> list2 = new ArrayList<>();
        List<T3> list3 = new ArrayList<>();
        List<T4> list4 = new ArrayList<>();
        List<T5> list5 = new ArrayList<>();
        List<T6> list6 = new ArrayList<>();
        for (Tuple7<T0, T1, T2, T3, T4, T5, T6> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
            list3.add(t._3());
            list4.add(t._4());
            list5.add(t._5());
            list6.add(t._6());
        }
        return new Tuple7<>(new YList<>(list0), new YList<>(list1), new YList<T2>(list2), new YList<>(list3), new YList<>(list4), new YList<>(list5), new YList<>(list6));
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
    public static <T0, T1, T2, T3, T4, T5, T6, T7> YList<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>> zip8(Tuple8<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>, YList<T7>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        YList<T5> list5 = tupleOfYList._5();
        YList<T6> list6 = tupleOfYList._6();
        YList<T7> list7 = tupleOfYList._7();
        List<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>> listOfYTuples = new ArrayList<>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length(), list5.length(), list6.length(), list7.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple8<>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i)));
        }
        return new YList<>(listOfYTuples);
    }

    /**
     * @param tuples
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
    public static <T0, T1, T2, T3, T4, T5, T6, T7> Tuple8<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>, YList<T7>> split8(YList<Tuple8<T0, T1, T2, T3, T4, T5, T6, T7>> tuples) {
        List<T0> list0 = new ArrayList<>();
        List<T1> list1 = new ArrayList<>();
        List<T2> list2 = new ArrayList<>();
        List<T3> list3 = new ArrayList<>();
        List<T4> list4 = new ArrayList<>();
        List<T5> list5 = new ArrayList<>();
        List<T6> list6 = new ArrayList<>();
        List<T7> list7 = new ArrayList<>();
        for (Tuple8<T0, T1, T2, T3, T4, T5, T6, T7> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
            list3.add(t._3());
            list4.add(t._4());
            list5.add(t._5());
            list6.add(t._6());
            list7.add(t._7());
        }
        return new Tuple8<>(new YList<>(list0), new YList<>(list1), new YList<>(list2), new YList<>(list3), new YList<>(list4), new YList<>(list5), new YList<>(list6), new YList<>(list7));
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
    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> YList<Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8>> zip9(Tuple9<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>, YList<T7>, YList<T8>> tupleOfYList) {
        YList<T0> list0 = tupleOfYList._0();
        YList<T1> list1 = tupleOfYList._1();
        YList<T2> list2 = tupleOfYList._2();
        YList<T3> list3 = tupleOfYList._3();
        YList<T4> list4 = tupleOfYList._4();
        YList<T5> list5 = tupleOfYList._5();
        YList<T6> list6 = tupleOfYList._6();
        YList<T7> list7 = tupleOfYList._7();
        YList<T8> list8 = tupleOfYList._8();
        List<Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8>> listOfYTuples = new ArrayList<>();
        int length = minimum(list0.length(), list1.length(), list2.length(), list3.length(), list4.length(), list5.length(), list6.length(), list7.length(), list8.length());
        for (int i = 0; i < length; i++) {
            listOfYTuples.add(new Tuple9<>(list0.get(i), list1.get(i), list2.get(i), list3.get(i), list4.get(i), list5.get(i), list6.get(i), list7.get(i), list8.get(i)));
        }
        return new YList<>(listOfYTuples);
    }

    /**
     * @param tuples
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
    public static <T0, T1, T2, T3, T4, T5, T6, T7, T8> Tuple9<YList<T0>, YList<T1>, YList<T2>, YList<T3>, YList<T4>, YList<T5>, YList<T6>, YList<T7>, YList<T8>> split9(YList<Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8>> tuples) {
        List<T0> list0 = new ArrayList<>();
        List<T1> list1 = new ArrayList<>();
        List<T2> list2 = new ArrayList<>();
        List<T3> list3 = new ArrayList<>();
        List<T4> list4 = new ArrayList<>();
        List<T5> list5 = new ArrayList<>();
        List<T6> list6 = new ArrayList<>();
        List<T7> list7 = new ArrayList<>();
        List<T8> list8 = new ArrayList<>();
        for (Tuple9<T0, T1, T2, T3, T4, T5, T6, T7, T8> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
            list3.add(t._3());
            list4.add(t._4());
            list5.add(t._5());
            list6.add(t._6());
            list7.add(t._7());
            list8.add(t._8());
        }
        return new Tuple9<>(new YList<>(list0), new YList<>(list1), new YList<>(list2), new YList<>(list3), new YList<>(list4), new YList<>(list5), new YList<>(list6), new YList<>(list7), new YList<>(list8));
    }


    public static void main(String... args) {
        YList<Tuple3<Integer, Boolean, String>> tuples = YList
                .list(
                        new Tuple3<>(1, true, "one"),
                        new Tuple3<>(2, false, "two"),
                        new Tuple3<>(3, true, "three"))
                .print();
        nl();
        split3(tuples)._0().print();
        nl();
        split3(tuples)._1().print();
        nl();
        split3(tuples)._2().print();

        YList<Tuple4<Integer, Boolean, String, Character>> tuples2 = YList
                .list(
                        new Tuple4<>(1, true, "one", 'a'),
                        new Tuple4<>(2, false, "two", 'b'),
                        new Tuple4<>(3, true, "three", 'c'),
                        new Tuple4<>(4, false, "four", 'd'))
                .print();
        nl();
        split4(tuples2)._0().print();
        nl();
        split4(tuples2)._1().print();
        nl();
        split4(tuples2)._2().print();
        nl();
        split4(tuples2)._3().print();

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


}