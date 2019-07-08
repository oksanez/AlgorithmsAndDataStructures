package lessonTwo;

/**
 * Java. Алгоритмы и структуры данных. Урок 2
 *
 * @author Oksana Nezlobina
 * @version 2019-07-04
 */
public class LessonTwoMain {

    public static void main(String[] args) {

        /**
         * Задание №1
         */
        MyListADT<Character> list = new MyListADT<>();
        list.add('a');
        list.add('x');
        list.add('f');
        list.add('b');
        list.add('j');
        list.add('l');
        list.add('s');
        System.out.println("Массив: " + list);
        System.out.println("Размер массива: " + list.size());
        System.out.println("Содержит ли массив элемент a: " + list.contains('a'));
        System.out.println("Содержит ли массив элемент g: " + list.contains('g'));
        System.out.println("Получение элемента под индексом 2 = " + list.get(2));
        System.out.println("Замена элемента под индексом 2 на h. "); list.set(2, 'h');
        System.out.println("Получение элемента под индексом 2 = " + list.get(2));
        System.out.println("Удаление элемента l = " + list.remove('l'));
        System.out.println("Массив: " + list);
        System.out.println("Размер массива: " + list.size());

        System.out.println();

        /**
         *  Задание №2
         */
        MyArrayList<Integer> listCommon = fillingOfList();
        MyArrayList<Integer> listForSelectionSort = copyList(listCommon);
        MyArrayList<Integer> listForInsertionSort = copyList(listCommon);

        for (int i = 0; i <= 20; i++) {
            // Эксперимент сортировки выбором: вычисление времени выполнения
            System.out.println("Сортировка вставками: ");
            long startTime2 = System.currentTimeMillis();
            listForInsertionSort.insertionSort(Integer::compareTo);
            long endTime2 = System.currentTimeMillis();
            long resultTime2 = endTime2 - startTime2;
            System.out.println("Время сортировки вставкой: " + resultTime2);

            System.out.println();

            // Эксперимент сортировки выбором: вычисление времени выполнения
            System.out.println("Сортировка выбором:");
            long startTime1 = System.currentTimeMillis();
            listForSelectionSort.selectionSort(new MyIntComporator());
            long endTime1 = System.currentTimeMillis();
            long resultTime1 = endTime1 - startTime1;
            System.out.println("Время сортировки выбором: " + resultTime1);
        }
    }

    // Метод заполнения списка случайными числами
    public static MyArrayList<Integer> fillingOfList() {
        MyArrayList<Integer> list = new MyArrayList<>();
        int max = 100000;
        for (int i = 0; i < max; i++) {
            int a = (int)(Math.random() * 100 + 1);
            list.add(a);
        }
        return list;
    }

    // Метод поэлементного копирования списка
    public static MyArrayList<Integer> copyList(MyArrayList<Integer> list) {
        MyArrayList<Integer> newList = new MyArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        return newList;
    }
}