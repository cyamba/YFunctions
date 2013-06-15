package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.standard.Binad;
import com.seewhy.yfunctions.function.standard.Predicate;
import com.seewhy.yfunctions.function.standard.Printer;
import com.seewhy.yfunctions.function.standard.YVoid;
import org.junit.Test;

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

    void nl() {
        System.out.println();
    }

    void print(String s) {
        System.out.println(s);
    }

}

