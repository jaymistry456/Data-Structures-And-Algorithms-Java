package queue;

import resources.Employee;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class LinkedListQueue {
    private LinkedList<Employee> queue;

    public LinkedListQueue() {
        queue = new LinkedList<Employee>();
    }

    public void add(Employee employee) {
        queue.addLast(employee);
    }

    public Employee remove() {
        if(queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }

    public Employee peek() {
        if(queue.isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }

    public void printQueue() {
        System.out.println("-------Queue-------");
        for (Employee employee : queue) {
            System.out.println(employee);
        }
        System.out.println("-------------------");
    }
}

public class LinkedListQueueImpl {
    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.add(new Employee(1, "Harry", "Potter"));
        linkedListQueue.add(new Employee(2, "Ron", "Weasley"));
        linkedListQueue.add(new Employee(3, "Hermione", "Granger"));
        linkedListQueue.printQueue();
        linkedListQueue.add(new Employee(4, "Neville", "Longbottom"));
        linkedListQueue.printQueue();
        linkedListQueue.remove();
        linkedListQueue.printQueue();
        System.out.println(linkedListQueue.peek());
        linkedListQueue.printQueue();
    }
}
