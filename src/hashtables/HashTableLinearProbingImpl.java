package hashtables;

import resources.Employee;
import resources.StoredEmployee;

class HashTableLinearProbing {
    private StoredEmployee[] hashTable;

    public HashTableLinearProbing(int capacity) {
        hashTable = new StoredEmployee[capacity];
    }

    public int hashKey(String key) {
        return Math.abs(key.hashCode() % hashTable.length);
    }

    public boolean occupied(int index) {
        return hashTable[index] != null;
    }

    public void put(String key, Employee employee) {
        int hashKey = hashKey(key);
        if(occupied(hashKey)) {
            // linear probing
            int newIndex = (hashKey + 1) % hashTable.length;
            while(newIndex != hashKey && occupied(newIndex)) {
                newIndex = (newIndex + 1) % hashTable.length;
            }
            if(occupied(newIndex)) {
                System.out.println("HashTable is full");
            }
            else {
                hashTable[newIndex] = new StoredEmployee(key, employee);
            }
        }
        else {
            hashTable[hashKey] = new StoredEmployee(key, employee);
        }
    }

    public Employee get(String key) {
        int hashKey = hashKey(key);
        if(occupied(hashKey) && hashTable[hashKey].getKey().equals(key)) {
            return hashTable[hashKey].getEmployee();
        }
        int newIndex = (hashKey + 1) % hashTable.length;
        while(newIndex != hashKey) {
            if(!occupied(newIndex)) {
                return null;
            }
            if(occupied(newIndex) && hashTable[newIndex].getKey().equals(key)) {
                return hashTable[newIndex].getEmployee();
            }
            newIndex = (newIndex + 1) % hashTable.length;
        }
        return null;
    }

    public Employee remove(String key) {
        int hashKey = hashKey(key);
        if(occupied(hashKey) && hashTable[hashKey].getKey().equals(key)) {
            Employee valueToRemove = hashTable[hashKey].getEmployee();
            hashTable[hashKey] = null;
            rehash();
            return valueToRemove;
        }
        int newIndex = (hashKey + 1) % hashTable.length;
        while(newIndex != hashKey) {
            if(occupied(newIndex) && hashTable[newIndex].getKey().equals(key)) {
                Employee valueToRemove = hashTable[newIndex].getEmployee();
                hashTable[newIndex] = null;
                rehash();
                return valueToRemove;
            }
            newIndex = (newIndex + 1) % hashTable.length;
        }
        return null;
    }

    public void rehash() {
        StoredEmployee[] oldHashTable = hashTable;
        hashTable = new StoredEmployee[oldHashTable.length];
        for(int i = 0; i < oldHashTable.length; i++) {
            if(oldHashTable[i] != null) {
                put(oldHashTable[i].getKey(), oldHashTable[i].getEmployee());
            }
        }
    }

    public void printHashTable() {
        System.out.println("-------HashTable-------");
        for(int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] != null) {
                System.out.println("Key: " + i + " Value: " + hashTable[i].getEmployee());
            }
            else {
                System.out.println("Key: " + i + " Value: null");
            }
        }
        System.out.println("-----------------------");
    }
}

public class HashTableLinearProbingImpl {
    public static void main(String[] args) {
        HashTableLinearProbing hashTable = new HashTableLinearProbing(10);
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
