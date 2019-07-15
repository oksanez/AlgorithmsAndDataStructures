package lessonFour;

/**
 * Java. Алгоритмы и структуры данных. Урок 4
 *
 * @author Oksana Nezlobina
 * @version 2019-07-16
 */
public class MyLinkedStack<Item> {

    private MyLinkedList<Item> stack = new MyLinkedList<>();

    public int size() { return stack.size(); }

    public boolean isEmpty() {return stack.isEmpty(); }

    public void push(Item item) { stack.addLast(item);}

    public Item pop() { return stack.removeLast(); }

    public  String toString() { return stack.toString(); }

}
