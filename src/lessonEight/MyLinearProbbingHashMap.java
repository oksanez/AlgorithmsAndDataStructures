package lessonEight;

/**
 * Решении коллиизии с помощью открытой адресанции (линейного пробирования)
 * @param <Key>
 * @param <Value>
 */
public class MyLinearProbbingHashMap<Key, Value> {
    private int M = 5;
    private int size = 0;
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

    private int hash(Key key) {return (key.hashCode() & 0x7fffffff) % M; }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        int h = hash(key); // создаем хеш ключа
        for (int i = h; keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return (Value) values[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) { return get(key) != null; }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value can not be null.");
        }
        if (size == M - 1) {
            throw new IndexOutOfBoundsException();
        }
        int i;
        int h = hash(key);
        for (i = h; keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }
}
