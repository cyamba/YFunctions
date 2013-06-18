package com.seewhy.yfunctions.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cbyamba
 *         Date: 2013-06-15
 *         Time: 19:56
 */
public class YLists {

    public static YList<Integer> list(Integer start, Integer end) {
        List<Integer> tmp = new ArrayList<Integer>();
        if (start > end) {
            for (int i = start; i >= end; i--) {
                tmp.add(i);
            }
            return new YList<Integer>(tmp);
        }
        for (int i = start; i <= end; i++) {
            tmp.add(i);
        }
        return new YList<Integer>(tmp);
    }

    public static <S> YList<S> cycle(YList<S> block, int count) {
        List<S> result = YList.list().getRawList();
        List<S> blockRawList = block.getRawList();
        for (int i = 0; i < count; i++) {
            result.add(blockRawList.get(i % blockRawList.size()));
        }
        return YList.list(result);
    }

    public static <S, T> YList<Tuple<S, T>> zip(YList<S> firstList, YList<T> sndList) {
        if (firstList.isEmpty() || sndList.isEmpty()) {
            return (YList<Tuple<S, T>>) YList.list();
        }
        return (YList<Tuple<S, T>>) zip0(firstList, sndList);
    }

    static <S, T> YList<Tuple<S, T>> zip0(YList<S> firstList, YList<T> sndList) {
        List<Tuple<S, T>> mutableTmpList = new ArrayList<Tuple<S, T>>();
        int minLength = Math.min(firstList.length(), sndList.length());
        for (int i = 0; i < minLength; i++) {
            mutableTmpList.add((Tuple<S, T>) zip1(firstList.get(i), sndList.get(i)));
        }
        return (YList<Tuple<S, T>>) YList.list(mutableTmpList);
    }

    static <S, T> Tuple<S, T> zip1(S first, T second) {
        return new Tuple<S, T>(first, second);
    }

    public static <S, T> Tuple<YList<S>, YList<T>> split(YList<Tuple<S, T>> tupleList) {
        List<S> fstList = new ArrayList<S>();
        List<T> sndList = new ArrayList<T>();
        for (Tuple<S, T> tuple : tupleList.getRawList()) {
            fstList.add(tuple.getFirst());
            sndList.add(tuple.getSecond());
        }
        return new Tuple<YList<S>, YList<T>>((YList<S>) YList.list(fstList), (YList<T>) YList.list(sndList));
    }

}
