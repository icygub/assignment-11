package cs115;

import static org.junit.Assert.*;

/**
 * Created by icyhot on 8/5/2017.
 */
public class DoublyLinkedListTest {
    @org.junit.Test
    public void addToBeginning() throws Exception {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        for(int i = 0; i < 10; i++) {
            CourseOffering courseOffering = new CourseOffering(String.valueOf(i));
            Node node = new Node(courseOffering.getCourseName());
            doublyLinkedList.addToBeginning(node);
        }
    }

    @org.junit.Test
    public void addToEnd() throws Exception {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        for(int i = 0; i < 10; i++) {
            CourseOffering courseOffering = new CourseOffering(String.valueOf(i));
            Node node = new Node(courseOffering.getCourseName());
            doublyLinkedList.addToBeginning(node);
        }
    }

    @org.junit.Test
    public void addInOrder() throws Exception {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        for(int i = 0; i < 10; i++) {
            CourseOffering courseOffering = new CourseOffering(String.valueOf(i));
            Node node = new Node(courseOffering.getCourseName());
            doublyLinkedList.addToBeginning(node);
        }
    }

    @org.junit.Test
    public void find() throws Exception {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        for(int i = 0; i < 10; i++) {
            CourseOffering courseOffering = new CourseOffering(String.valueOf(i) + "hello");
            Node node = new Node(courseOffering.getCourseName());
            doublyLinkedList.addToEnd(node);
        }
        Node node = new Node("something");
        Node node2 = new Node("somethingsomethingsomething yeahyeahyeah");
        doublyLinkedList.addToEnd(node);
        doublyLinkedList.addToEnd(node2);
        System.out.println("asdfasdfasdfajdsfkajsdkfjkasjdkfjaksdjfkajsdkf");
        doublyLinkedList.print();

        System.out.println(doublyLinkedList.find(node2.getData()));
//        int index = doublyLinkedList.find(node.getData());
//        System.console().writer().println(index);
    }

    @org.junit.Test
    public void delete() throws Exception {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        for(int i = 0; i < 10; i++) {
            CourseOffering courseOffering = new CourseOffering(String.valueOf(i) + "hello");
            Node node = new Node(courseOffering.getCourseName());
            doublyLinkedList.addToEnd(node);
        }

        Node node = new Node("something");
        Node node2 = new Node("somethingsomethingsomething yeahyeahyeah");
        doublyLinkedList.addToEnd(node);
        doublyLinkedList.addToEnd(node2);
        doublyLinkedList.delete(node);
        doublyLinkedList.print();
    }


}