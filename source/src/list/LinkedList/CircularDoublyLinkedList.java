package list.LinkedList;

import list.Arraylist.ListInterface;

public class CircularDoublyLinkedList <E> implements ListInterface<E> {

    private BidirectionalNode<E> head;
    private int numItems;

    CircularDoublyLinkedList() {
        numItems = 0;
        head = new BidirectionalNode<>(null);
        head.prev = head;
        head.next = head;
    }

    @Override
    public void add(int index, E x) {
        if (index >= 0 && index <= numItems ) {
            BidirectionalNode<E> prevNode = getNode(index - 1);
            BidirectionalNode<E> newNode = new BidirectionalNode<>(prevNode, x, prevNode.next);
            BidirectionalNode<E> nextNode = newNode.next;
            prevNode.next = newNode;
            nextNode.prev = newNode;
            numItems++;
        }
    }

    @Override
    public void append(E x) {
        BidirectionalNode<E> prevNode = head.prev;
        BidirectionalNode<E> newNode = new BidirectionalNode<>(prevNode, x, head);
        prevNode.next = newNode;
        head.prev = newNode;
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= numItems - 1) {
            BidirectionalNode<E> currNode = getNode(index);
            BidirectionalNode<E> prevNode = currNode.prev;
            BidirectionalNode<E> nextNode = currNode.next;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            numItems--;
            return currNode.item;
        }
        return null;
    }

    @Override
    public boolean removeItem(E X) {
        BidirectionalNode<E> currNode = head;
        for (int i = 0; i <= numItems - 1; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(X) == 0) {
                BidirectionalNode<E> prevNode = currNode.prev;
                BidirectionalNode<E> nextNode = currNode.next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                numItems--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index < numItems) {
            return getNode(index).item;
        }
        return null;
    }

    private BidirectionalNode<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            BidirectionalNode<E> currNode = head;
            if (index < numItems / 2) {
                for (int i = 0; i <= index; i++) {
                    currNode = currNode.next;
                }
            } else {
                for (int i = numItems - 1; i >= index; i--) {
                    currNode = currNode.prev;
                }
            }
            return currNode;
        }
        return null;
    }


    @Override
    public void set(int index, E x) {
        if (index >= 0 && index < numItems) {
            getNode(index).item = x;
        }
    }

    public final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E x) {
        BidirectionalNode<E> currNode = head;
        for (int i = 0; i <= numItems - 1; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0) {
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
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        head.next = head;
        head.prev = head;
    }

    public void printAll() {
        BidirectionalNode<E> t;
        BidirectionalNode<E> currNode = head;
        System.out.print("Print list (#items=" + numItems + ") ");
        for (t = head.next; t != head; t = t.next)
            System.out.print(t.item + " ");
        System.out.println();
    }
}
