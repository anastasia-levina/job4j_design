package collection;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> foundParent = findBy(parent);
        Optional<Node<E>> foundChild = findBy(child);
        if (foundParent.isPresent()) {
            if (foundChild.isEmpty()) {
                Node<E> childNode = new Node<>(child);
                foundParent.get().getChildren().add(childNode);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}