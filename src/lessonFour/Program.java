package lessonFour;

public class Program {
    public static void main(String[] args) {
        MyLinkedList<Character> linkedList = new MyLinkedList<>();
        linkedList.addFirst('k');
        linkedList.addFirst('l');
        linkedList.addFirst('m');
        linkedList.addLast('a');
        linkedList.addLast('b');
        linkedList.addLast('c');
        System.out.println(linkedList.size());
        System.out.println(linkedList);
        System.out.println("с индексом 1: " + linkedList.get(1));
        System.out.println("с индексом 4: " + linkedList.get(4));
        linkedList.set(1, 'd');
        linkedList.set(5, 'y');
        System.out.println(linkedList);
        linkedList.add(2, 'g');
        linkedList.add(4, 'x');
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
        linkedList.addFirst('e');
        linkedList.addLast('f');
        linkedList.add(2, 'g');
        System.out.println(linkedList);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList);
        System.out.println(linkedList.indexOf('z'));
        System.out.println(linkedList.size());
        linkedList.remove('c');
        //System.out.println(linkedList);
        for (Character c:
                linkedList) {
            System.out.print(c + ", ");
        }

    }
}
