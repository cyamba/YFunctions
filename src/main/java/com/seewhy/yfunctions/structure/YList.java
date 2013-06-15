package com.seewhy.yfunctions.structure;

import com.seewhy.yfunctions.function.standard.Printer;

import java.util.*;

/**
 * @author: chryam
 * Date: 2013-06-05
 * Time: 09:01
 * <p/>
 * TODO verify control of immutabilty
 */
public class YList<S> {

    private final List<S> souldBeImmutableList;

    private YList(List<S> xs) {
        souldBeImmutableList = xs;
    }

    private YList() {
        souldBeImmutableList = new ArrayList<S>();
    }

    private List<S> newRawList() {
        return new ArrayList<S>();
    }

    //TODO real deep copy mini framework

    private List<S> newRawList(List<S> xs) {
        List<S> newRawList = new ArrayList<S>();
        for (S s : xs) {
            newRawList.add(s);
        }
        return newRawList;
    }

    private List<S> rawList(S... xs) {
        return Arrays.asList(xs);
    }

    public static <S> YList list(List<S> xs) {
        return new YList(xs);
    }

    public static <S> YList list(S... xs) {
        return new YList(Arrays.asList(xs));
    }

    public static <S> YList list() {
        return new YList();
    }

    public List<S> getRawList() {
        return souldBeImmutableList;
    }

    public YList<S> foreach(YVoid<S> function) {
        for (S s : souldBeImmutableList) {
            function.f(s);
        }
        return this;
    }

    public YList<S> filter(Predicate<S> predicate) {
        List<S> mutableTmpList = newRawList();
        for (S s : souldBeImmutableList) {
            if (predicate.f(s)) {
                mutableTmpList.add(s);
            }
        }
        return list(mutableTmpList);
    }

    public YList<S> filter(Predicate<S>... predicates) {
        YList<S> newAccu = new YList<S>(souldBeImmutableList);
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
        for (S s : souldBeImmutableList) {
            mutableTmpList.add(monad.f(s));
        }
        return new YList(mutableTmpList);
    }

    public <T> YList<T> map(Binad<S, T> binad) {
        List<T> mutableTmpList = new ArrayList<T>();
        for (S s : souldBeImmutableList) {
            mutableTmpList.add(binad.f(s));
        }
        return new YList(mutableTmpList);
    }

    public YList<S> copy() {
        List<S> mutableTmpList = newRawList();
        mutableTmpList.addAll(souldBeImmutableList);
        return new YList(souldBeImmutableList);
    }

    public YList<S> reduce() {
        return this;
    }

    public YList<S> fold() {
        return this;
    }

    //TODO deep copy framework
    List<S> copyRawList() {
        List<S> rawList = new ArrayList<S>();
        for (S s : souldBeImmutableList) {
            rawList.add(s);
        }
        return rawList;
    }

    //TODO fix
    public YList<S> merge(YList<S> xs) {
        List<S> mutableTmpList = souldBeImmutableList;
        mutableTmpList.addAll(souldBeImmutableList);
        mutableTmpList.addAll((List<S>) xs.getRawList());
        return list(xs);
    }

    public YList<S> merge(List<S> xs) {
        List<S> mutableTmpList = souldBeImmutableList;
        mutableTmpList.addAll(souldBeImmutableList);
        mutableTmpList.addAll(xs);
        return list(xs);
    }

    public YList<S> merge(S... xs) {
        List<S> mutableTmpList = souldBeImmutableList;
        mutableTmpList.addAll(souldBeImmutableList);
        mutableTmpList.addAll(Arrays.asList(xs));
        return list(xs);
    }

    public YList<S> cycle(YList<S> xs) {
        return cycle(xs);
    }

    public YList<S> reverse(YList<S> xs) {
        List<S> mutableTmpList = xs.getRawList();
        Collections.reverse(mutableTmpList);
        return list(mutableTmpList);
    }

    public S get(int i) {
        return souldBeImmutableList.get(i);
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
        if (souldBeImmutableList.isEmpty()) {
            return null;
        }
        S obj = souldBeImmutableList.get(0);
        if (!(obj instanceof Comparable)) {
            return null;
        }
        List<T> mutableTmpList = new ArrayList<T>();
        for (S s : souldBeImmutableList) {
            mutableTmpList.add((T) s);
        }
        T max = (T) Collections.max(mutableTmpList);
        return (S) max;
    }

    public S max(Comparator<S> comparator) {
        return Collections.max(souldBeImmutableList, comparator);
    }

    public S min() {
        return null;
    }

    public S min(Comparator<S> comparator) {
        return Collections.min(souldBeImmutableList, comparator);
    }

    public Number sum() {
        if (souldBeImmutableList.isEmpty()) {
            return 0;
        }
        if (!(souldBeImmutableList.get(0) instanceof Number)) {
            return 0;
        }
        int sum = 0;
        for (S s : souldBeImmutableList) {
            sum += ((Number) s).intValue();
        }
        return sum;
    }

    public int product() {
        return 1;
    }

    public boolean isEmpty() {
        return souldBeImmutableList.isEmpty();
    }

    public int length() {
        return souldBeImmutableList.size();
    }

    //TODO do this immutable
    public YList<S> add(S obj) {
        List<S> newRawList = souldBeImmutableList;
        newRawList.add(obj);
        return this;
    }

    public S[] toArray() {
        return souldBeImmutableList.toArray((S[]) new Object[]{});
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
        return souldBeImmutableList.toArray((S[]) new Object[]{});
    }

    public YList<S> print() {
        return this.foreach((YVoid<S>) new Printer());
    }

    @Override
    public String toString() {
        return Arrays.deepToString(array());
    }
}
