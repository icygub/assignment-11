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

    public void addToBeginning(Node node) {
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

    public void addToEnd(Node node) {
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

    public void delete(Node node) {
        iterator.index = 0;
        iterator.current = head;

        while(iterator.hasNext()) {
            if(node == iterator.current) {
                if(iterator.current == head) { //deleting the head
                    System.out.println("1");
                    head.setPointerNext(null);
                    iterator.next().setPointerPrev(null);
                    head = iterator.current;
                }else if(iterator.current == tail) { //deleting the tail
                    System.out.println("2");
                    tail.setPointerPrev(null);
                    iterator.previous().setPointerNext(null);
                    tail = iterator.current;
                }else { //anything else
                    System.out.println("3");
                    Node tmp = iterator.current.getPointerNext();
                    tmp.setPointerPrev(iterator.current.getPointerPrev());
                    iterator.current.getPointerPrev().setPointerNext(tmp);
                    iterator.current.setPointerNext(null); //not sure if this is okay?
                    iterator.current.setPointerPrev(null); //same with this
                }
                break;
            } else
                iterator.next();
        }
        size--;
    }

    public void print() {
        iterator.current = head;
        iterator.index = 0;

        do{
            System.out.println(iterator.current.getData());
            iterator.next();
        }while(iterator.hasNext());
        System.out.println(iterator.current.getData());

    }

    public void addInOrder(Node node){
        iterator.current = head;
        iterator.index = 0;

        System.out.println(iterator.current.getData());

        //Node node = new Node(object);
        if(head == null) {
            head = node;
            tail = node;
        }
        else {
            for(int i = 0; i < size; i++) {
                if(iterator.current.getData().compareToIgnoreCase(node.getData()) == 0) {
                    //add node after current
                    Node tmp = iterator.current.getPointerNext();
                    node.setPointerPrev(iterator.current);
                    iterator.current.setPointerNext(node);
                    node.setPointerNext(tmp);
                    tmp.setPointerPrev(node);
                }
                else if(iterator.current.getData().compareToIgnoreCase(node.getData()) > 0) { //if node is greater than current
                    if(iterator.current.getPointerPrev() == head)
                        head = node;
                    Node tmp = iterator.current.getPointerPrev();
                    node.setPointerNext(iterator.current);
                    iterator.current.setPointerPrev(node);
                    tmp.setPointerNext(node);
                    node.setPointerPrev(tmp);
                    break;
                }
                else if(iterator.current.getData().compareToIgnoreCase(node.getData()) < 0) { //if node is less than current
                    if(iterator.current == tail)
                        tail = node;

                }
                iterator.next();
            }
        }
        size++;


    }

    public int find(String string) {
        iterator.current = head;
        iterator.index = 0;
        for(int i = 0; i < size; i++) {
            if(iterator.current.getData().equalsIgnoreCase(string))
                return iterator.index;
            else if(iterator.hasNext()) {
                iterator.next();
                iterator.index++;
            }

        }

        return -1; //it was not found
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
