package trees;

import resources.Employee;

import java.util.TreeMap;

public class TreeMapJDK {
    public static void printTreeMap(TreeMap<Integer, Employee> treeMap) {
        System.out.println("-------TreeMap-------");
        treeMap.forEach((k, v) -> System.out.println("Key: " + k + " Value: " + v));
        System.out.println("---------------------");
    }

    public static void main(String[] args) {
        TreeMap<Integer, Employee> treeMap = new TreeMap<>();
        treeMap.put(1, new Employee(1, "Harry", "Potter"));
        treeMap.put(2, new Employee(2, "Ron", "Weasley"));
        treeMap.put(3, new Employee(3, "Hermione", "Granger"));
        treeMap.put(4, new Employee(4, "Neville", "Longbottom"));
        treeMap.put(5, new Employee(5, "Luna", "Lovegood"));
        printTreeMap(treeMap);
        System.out.println(treeMap.get(3));
        treeMap.remove(3);
        printTreeMap(treeMap);
    }
}
