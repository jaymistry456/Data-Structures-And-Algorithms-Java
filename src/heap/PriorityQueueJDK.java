package heap;

import resources.Employee;

import java.util.PriorityQueue;

public class PriorityQueueJDK {
    public static void main(String[] args) {
        PriorityQueue<Employee> queue = new PriorityQueue<>(
                (e1, e2) -> {
                    // -1 if e1 comes before e2
                    // 0 if e1 and e2 are equal
                    // 1 if e1 comes after e2
                    int compare = e1.getLastName().compareTo(e2.getLastName()); // ascending order
                    // int compare = e2.getLastName().compareTo(e1.getLastName()); // descending order
                    if(compare != 0) {
                        return compare;
                    }
                    return Integer.compare(e1.getId(), e2.getId());
                }
        );
        queue.add(new Employee(1, "Harry", "Potter"));
        queue.add(new Employee(2, "Ron", "Weasley"));
        queue.add(new Employee(3, "Hermione", "Granger"));
        queue.add(new Employee(4, "Neville", "Longbottom"));
        queue.add(new Employee(5, "Luna", "Lovegood"));
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
