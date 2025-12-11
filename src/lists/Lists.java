package lists;

import resources.Employee;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        // List<linkedlists.Employee> employeeList = new Vector<>(); // thread-safe ArrayList


        // adding at the end of the list
        employeeList.add(new Employee(1, "John", "Doe"));
        employeeList.add(new Employee(2, "Jane", "Jones"));
        employeeList.add(new Employee(3, "Harry", "Potter"));
        employeeList.forEach(employee -> System.out.println(employee));

        // accessing by index
        System.out.println(employeeList.get(2));

        // checking empty
        System.out.println(employeeList.isEmpty());

        // accessing the size
        System.out.println(employeeList.size());

        // updating by index
        employeeList.set(1, new Employee(2, "Hermione", "Granger"));
        System.out.println(employeeList.get(1));

        // adding at a particular index
        employeeList.add(1, new Employee(1, "Ron", "Weasley"));
        System.out.println(employeeList.get(1));

        // converting to an array
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for(Employee employee: employeeArray) {
            System.out.println(employee);
        }

        // checking whether an item exists in the list (equals method needs to be overridden)
        System.out.println(employeeList.contains(new Employee(3, "Harry", "Potter")));

        // accessing the index of an item
        System.out.println(employeeList.indexOf(new Employee(3, "Harry", "Potter")));

        // deleting an item
        employeeList.remove(0); // could also pass an item, but index is faster
        employeeList.forEach(employee -> System.out.println(employee));
    }
}
