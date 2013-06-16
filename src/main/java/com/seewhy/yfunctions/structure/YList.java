package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.standard.*;

import java.util.*;

/**
 * @author: chryam
 * Date: 2013-06-05
 * Time: 09:01
 * <p/>
 * TODO verify control of immutabilty
 */
public class YList<S> {

    private final List<S> rawList;

    public YList(List<S> xs) {
        rawList = xs;
    }

    private YList() {
        rawList = new ArrayList<S>();
    }

    private List<S> newRawList() {
        return new ArrayList<S>();
    }

    //TODO real deep copy mini framework

    public static <S> YList<S> list(List<S> xs) {
        return new YList(xs);
    }

    public static <S> YList<S> list(S... xs) {
        return new YList(Arrays.asList(xs));
    }

    public static <S> YList list() {
        return new YList();
    }

    public List<S> getRawList() {
        return rawList;
    }

    public YList<S> foreach(YVoid<S> function) {
        for (S s : rawList) {
            function.f(s);
        }
        return this;
    }

    public YList<S> filter(Predicate<S> predicate) {
        List<S> mutableTmpList = newRawList();
        for (S s : rawList) {
            if (predicate.f(s)) {
                mutableTmpList.add(s);
            }
        }
        return list(mutableTmpList);
    }

    public YList<S> filter(Predicate<S>... predicates) {
        YList<S> newAccu = new YList<S>(rawList);
        for (Predicate<S> p : predicates) {
            newAccu = filter0(p, newAccu);
        }
        return newAccu;
    }

    YList<S> filter0(Predicate<S> predicate, YList<S> fromAccu) {
        List<S> toAccu = new ArrayList<S>();
        for (S s : fromAccu.getRawList()) {
            if (predicate.f(s)) {
                toAccu.add(s);
            }
        }
        return new YList(toAccu);
    }

    public YList<S> map(Monad<S> monad) {
        List<S> mutableTmpList = newRawList();
        for (S s : rawList) {
            mutableTmpList.add(monad.f(s));
        }
        return new YList(mutableTmpList);
    }

    public <T> YList<T> map(Binad<S, T> binad) {
        List<T> mutableTmpList = new ArrayList<T>();
        for (S s : rawList) {
            mutableTmpList.add(binad.f(s));
        }
        return new YList(mutableTmpList);
    }

    public YList<S> copy() {
        return new YList(copyRawList());
    }

    public YList<S> reduce() {
        return this;
    }

    public YList<S> fold() {
        return this;
    }

    //TODO deep copy framework -  temporary solution internal copyRawList and copy functions .. review...
    List<S> copyRawList() {
        return Arrays.asList(Arrays.copyOf(array(), rawList.size()));
    }

    List<S> copyRawList(List<S> xs) {
        return Arrays.asList(Arrays.copyOf((S[]) xs.toArray(), xs.size()));
    }

    public YList<S> merge(YList<S> xs) {
        List<S> mutableTmpList = addAll(new ArrayList<S>(), rawList);
        mutableTmpList = addAll(mutableTmpList, xs.copy().copyRawList());
        return list(mutableTmpList);
    }

    List<S> addAll(List<S> firstList, List<S> otherList) {
        for (S s : otherList) {
            firstList.add(s);
        }
        return firstList;
    }

    public YList<S> merge(List<S> xs) {
        List<S> mutableTmpList = addAll(new ArrayList<S>(), rawList);
        mutableTmpList = addAll(mutableTmpList, copyRawList(xs));
        return list(mutableTmpList);
    }

    public YList<S> merge(S... xs) {
        return merge(Arrays.asList(xs));
    }

    public YList<S> merge(YList<S>... xxs) {
        List<S> mutableTmpList = addAll(new ArrayList<S>(), rawList);
        for (YList<S> xs : xxs) {
            mutableTmpList = addAll(mutableTmpList, copyRawList(xs.getRawList()));
        }
        return list(mutableTmpList);
    }

    public YList<S> merge(List<S>... xxs) {
        List<S> mutableTmpList = addAll(new ArrayList<S>(), rawList);
        for (List<S> xs : xxs) {
            mutableTmpList = addAll(mutableTmpList, copyRawList(xs));
        }
        return list(mutableTmpList);
    }

    public YList<S> cycle(YList<S> xs) {
        return cycle(xs);
    }

    public YList<S> reverse(YList<S> xs) {
        List<S> mutableTmpList = copyRawList(xs.getRawList());
        Collections.reverse(mutableTmpList);
        return list(mutableTmpList);
    }

    public S get(int i) {
        return rawList.get(i);
    }

    public YList<S> take(int count, YList<S> xs) {
        List<S> mutableTmpList = newRawList();
        int i = 0;
        while (i < xs.getRawList().size() && i < count) {
            mutableTmpList.add(xs.get(i));
            i++;
        }
        return list(mutableTmpList);
    }

    public YList drop(int count, YList<S> xs) {
        List<S> mutableTmpList = newRawList();
        int i = 0;
        while (i < xs.getRawList().size() && i < count) {
            i++;
        }
        while (i < xs.getRawList().size()) {
            mutableTmpList.add(xs.get(i));
            i++;
        }
        return list(mutableTmpList);
    }

    public <T extends Comparable> S max() {
        if (rawList.isEmpty()) {
            return null;
        }
        S obj = rawList.get(0);
        if (!(obj instanceof Comparable)) {
            return null;
        }
        List<T> mutableTmpList = new ArrayList<T>();
        for (S s : rawList) {
            mutableTmpList.add((T) s);
        }
        T max = (T) Collections.max(mutableTmpList);
        return (S) max;
    }

    public S max(Comparator<S> comparator) {
        return Collections.max(rawList, comparator);
    }

    public S min() {
        return null;
    }

    public S min(Comparator<S> comparator) {
        return Collections.min(rawList, comparator);
    }

    public Number sum() {
        if (rawList.isEmpty()) {
            return 0;
        }
        if (!(rawList.get(0) instanceof Number)) {
            return 0;
        }
        int sum = 0;
        for (S s : rawList) {
            sum += ((Number) s).intValue();
        }
        return sum;
    }

    public int product() {
        return 1;
    }

    public boolean isEmpty() {
        return rawList.isEmpty();
    }

    public int length() {
        return rawList.size();
    }

    //TODO do this immutable
    public YList<S> add(S obj) {
        List<S> newRawList = rawList;
        newRawList.add(obj);
        return this;
    }

    public S[] toArray() {
        return rawList.toArray((S[]) new Object[]{});
    }

    public YList<S> zip(YList<S> fstList, YList<S> sndList) {
        return (YList<S>) YLists.zip(fstList, sndList);
    }

    public <T> YList<T> zip(YList<T> otherList) {
        return (YList<T>) YLists.zip(this, otherList);
    }

    public <T> Tuple<YList<S>, YList<T>> split() {
        return (Tuple<YList<S>, YList<T>>) YLists.split((YList<Tuple<S, T>>) this);
    }

    public S[] array() {
        return rawList.toArray((S[]) new Object[]{});
    }

    public YList<S> print() {
        return this.foreach((YVoid<S>) new Printer());
    }

    @Override
    public String toString() {
        return Arrays.deepToString(array());
    }
}
