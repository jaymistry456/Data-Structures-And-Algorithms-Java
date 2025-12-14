package hashtables;

import resources.Employee;
import resources.StoredEmployee;
import java.util.LinkedList;
import java.util.ListIterator;

class HashTableChaining {
    private LinkedList<StoredEmployee>[] hashTable;

    public HashTableChaining(int capacity) {
        hashTable = new LinkedList[capacity];
    }

    public int hashKey(String key) {
        return Math.abs(key.hashCode() % hashTable.length);
    }

    public void put(String key, Employee employee) {
        int hashKey = hashKey(key);
        if(hashTable[hashKey] == null) {
            hashTable[hashKey] = new LinkedList<StoredEmployee>();
        }
        hashTable[hashKey].addFirst(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashKey = hashKey(key);
        if(hashTable[hashKey] == null) {
            return null;
        }
        ListIterator<StoredEmployee> iterator = hashTable[hashKey].listIterator();
        while(iterator.hasNext()) {
            StoredEmployee storedEmployee = iterator.next();
            if(storedEmployee.getKey().equals(key)) {
                return storedEmployee.getEmployee();
            }
        }
        return null;
    }

    public Employee remove(String key) {
        int hashKey = hashKey(key);
        if(hashTable[hashKey] == null) {
            return null;
        }
        ListIterator<StoredEmployee> iterator = hashTable[hashKey].listIterator();
        while(iterator.hasNext()) {
            StoredEmployee storedEmployee = iterator.next();
            if(storedEmployee.getKey().equals(key)) {
                iterator.remove();
                return storedEmployee.getEmployee();
            }
        }
        return null;
    }

    public void printHashTable() {
        System.out.println("-------HashTable-------");
        for(int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] == null) {
                System.out.println("Key: " + i + " Value: null");
            }
            else {
                System.out.print("Key: " + i + " Value: ");
                for(StoredEmployee storedEmployee: hashTable[i]) {
                    System.out.print(storedEmployee.getEmployee());
                    System.out.print(" -> ");
                }
                System.out.println("null");
            }
        }
        System.out.println("-----------------------");
    }
}

public class HashTableChainingImpl {
    public static void main(String[] args) {
        HashTableChaining hashTable = new HashTableChaining(10);
        hashTable.put("Potter", new Employee(1, "Harry", "Potter"));
        hashTable.put("Weasley", new Employee(2, "Ron", "Weasley"));
        hashTable.put("Granger", new Employee(3, "Hermione", "Granger"));
        hashTable.put("Longbottom", new Employee(4, "Neville", "Longbottom"));
        hashTable.put("Lovegood", new Employee(5, "Luna", "Lovegood"));
        hashTable.printHashTable();
        System.out.println(hashTable.get("Potter"));
        System.out.println(hashTable.get("Dumbledore"));
    }
}
