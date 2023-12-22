package queue;

import list.LinkedList.LinkedList;
import stack.InheritedStack;

public class InheritedQueue <E> extends LinkedList<E> implements QueueInterface<E> {
    public InheritedQueue () {
        super();
    }

    @Override
    public void enqueue(E x) {
        append(x);
    }

    @Override
    public E dequeue() {
        return remove(0);
    }

    @Override
    public E front() {
        return get(0);
    }

    @Override
    public void dequeueAll() {
            clear();
    }
}
