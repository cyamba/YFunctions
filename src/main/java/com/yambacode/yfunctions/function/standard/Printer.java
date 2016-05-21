package com.yambacode.yfunctions.function.standard;

import com.yambacode.yfunctions.function.YVoid;
import com.yambacode.yfunctions.structure.Nil;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 20:10
 */
public class Printer<T> implements YVoid<T> {
    public Nil apply(T s) {
        System.out.print(s + " ");
        return new Nil();
    }
}
