package com.seewhy.yfunctions.structure;

/**
 * @author cbyamba
 *         Date: 2013-06-15
 *         Time: 20:01
 */
public interface Monad<S> {
    S f(S s);
}
