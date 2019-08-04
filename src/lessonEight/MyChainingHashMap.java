package lessonEight;

/**
 * Решении коллиизии с помощью цечки (связного списка)
 * @param <Key>
 * @param <Value>
 */

//public class MyTreeMap<Key extends Comparable<Key>, Value> {
public class MyChainingHashMap<Key, Value> {
    private int M = 5; //
    private int size = 0;
    private Object[] st = new Object[M];
    private class Node {
        Key key;
        Value value;
        Node next;

        private Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public Value get(Key key) { //a[key]
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        int h = hash(key);
        Node currentNode = (Node) st[h];
        while (currentNode != null) {
            if (key.equals(currentNode.key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contains(Key key) { return get(key) != null; }

    public  void put(Key key, Value value) { //a[key] = value
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value can not be null.");
        }
        int h = hash(key);
        Node currentNode = (Node) st[h];
        while (currentNode != null) {
            if (key.equals(currentNode.key)) {
                currentNode.value = value;
                return;
            }
            currentNode = currentNode.next;
        }
        st[h] = new Node(key, value, (Node) st[h]);
        size++;
    }
}
