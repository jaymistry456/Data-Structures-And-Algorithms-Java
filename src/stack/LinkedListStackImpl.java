package stack;

import resources.Employee;

import java.util.Iterator;
import java.util.LinkedList;

class LinkedListStack {
    private LinkedList<Employee> stack;

    public LinkedListStack() {
        stack = new LinkedList<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public void printStack() {
        Iterator<Employee> iter = stack.iterator();
        System.out.println("-------Stack--------");
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("--------------------");
    }
}

public class LinkedListStackImpl {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(new Employee(1, "Harry", "Potter"));
        linkedListStack.push(new Employee(2, "Ron", "Weasly"));
        linkedListStack.push(new Employee(3, "Hermione", "Granger"));
        linkedListStack.printStack();
        linkedListStack.push(new Employee(4, "Neville", "Longbottom"));
        linkedListStack.printStack();
        linkedListStack.pop();
        linkedListStack.printStack();
        System.out.println(linkedListStack.peek());
        linkedListStack.printStack();
    }
}
