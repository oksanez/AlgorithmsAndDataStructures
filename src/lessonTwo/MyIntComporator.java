package lessonTwo;

import java.util.Comparator;

/**
 * Java. Алгоритмы и структуры данных. Урок 2
 *
 * @author Oksana Nezlobina
 * @version 2019-07-04
 */
public class MyIntComporator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
