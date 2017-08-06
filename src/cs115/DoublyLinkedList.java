package cs115;

/**
 * Created by icyhot on 8/2/2017.
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addToBeginning(Object object) {
        Node node = new Node(object);
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            head.setPointerPrev(node);
            node.setPointerNext(head);
            head = node;
        }
        size++;
    }

    public void addToEnd(Object object) {
        Node node = new Node(object);
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            tail.setPointerNext(node);
            node.setPointerPrev(tail);
            tail = node;
        }
        size++;
    }
}
