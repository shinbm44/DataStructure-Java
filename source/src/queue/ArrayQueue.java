package queue;

public class ArrayQueue<E> implements QueueInterface<E> {

    private E queue[];
    private int front, tail, numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;

    public ArrayQueue() {
        queue = (E[])new Object[DEFAULT_CAPACITY];
        front = 0;
        tail = DEFAULT_CAPACITY-1;
        numItems = 0;
    }

    public ArrayQueue(int n) {
        queue = (E[])new Object[n];
        front = 0;
        tail = n-1;
        numItems = 0;
    }

    // 큐가 꽉 찼는지 확인하기
    public boolean isFull(){
        return numItems == queue.length;
    }

    // 큐에 원소 삽입하기
    @Override
    public void enqueue(E x) {
        if( isFull() ){
            System.out.println("큐에 빈 공간이 없습니다.");
        }
        tail = (tail + 1) % queue.length;
        queue[tail] = x;
        numItems++;
    }
    // 큐에서 원소 삭제하기
    @Override
    public E dequeue() {
        if ( isEmpty() ) {
            System.out.println("삭제할 데이터가 없습니다.");
        }
        E queueFront = queue[front];
        front = (front + 1) % queue.length;
        numItems--;
        return queueFront;
    }
    // 큐의 맨 앞 원소 알려주기
    @Override
    public E front() {
        if ( isEmpty() ){
            System.out.println("큐가 비었습니다.");
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    // 큐 비우기
    @Override
    public void dequeueAll() {
        queue = (E[]) new Object[queue.length];
        numItems =0;
        front = 0;
        tail = queue.length - 1;

    }
}
