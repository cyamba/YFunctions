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
        List<Integer> tmp = new ArrayList<>();
        if (start > end) {
            for (int i = start; i >= end; i--) {
                tmp.add(i);
            }
            return new YList(tmp);
        }
        for (int i = start; i <= end; i++) {
            tmp.add(i);
        }
        return new YList(tmp);
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
        return zip0(firstList, sndList);
    }

    static <S, T> YList<Tuple<S, T>> zip0(YList<S> firstList, YList<T> sndList) {
        List<Tuple<S, T>> mutableTmpList = new ArrayList<Tuple<S, T>>();
        int minLength = Math.min(firstList.length(), sndList.length());
        for (int i = 0; i < minLength; i++) {
            mutableTmpList.add(zip1(firstList.get(i), sndList.get(i)));
        }
        return YList.list(mutableTmpList);
    }

    static <S, T> Tuple<S, T> zip1(S first, T second) {
        return Tuple.of(first, second);
    }

    public static <S, T> Tuple<YList<S>, YList<T>> split(YList<Tuple<S, T>> tupleList) {
        List<S> fstList = new ArrayList<>();
        List<T> sndList = new ArrayList<>();
        for (Tuple<S, T> tuple : tupleList.getRawList()) {
            fstList.add(tuple._0);
            sndList.add(tuple._1);
        }
        return Tuple.of(YList.list(fstList), YList.list(sndList));
    }

}
