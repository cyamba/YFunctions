package com.yambacode.yfunctions.function;

import com.yambacode.yfunctions.structure.Nil;

/**
 * @author: cbyamba
 * Date: 2013-06-15
 * Time: 20:01
 */
public interface YVoid<T> {
    Nil apply(T t);
}
