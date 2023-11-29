package list.LinkedList;

public class Node<E> {
    public E item;
    public Node<E> next;

    public Node(E newitem){
        item = newitem;
        next = null;
    }

    public Node(E newitem, Node<E> NextNode){
        item = newitem;
        next = NextNode;
    }
}
