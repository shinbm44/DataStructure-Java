package list.LinkedList;

import list.Arraylist.ListInterface;

public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public LinkedList() {
        numItems = 0;
        head = new Node<E>(null, null);
    }

    // Node엔 item 필드 멤버 변수와 next가 있다

    // [알고리즘 5-10] 구현: 연결 리스트에 원소 x 삽입하기
    @Override
    public void add(int index, E x) {
        if (index < 0 || index > numItems) {
            System.out.println("잘못된 입력입니다.");
        } else {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node<E>(x,prevNode.next);
            prevNode.next = newNode;
            numItems++;
        }
    }

    @Override
    public void append(E x) {
        Node<E> prevNode = head;
        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }
        Node<E> newNode = new Node<E>(x, null);
        prevNode.next = newNode;
        numItems++;
    }

    // [알고리즘 5-12] 구현: 리스트의 원소 삭제하기
    @Override
    public E remove(int i) {
        if(i >= 0 && i < numItems) {
            Node<E> prevNode = getNode(i -1);
            Node<E> currNode = prevNode.next;
            prevNode.next = prevNode.next.next;
            numItems--;
            return currNode.item;
        } else {
            return null;
        }
    }

    @Override
    public boolean removeItem(E X) {
        Node <E> currNode = head;
        Node <E> prevNode;

        for (int i =0; i< numItems; i++){
            prevNode = currNode;
            currNode = currNode.next;
            if(((Comparable)currNode.item).compareTo(X) == 0)
                prevNode.next = currNode.next;
                numItems--;
                return true;
        }
        return false;
    }


    // [알고리즘 5-13] 구현: 연결 리스트의 k번째 원소 알려주기
    @Override
    public E get(int i) {
        if( i >= 0 || i <= numItems-1){
            return getNode(i).item;
        }
        return null;
    }

    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currNode = head;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else {
        return null;
        }
    }

    // [알고리즘 5-14] 구현:연결 리스트의 k번째 원소를 x로 대체하기
    @Override
    public void set(int i, E x) {
        if ( i >=0 && i <= numItems-1 ) {
            getNode(i).item = x;
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    // [알고리즘 5-15] 구현: 원소 x가 연결 리스트의 몇 번째 원소인지 알려주기

    public final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E x) {
        Node <E> currNode = head;
        for (int i =0; i < numItems; i++ ) {
            currNode = currNode.next;
            if(((Comparable)(currNode.item)).compareTo(x) == 0)
                return i;
        }
        return NOT_FOUND;
    }


    // [알고리즘 5-16(1)] 구현: 리스트의 총 원소 수 알려주기
    public int len() {
        return numItems;
    }

    // [알고리즘 5-16(2)] 구현: 리스트가 비었는지 알려주기
    public boolean isEmpty() {
        return numItems == 0;
    }

    // [알고리즘 5-16(3)] 구현: 리스트 깨끗이 청소하기
    public void clear() {
        numItems = 0;
        head = new Node<>(null, null);
    }

    public void printAll() {
        Node<E> t;
        System.out.print("Print list (#items=" + numItems + ") ");
        for(t=head.next; t != null; t = t.next) {
            System.out.print(t.item + " ");
        }
        System.out.println();
    }
}
