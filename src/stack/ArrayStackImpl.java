package stack;

import resources.Employee;

import java.util.EmptyStackException;

class ArrayStack {
    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return top == stack.length;
    }

    public int getSize() {
        return top;
    }

    public void push(Employee employee) {
        if(isFull()) {
            Employee[] newStack = new Employee[stack.length * 2];
            for(int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[top++] = employee;
    }

    public Employee pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[--top];
    }

    public Employee peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public void printStack() {
        System.out.println("-------Stack--------");
        for(int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
        System.out.println("--------------------");
    }
}

public class ArrayStackImpl {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(new Employee(1, "Harry", "Potter"));
        arrayStack.push(new Employee(2, "Ron", "Weasley"));
        arrayStack.push(new Employee(3, "Hermione", "Granger"));
        arrayStack.printStack();
        System.out.println(arrayStack.getSize());
        arrayStack.push(new Employee(4, "Neville", "Longbottom"));
        arrayStack.printStack();
        System.out.println(arrayStack.getSize());
        arrayStack.pop();
        arrayStack.printStack();
        System.out.println(arrayStack.getSize());
        System.out.println(arrayStack.peek());
        arrayStack.printStack();
        System.out.println(arrayStack.getSize());
    }
}
