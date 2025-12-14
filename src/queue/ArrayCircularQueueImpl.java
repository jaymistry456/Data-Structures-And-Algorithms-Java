package queue;

import resources.Employee;

import java.util.NoSuchElementException;

class ArrayCircularQueue {
    private Employee[] circularQueue;
    private int front;
    private int back;

    public ArrayCircularQueue(int capacity) {
        circularQueue = new Employee[capacity];
        front = 0;
        back = 0;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        if(back >= front) {
            return back - front;
        }
        return back - front + circularQueue.length;
    }

    public void add(Employee employee) {
        if(getSize() == circularQueue.length - 1) {
            Employee[] newCircularQueue = new Employee[circularQueue.length * 2];
            int j = 0;
            for(int i = front; i < front + circularQueue.length; i++) {
                i %= circularQueue.length;;
                newCircularQueue[j] = circularQueue[i];
                j++;
            }
            circularQueue = newCircularQueue;
        }
        circularQueue[back++] = employee;
        if(back == circularQueue.length) {
            back = 0;
        }
    }

    public Employee remove() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        Employee employeeToRemove = circularQueue[front];
        circularQueue[front] = null;
        front++;
        if(front == circularQueue.length) {
            front = 0;
        }
        return employeeToRemove;
    }

    public Employee peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return circularQueue[front];
    }

    public void printQueue() {
        System.out.println("-------Queue-------");
        for(int i = front; i < front + getSize(); i++) {
            i %= circularQueue.length;
            System.out.println(circularQueue[i]);
        }
        System.out.println("-------------------");
    }
}

public class ArrayCircularQueueImpl {
    public static void main(String[] args) {
        ArrayCircularQueue circularQueue = new ArrayCircularQueue(3);
        circularQueue.add(new Employee(1, "Harry", "Potter"));
        circularQueue.add(new Employee(2, "Ron", "Weasley"));
        circularQueue.add(new Employee(3, "Hermione", "Granger"));
        circularQueue.add(new Employee(4, "Neville", "longbottom"));
        circularQueue.printQueue();
        circularQueue.remove();
        circularQueue.printQueue();
        System.out.println(circularQueue.peek());
        circularQueue.remove();
        circularQueue.remove();
        circularQueue.remove();
        circularQueue.add(new Employee(5, "Luna", "Lovegood"));
        circularQueue.add(new Employee(6, "Ginny", "Weasley"));
        circularQueue.add(new Employee(7, "Albus", "Dumbledore"));
        circularQueue.printQueue();
    }
}
