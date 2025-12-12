package queue;

import resources.Employee;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueJDK {
    public static void printQueue(Queue<Employee> queue) {
        System.out.println("------Queue-------");
        for(Employee employee: queue) {
            System.out.println(employee);
        }
        System.out.println("------------------");
    }
    public static void main(String[] args) {
        Queue<Employee> queue = new ArrayDeque<>();
        queue.offer(new Employee(1, "Harry", "Potter"));
        queue.offer(new Employee(2, "Ron", "Weasly"));
        queue.offer(new Employee(3, "Hermione", "Granger"));
        printQueue(queue);
        queue.offer(new Employee(4, "Neville", "Longbottom"));
        printQueue(queue);
        System.out.println(queue.poll());
        printQueue(queue);
        System.out.println(queue.peek());
        printQueue(queue);
    }
}
