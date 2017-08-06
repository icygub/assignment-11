package cs115;

/**
 * Created by icyhot on 8/2/2017.
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private DoublyLinkedListIterator iterator;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        this.iterator = new DoublyLinkedListIterator();
        size = 0;
    }

//    @Override
//    public int compareTo(Node node) {
//
//    }

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

    public void addInOrder(Object object){
        Node node = new Node(object);
        if(head == null) {
            head = node;
            tail = node;
        }
        else if(iterator.current.getData().compareToIgnoreCase(node.getData()) == 0) {
            //add node after current
            Node tmp = iterator.current.getPointerNext();
            node.setPointerPrev(iterator.current);
            iterator.current.setPointerNext(node);
            node.setPointerNext(tmp);
            tmp.setPointerPrev(node);
        }
        else{
            while(true) {
                if(iterator.current.getData().compareToIgnoreCase(node.getData()) > 0) { //if node is greater than current
                    if(iterator.current.getPointerPrev() == null)
                        head = node;
                    Node tmp = iterator.current.getPointerPrev();
                    node.setPointerNext(iterator.current);
                    iterator.current.setPointerPrev(node);
                    tmp.setPointerNext(node);
                    node.setPointerPrev(tmp);
                    break;
                }
                iterator.next();
            }
        }
        size++;


    }

    /**
     * Iterator Class
     */
    private class DoublyLinkedListIterator{
        private Node current;
        private int index;

        public DoublyLinkedListIterator() {
            current = head;
            index = 0;
        }

        public boolean hasNext() {
            return current.getPointerNext() != null;
        }

        public Node next() {
            current = current.getPointerNext();
            index++;
            return current;
        }

        public boolean hasPrevious() {
            return current.getPointerPrev() != null;
        }

        public Node previous() {
            current = current.getPointerPrev();
            index--;
            return current;
        }
    }
}
