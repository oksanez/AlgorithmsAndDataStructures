package lessonTwo;

import java.util.Iterator;

public class Program {

    public static void main(String[] args) {
        /*int n = 10;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i * 2;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                arr[i]++;
            }
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + ", ");
        }*/

        MyArrayList<Character> list = new MyArrayList<>();
        list.add('z');
        list.add('d');
        list.add('x');
        list.add('r');
        list.add('f');
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.indexOf('c'));
        System.out.println(list.indexOf('x'));
        System.out.println(list.remove('b'));
        System.out.println(list.remove('x'));
        System.out.println(list);
        list.add('g');
        list.add('t');
        System.out.println(list);
        Iterator<Character> iterator = list.iterator();
        /*while (iterator.hasNext()) {
            Character c = iterator.next();
            System.out.print(c + ", ");
        }*/
        /*for (Character c :
             list) {
            System.out.print(c + ", ");
        }*/
        //list.selectionSort(new MyCharComparator());
        list.insertionSort(Character::compareTo);
        System.out.println(list);

        System.currentTimeMillis();
    }
}
