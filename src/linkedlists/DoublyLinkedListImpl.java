package linkedlists;

import resources.Employee;

class DoublyLinkedListNode {
    private Employee employee;
    private DoublyLinkedListNode prev;
    private DoublyLinkedListNode next;

    public DoublyLinkedListNode(Employee employee) {
        this.employee = employee;
        this.prev = null;
        this.next = null;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPrev(DoublyLinkedListNode prev) {
        this.prev = prev;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public Employee getEmployee() {
        return employee;
    }

    public DoublyLinkedListNode getPrev() {
        return prev;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public String toString() {
        return employee.toString();
    }
}

class DoublyLinkedList {
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void addToFront(Employee employee) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(employee);
        if(isEmpty()) {
            tail = newNode;
        }
        else {
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        head = newNode;
        size++;
    }

    public void addToTail(Employee employee) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(employee);
        if(isEmpty()) {
            head = newNode;
        }
        else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }

    public DoublyLinkedListNode removeFromFront() {
        if(isEmpty()) {
            return null;
        }
        DoublyLinkedListNode nodeToRemove = head;
        if(head.getNext() == null) {
            tail = null;
        }
        else {
            head.getNext().setPrev(null);
        }
        head = head.getNext();
        nodeToRemove.setNext(null);
        size--;
        return nodeToRemove;
    }

    public DoublyLinkedListNode removeFromBack() {
        if(isEmpty()) {
            return null;
        }
        DoublyLinkedListNode nodeToRemove = tail;
        if(tail.getPrev() == null) {
            head = null;
        }
        else {
            tail.getPrev().setNext(null);
        }
        tail = tail.getPrev();
        nodeToRemove.setPrev(null);
        size--;
        return nodeToRemove;
    }

    public void printList() {
        if(isEmpty()) {
            return;
        }
        DoublyLinkedListNode curr = head;
        System.out.print("HEAD <-> ");
        while(curr != null) {
            System.out.print(curr.toString());
            System.out.print(" <-> ");
            curr = curr.getNext();
        }
        System.out.println("null");
    }
}

public class DoublyLinkedListImpl {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addToFront(new Employee(1, "Harry", "Potter"));
        linkedList.addToFront(new Employee(2, "Ron", "Weasley"));
        linkedList.addToFront(new Employee(3, "Hermione", "Granger"));
        System.out.println(linkedList.getSize());
        linkedList.printList();
        linkedList.addToTail(new Employee(4, "Neville", "longbottom"));
        linkedList.printList();
        linkedList.removeFromFront();
        linkedList.printList();
        linkedList.removeFromBack();
        linkedList.printList();
    }
}
