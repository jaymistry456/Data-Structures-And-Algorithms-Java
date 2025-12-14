package linkedlists;

import resources.Employee;

class LinkedListNode {
    private Employee employee;
    private LinkedListNode next;

    public LinkedListNode(Employee employee) {
        this.employee = employee;
        next = null;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public String toString() {
        return employee.toString();
    }
}

class SinglyLinkedList {
    private LinkedListNode head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addToFront(Employee employee) {
        LinkedListNode newNode = new LinkedListNode(employee);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public LinkedListNode removeFromFront() {
        if(isEmpty()) {
            return null;
        }
        LinkedListNode nodeToRemove = head;
        head = head.getNext();
        nodeToRemove.setNext(null);
        size--;
        return nodeToRemove;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return this.size;
    }

    public void printList() {
        if(isEmpty()) {
            return;
        }
        LinkedListNode curr = head;
        System.out.print("HEAD -> ");
        while(curr != null) {
            System.out.print(curr);
            System.out.print(" -> ");
            curr = curr.getNext();
        }
        System.out.println(" null");
    }
}

public class SinglyLinkedListImpl {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addToFront(new Employee(1, "Harry", "Potter"));
        linkedList.addToFront(new Employee(2, "Ron", "Weasley"));
        linkedList.addToFront(new Employee(3, "Hermione", "Granger"));
        linkedList.printList();
        linkedList.removeFromFront();
        linkedList.printList();
        System.out.println(linkedList.getSize());
    }
}
