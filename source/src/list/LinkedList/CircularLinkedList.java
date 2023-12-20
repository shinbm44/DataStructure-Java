package list.LinkedList;

import list.Arraylist.ListInterface;

public class CircularLinkedList<E> implements ListInterface<E> {
    private Node<E> tail;
    private int numItems;

    // 생성자
    public CircularLinkedList() {
        numItems =0;
        tail = new Node(-1);
        tail.next = tail;
    }

    // 특정 인덱스에 데이터 추가
    @Override
    public void add(int index, E x) {
        if ( index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index -1 );
            Node<E> newNode = new Node<E>(x, prevNode.next);
            prevNode.next = newNode;
            if (index == numItems){
                tail = newNode;
            }
            numItems++;
        }
    }

    // 맨 뒤에 데이터 추가
    @Override
    public void append(E x) {
        Node <E> prevNode = tail;
        Node <E> newNode = new Node<E>(x, tail.next);
        prevNode.next = newNode;
        tail = newNode;
        numItems++;
    }

    // 특정 인덱스의 데이터 지우기
    @Override
    public E remove(int index) {
        if (index >=0 && index <= numItems -1) {
            Node <E> prevNode = getNode(index -1);
            Node <E> currNode = getNode(index);
            E rItem = currNode.item;
            prevNode.next = prevNode.next.next;
            numItems--;
            if( index == numItems ){
                tail = prevNode;
            }
            return rItem;
        }
        return null;
    }

    // 특정 값을 지닌 인덱스의 노드 지우기
    @Override
    public boolean removeItem(E X) {
        Node <E> currNode = tail.next;
        Node <E> prevNode;

        for( int i =0; i <= numItems-1; i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if( ((Comparable)(currNode.item)).compareTo(X) == 0 ) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false;
    }

    // 연결 리스트의 k번째 원소 알려주기
    @Override
    public E get(int index) {
        if(index >= 0 && index < numItems ) {
            return getNode(index).item;
        }
        return null;
    }


    private Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems){
            Node<E> currNode = tail.next; // tail.next는 더미 헤드
            for(int i =0; i <= index; i++){
                currNode = currNode.next;
            }
            return currNode;
        }
        return null;
    }

    // 특정 인덱스의 값을 바꾸기
    @Override
    public void set(int index, E x) {
        if( index >= 0 && index <= numItems-1 ){
            getNode(index).item = x;
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    // 특정 값을 지닌 인덱스 값 알려주기
    public final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E x) {
        Node <E> currNode = tail.next;
        for (int i = 0; i<= numItems-1; i++) {
            currNode = currNode.next;
            if(((Comparable)(currNode)).compareTo(x) == 0 ){
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems==0;
    }

    @Override
    public void clear() {
        numItems=0;
        tail = new Node(-1);
        tail.next = tail;
    }

    public void printAll() {
        Node<E> head = tail.next; // 더미 헤드
        System.out.print("Print list (#items=" + numItems + ") ");
        for(Node<E> t=head.next; t != head; t = t.next)
            System.out.print(t.item + " ");
        System.out.println();
    }

}
