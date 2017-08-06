package cs115;

/**
 * Created by icyhot on 8/2/2017.
 */
public class Node {

    private Object object;
    private Node prev;
    private Node next;

    public Node(Object object) {
        this.object = object;
        prev = null;
        next = null;
    }

    public Node getPointerPrev() {
        return prev;
    }

    public Node getPointerNext() {
        return next;
    }

    public void setPointerPrev(Node node) {
        prev = node;
    }

    public void setPointerNext(Node node) {
        next = node;
    }
}
