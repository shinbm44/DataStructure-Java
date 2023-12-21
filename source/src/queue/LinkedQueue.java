package queue;

import list.LinkedList.Node;

public class LinkedQueue<E> implements QueueInterface<E> {

    private Node<E> tail;
    private final E ERROR = null;

    public LinkedQueue() {
        tail = null;
    }

    // 큐에 원소 삽입하기
    @Override
    public void enqueue(E x) {
            Node<E> newNode = new Node<>(x);
            if ( isEmpty() ) {
                newNode.next = newNode;
                tail = newNode;
            } else {
                newNode.next = tail.next;
                tail.next = newNode;
                tail = newNode;
            }

    }

    // 큐에 원소 삭제하기
    @Override
    public E dequeue() {
        if ( isEmpty() ){
            return ERROR;
        }
        Node <E> front = tail.next;
        if ( front == tail ){
            tail = null;
        } else {
            tail.next = front.next;
        }
        return front.item;
    }

    // 큐의 맨 앞 원소 알려주기
    @Override
    public E front() {
        if( isEmpty() ){
            return ERROR;
        }
        return tail.next.item;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public void dequeueAll() {
        tail = null;
    }
}
