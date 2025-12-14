package queue;

import resources.Employee;
import java.util.NoSuchElementException;

class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
        front = 0;
        back = 0;
    }

    public int getSize() {
        return back - front;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean isFull() {
        return back == queue.length;
    }

    public void add(Employee employee) {
        if(isFull()) {
            Employee[] newQueue = new Employee[queue.length * 2];
            for(int i = front; i < back; i++) {
                newQueue[i] = queue[i];
            }
            queue = newQueue;
        }
        queue[back++] = employee;
    }

    public Employee remove() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Employee itemToRemove = queue[front];
        queue[front] = null;
        front++;
        if(isEmpty()) {
            front = 0;
            back = 0;
        }
        return itemToRemove;
    }

    public Employee peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public void printQueue() {
        System.out.println("-------Queue-------");
        for(int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
        System.out.println("-------------------");
    }
}

public class ArrayQueueImpl {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        arrayQueue.add(new Employee(1, "Harry", "Potter"));
        arrayQueue.add(new Employee(2, "Ron", "Weasley"));
        arrayQueue.add(new Employee(3, "Hermione", "Granger"));
        arrayQueue.printQueue();
        System.out.println(arrayQueue.getSize());
        arrayQueue.add(new Employee(4, "Neville", "Longbottom"));
        arrayQueue.printQueue();
        System.out.println(arrayQueue.getSize());
        arrayQueue.remove();
        arrayQueue.printQueue();
        System.out.println(arrayQueue.getSize());
        System.out.println(arrayQueue.peek());
        arrayQueue.printQueue();
        System.out.println(arrayQueue.getSize());
    }
}
