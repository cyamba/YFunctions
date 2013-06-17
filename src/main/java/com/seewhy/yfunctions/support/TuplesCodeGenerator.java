package com.seewhy.yfunctions.support;

/**
 * User: cbyamba
 * Date: 2013-06-17
 * Time: 19:08
 */

import static com.seewhy.yfunctions.support.TupleNCodeGenerator.*;

/**
 * @author chryam
 *         Date: 2013-06-17
 *         Time: 11:16
 */
public class TuplesCodeGenerator {

    public static int length = 10;

    /**
     * @return
     */
    public static String code() {
        StringBuilder builder = new StringBuilder();
        builder.append("public class Tuples {");
        builder.append(NL(2));
        for (int i = 3; i < length; i++) {
            builder.append(zip(i)).append(NL(2));
            builder.append(split(i)).append(NL(2));
        }
        builder.append("}");
        return builder.toString();
    }

    public static String zip(int length) {
        StringBuilder builder = new StringBuilder();
        builder.append(TB).append("public static ").append(generics(length));
        builder.append(" YList<Tuple").append(length);
        builder.append(generics(length)).append(">");
        ;
        builder.append(" zip(Tuple").append(length).append("<").append("YList<T0>");
        for (int i = 1; i < length; i++) {
            builder.append(", YList<").append("T").append(i).append(">");
        }
        builder.append("> tupleOfYList");
        builder.append(") {").append(NL);
        builder.append(TB(2)).append("YList<T0> list0 = tupleOfYList._0();").append(NL);
        for (int i = 1; i < length; i++) {
            builder.append(TB(2)).append("YList<T").append(i).append("> list").append(i)
                    .append(" = tupleOfYList._").append(i).append("();").append(NL);
        }
        builder.append(TB(2)).append("List<Tuple").append(length).append(generics(length)).append("> listOfYTuples")
                .append(" = ").append("new ArrayList<").append("Tuple").append(length)
                .append(generics(length)).append(">").append("();").append(NL);
        builder.append(TB(2)).append("int length = minimum(list0.length()");
        for (int i = 1; i < length; i++) {
            builder.append(", list").append(i).append(".length()");
        }
        builder.append(");").append(NL);
        builder.append(TB(2)).append("for (int i = 0; i < length; i++) {").append(NL);
        builder.append(TB(3)).append("listOfYTuples.add(new Tuple").append(length).append(generics(length)).append("(list0.get(i)");
        for (int i = 1; i < length; i++) {
            builder.append(", list").append(i).append(".get(i)");
        }
        builder.append(");").append(NL);
        builder.append(TB(2)).append("}").append(NL);
        builder.append(TB(2)).append("return new YList<Tuple").append(length).append(generics(length)).append(">(listOfYTuples);").append(NL);
        builder.append(TB).append("}");
        return builder.toString();
    }

    public static String generics(int length) {
        StringBuilder builder = new StringBuilder();
        builder.append("<T0");
        for (int i = 1; i < length; i++) {
            builder.append(", T").append(i);
        }
        builder.append(">");
        return builder.toString();
    }

    /*

    public static <T0, T1, T2, T3> Tuple4<YList<T0>, YList<T1>, YList<T2>, YList<T3>> split(YList<Tuple4<T0, T1, T2, T3>> tuples) {
        List<T0> list0 = new ArrayList<T0>();
        List<T1> list1 = new ArrayList<T0>();
        List<T2> list2 = new ArrayList<T0>();
        List<T3> list3 = new ArrayList<T0>();
        for (Tuple4<T0, T1, T2, T3> t : tuples.getRawList()) {
            list0.add(t._0());
            list1.add(t._1());
            list2.add(t._2());
            list3.add(t._3());
        }
        return new Tuple4<YList<T0>, YList<T1>, YList<T2>, YList<T3>>(new YList<T0>(list0), new YList<T1>(list1), new YList<T2>(list2), new YList<T3>(list3));
    }
     */
    public static String split(int length) {
        StringBuilder builder = new StringBuilder();
        builder.append(TB).append("public static ").append(generics(length)).append(" Tuple").append(length).append("<YList<T0>");
        for (int i = 0; i < length; i++) {
            builder.append(",").append(" YList<T").append(i).append(">");
        }
        builder.append("> ");
        builder.append("split(YList<Tuple").append(length).append(generics(length));
        builder.append("> tuples) {").append(NL);
        for (int i = 0; i < length; i++) {
            builder.append(TB(2)).append("List<T").append(i).append("> list").append(i).append(" = ")
                    .append("new ArrayList<T").append(i).append(">();").append(NL);
        }
        builder.append(TB(2)).append("for (Tuple").append(length).append(generics(length)).append(" t : ").append("tuples.getRawList()) {").append(NL);
        for (int i = 0; i < length; i++) {
            builder.append(TB(3)).append("list").append(i).append("add(").append("t._").append(i).append("());").append(NL);
        }
        builder.append(TB(2)).append("}").append(NL);
        builder.append(TB(2)).append("return new Tuple").append(length).append("<YList<T0>");
        for (int i = 1; i < length; i++) {
            builder.append(",").append(" YList<T").append(i).append(">");
        }
        builder.append(">(new YList<T0>(list0)");
        for (int i = 1; i < length; i++) {
            builder.append(", new YList<T").append(i).append(")>(list").append(i).append(")");
        }
        builder.append(");").append(NL);
        builder.append(TB).append("}");
        return builder.toString();
    }

    public static void main(String... args) {
        print(code());
    }

    static void print(String source) {
        System.out.println(source);
    }
}

