package lessonThree;

/**
 * Java. Алгоритмы и структуры данных. Урок 3
 *
 * Класс, который реализует метод переворачивания вводимых строк (читает справа налево)
 *
 * @author Oksana Nezlobina
 * @version 2019-07-08
 */
public class FromRightOnTheLeft {

    private String myWord;

    public FromRightOnTheLeft(String myWord) {
        this.myWord = myWord;
    }

    public String getInvertedWord() {

        MyArrayStack<Character> stack = new MyArrayStack<>();
        StringBuilder inverteWord = new StringBuilder();

        for (int i = 0; i <myWord.length(); i++) {
            Character c = myWord.charAt(i);
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            Character result = stack.pop();
            inverteWord.append(result);
        }
        return inverteWord.toString();
    }
}
