package list.LinkedList;

public class BidirectionalNode <E> {
    public BidirectionalNode <E> prev;
    public BidirectionalNode <E> next;
    public E item;

    public BidirectionalNode() {
        prev = null;
        next = null;
        item = null;
    }

    public BidirectionalNode(E newItem) {
        prev = null;
        next = null;
        item = newItem;
    }

    public BidirectionalNode(BidirectionalNode<E> newPrev, E newItem, BidirectionalNode<E> newNext ) {
        prev = newPrev;
        item = newItem;
        next = newNext;
    }
}
