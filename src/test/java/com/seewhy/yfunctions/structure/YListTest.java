package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.BinadTwoArgs;
import com.seewhy.yfunctions.function.Binad;
import com.seewhy.yfunctions.function.Predicate;
import com.seewhy.yfunctions.function.standard.Printer;
import com.seewhy.yfunctions.function.YVoid;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 19:48
 */
public class YListTest {

    YVoid<Tuple<Integer, String>> printer = new YVoid<Tuple<Integer, String>>() {
        public Nil f(Tuple<Integer, String> tuple) {
            System.out.print(tuple.toString() + " ");
            return new Nil();
        }
    };

    @Test
    public void testFilterVarArgs() {
        YList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
                .filter(
                        new Predicate<Integer>() {
                            public boolean f(Integer integer) {
                                return integer % 2 != 0;
                            }
                        }
                )
                .foreach(new Printer<Integer>());
    }

    @Test
    public void testFilter() {
        Predicate<Integer> odd = new Predicate<Integer>() {
            public boolean f(Integer integer) {
                return integer % 2 != 0;
            }
        };

        Predicate<Integer> incongruentWith3 = new Predicate<Integer>() {
            public boolean f(Integer integer) {
                return integer % 3 != 0;
            }
        };

        YList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
                .filter(odd, incongruentWith3)
                .print();
    }

    @Test
    public void testMerge() {
        YList.list(1, 2, 3, 4, 5).merge(YList.list(11, 22, 33, 44, 55)).foreach(new Printer<Integer>());
    }

    @Test
    public void testMergeVarArgs() {
        YList.list(1, 2, 3, 4, 5).merge(11, 22, 33, 44, 55, 66, 77).foreach(new Printer<Integer>());
    }

    @Test
    public void testMergeListVarArgs() {
        YList.list(1, 2, 3, 4, 5).merge(Arrays.asList(7, 8, 9), Arrays.asList(10, 11, 12), Arrays.asList(13, 14, 15))
                .foreach(new Printer<Integer>());
    }

    public void testZip() {
        YList<Integer> numbers = YList.list(1, 2, 3, 4, 5);
        YList<String> alphabeth = YList.list("a", "b", "c", "d", "e");
        YList<Tuple<Integer, String>> tuples = YLists.zip(numbers, alphabeth);
        print(tuples.length() + " " + Arrays.deepToString(tuples.toArray()));
        nl();
        tuples.foreach(printer);
        nl();
        print(tuples.split().toString());
    }

    @Test
    public void testFilterWithVarArg() {
        YList<Integer> numbers = YList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers
                .filter(
                        new Predicate<Integer>() {
                            public boolean f(Integer integer) {
                                return integer % 2 != 0;
                            }
                        },
                        new Predicate<Integer>() {
                            public boolean f(Integer integer) {
                                return integer % 3 != 0;
                            }
                        }
                )
                .print();
    }

    @Test
    public void testMap() {
        YList.list(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(new Binad<Integer, String>() {
                    public String f(Integer integer) {
                        return Integer.toBinaryString(integer);
                    }
                })
                .foreach(new Printer<String>());
    }

    @Test
    public void testFold() {
        Integer result = (Integer) YList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).fold(0,
                new BinadTwoArgs<Integer, Integer>() {
                    public Integer f(Integer accumulation, Integer currentValue) {
                        return accumulation + currentValue;
                    }
                }
        );
        assertEquals(Integer.valueOf(55), result);
        print(result.toString());
        print(YLists.list(1, 7).fold("", new BinadTwoArgs<Integer, String>() {
            public String f(String accumulation, Integer currentValue) {
                return accumulation + "." + Integer.toBinaryString(currentValue);
            }
        }));
    }


    void nl() {
        System.out.println();
    }

    void print(String s) {
        System.out.println(s);
    }

}

