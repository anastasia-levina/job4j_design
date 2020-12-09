package collection;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    private int allElements = 0;
    private int modCount = 0;
    private SimpleArray container = new SimpleArray();

    public void add(E e) {
        if (findBy(e)) {
            return;
        } else {
            container.add(e);
        }
    }

    public boolean findBy(E obj) {
        for (Object e : container) {
            if (e.equals(obj))
                return true;
            break;
        }
        return false;
    }

    public int size() {
        int rsl = 0;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            rsl++;
            iterator.next();
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return container.iterator();
    }
}