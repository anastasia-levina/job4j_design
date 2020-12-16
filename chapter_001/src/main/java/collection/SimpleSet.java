package collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {

    private final SimpleArray<E> container = new SimpleArray<>();

    public void add(E e) {
        if (!findBy(e)) {
            container.add(e);
        }
    }

    public boolean findBy(E obj) {
        for (Object e : container) {
            if (Objects.equals(obj, e))
                return true;
        }
        return false;
    }

    public int size() {
        return container.size();
    }

    @Override
    public Iterator<E> iterator() {
        return container.iterator();
    }
}