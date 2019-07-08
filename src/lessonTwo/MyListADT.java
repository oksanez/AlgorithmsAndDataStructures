package lessonTwo;

/**
 * Java. Алгоритмы и структуры данных. Урок 2
 * Реализация абстрактого типа данных "список" с помощью массивов
 *
 * @author Oksana Nezlobina
 * @version 2019-07-03
 */
public class MyListADT<El> {

    private int size = 0;
    private Object[] list = new Object[1];

    /**
     * Вспомогательный метод, который управляет размером массива
     * @param capacity - новая вместимость массива
     */
    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        System.arraycopy(list, 0, temp, 0, list.length);
//        for (int i = 0; i < size; i++) {
//            temp[i] = list[i];
//        }
        list = temp;
    }

    // Метод последовательного поиска, который ищет нужны элемент или сообщает что его нет
    public int indexOf(El myElement) {
        for (int i = 0; i < size ; i++) {
            if(list[i].equals(myElement)) return i;
        }
        return -1;
    }

    // Метод который проверяет есть ли такой элемент в списке
    public boolean contains(El myElement) {
        return indexOf(myElement) != -1;
    }

    // Получение размера массива
    public int size() {
        return size;
    }

    // Получение элемента по индексу
    public El get(int index) {
        if(index < 0 || index > size - 1 ) {
            throw new IndexOutOfBoundsException();
        }
        return (El) list[index];
    }

    // Замена элемента по индексу
    public void set(int index, El myElement) {
        if(index < 0 || index > size - 1 ) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = myElement;
    }

    // Добавление элемента в конец списка
    public void add(El myElement) {
        if(size == list.length) {
            resize(2 * list.length);
        }
        list[size] = myElement;
        size++;
    }

    // Удаление элемента
    public boolean remove(El myElement) {
        int index = indexOf(myElement);
        if (index == -1) return false;
        for (int i = index; i < size - 1 ; i++) {
            list[i] = list[i + 1];
        }
        list[size - 1] = null;
        size--;
        if (size == list.length / 4 && size > 0) {
            resize(list.length /2);
        }
        return true;
    }

    // Проверка, пустой ли список
    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i] + ", ");
        }
        return s.toString();
    }
}
