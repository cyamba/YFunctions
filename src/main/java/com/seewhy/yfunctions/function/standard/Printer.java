package com.seewhy.yfunctions.function.standard;

import com.seewhy.yfunctions.structure.Nil;
import com.seewhy.yfunctions.structure.YVoid;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 20:10
 */
public class Printer implements YVoid<Object> {
    public Nil f(Object s) {
        System.out.print(s + " ");
        return new Nil();
    }
}
