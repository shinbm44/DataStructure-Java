package queue;

import list.Arraylist.ArrayList;
import list.Arraylist.ListInterface;

public class ListQueue <E> implements QueueInterface<E>{
    private ListInterface<E> list;

    public ListQueue() {
        // 리스트 인터페이스에 의존하며 필요에 따라 구현체를 바꿀 수 있으며,
        // 클라이언트가 직접 접근하지 못한다.(내부 메서드로만 접근 가능)
        list = new ArrayList<E>();
    }

    @Override
    public void enqueue(E x) {
        list.append(x);
    }

    @Override
    public E dequeue() {
        return list.remove(0);
    }

    @Override
    public E front() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void dequeueAll() {
        list.clear();
    }
}
