package hashtables;

import resources.Employee;

import java.util.HashMap;
import java.util.Map;

public class HashTableJDK {
    public static void printHashTable(Map<String, Employee> map) {
        System.out.println("-------HashTable-------");
        map.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        System.out.println("-----------------------");
    }
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<>();
        map.put("Potter", new Employee(1, "Harry", "Potter"));
        map.put("Weasley", new Employee(2, "Ron", "Weasley"));
        map.put("Granger", new Employee(3, "Hermione", "Granger"));
        printHashTable(map);
        System.out.println(map.get("Potter"));
        printHashTable(map);
        map.remove("Potter");
        printHashTable(map);
    }
}
