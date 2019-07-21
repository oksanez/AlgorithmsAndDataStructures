package lessonThree;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Java. Алгоритмы и структуры данных. Урок 3
 *
 * @author Oksana Nezlobina
 * @version 2019-07-09
 */
public class MyDeque<Item> {

    private int size = 0;
    private Object[] queue = new Object[1];
    private int left = 0;
    private int right = 0;

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmp[i] = queue[(i + left) % queue.length];
        }
        left = 0;
        right = size;
        queue = tmp;
    }

    public void insertLeft(Item item) {
        if (size == queue.length) {
            resize(queue.length * 2);
        }
        if(left > 0) {
            left--;
        } else {
            left = queue.length - 1;
        }
        queue[left] = item;
        size++;
    }

    public void insertRight(Item item) {
        if (size == queue.length) {
            resize(queue.length * 2);
        }
        queue[right++] = item;
        right %= queue.length; // перенесли right на 0 если right совпала с длиной очереди
        size++;

    }

    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Item item = (Item) queue[left];
        queue[left] = null;
        size--;
        left = (left + 1) % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;

    }

    public Item removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Item item = (Item) queue[right - 1];
        queue[right - 1] = null;
        size--;
        right = (right - 1) % queue.length;
        if (size == queue.length / 4 && size > 0) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peekLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return (Item) queue[left];
    }

    public Item peekRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return (Item) queue[right - 1];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append((queue[(i + left) % queue.length] + ", "));
        }
        return s.toString();
    }
}
