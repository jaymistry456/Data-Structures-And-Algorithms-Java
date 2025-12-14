package linkedlists;

import resources.Employee;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListJDK {

    public static void printList(LinkedList<Employee> linkedList) {
        Iterator<Employee> iter = linkedList.iterator();
        System.out.print("HEAD <-> ");
        while(iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <-> ");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList<Employee> linkedList = new LinkedList<>();
        linkedList.addFirst(new Employee(1, "Harry", "Potter"));
        linkedList.addFirst(new Employee(2, "Ron", "Weasley"));
        linkedList.addFirst(new Employee(3, "Hermione", "Granger"));
        printList(linkedList);
        linkedList.addLast(new Employee(4, "Neville", "Longbottom"));
        printList(linkedList);
        linkedList.removeFirst();
        printList(linkedList);
        linkedList.removeLast();
        printList((linkedList));
    }

}
