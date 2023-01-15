package thinking.holdingYObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSequence<T> implements Collection<T> {
    private Collection<T> gerbils;

    public CollectionSequence() {
        gerbils = new ArrayList<>();
    }


    @Override
    public int size() {
        return gerbils.size();
    }

    @Override
    public boolean isEmpty() {
        return gerbils.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
