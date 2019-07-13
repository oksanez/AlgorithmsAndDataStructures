package lessonThree;

public class Program {
    public static void main(String[] args) {
//        MyArrayStack<Character> stack = new MyArrayStack<>();
//        stack.push('a');
//        stack.push('c');
//        stack.push('d');
//        stack.push('x');
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack);

//        //(a + 4) * [(b - 7) / {a - 5 * (c + 8)}]
//        //
//        //(a + 4) * {(b - 7) / {a - 5 * (c + 8)}]
//        //a + 4) * [(b - 7) / {a - 5 * (c + 8)}]
//        //(a + 4) * ([(b - 7) / {a - 5 * (c + 8)}]
//        Expression expr = new Expression("(a + 4) * ([(b - 7) / {a - 5 * (c + 8)}]");
//        System.out.println(expr.checkBrackets());

//        MyArrayQueue<Character> queue = new MyArrayQueue<>();
//        queue.enqueue('a');
//        queue.enqueue('b');
//        queue.enqueue('c');
//        queue.enqueue('d');
//        queue.enqueue('e');
//        System.out.println(queue);
//        System.out.println(queue.size());
//        System.out.println(queue.peekFront());
//        queue.dequeue();
//        System.out.println(queue.peekFront());
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        System.out.println(queue.isEmpty());
//        queue.enqueue('f');
//        queue.enqueue('g');
//        queue.enqueue('h');
//        System.out.println(queue);

        /**
         * Вызов метода переворачивания вводимых строк
         */
        FromRightOnTheLeft myMethod = new FromRightOnTheLeft("привет!");
        System.out.println(myMethod.getInvertedWord());

        /**
         * Проверка очереди Дек
         */
        MyDeque<Character> deque = new MyDeque<>();
        deque.insertRight('r');
        deque.insertRight('t');
        deque.insertRight('a');
        deque.insertRight('m');
        deque.insertRight('b');
        System.out.println(deque);
        System.out.println(deque.size());
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
        deque.insertLeft('g');
        deque.insertLeft('v');
        deque.insertLeft('w');
        deque.insertLeft('k');
        System.out.println(deque);
        System.out.println(deque.size());
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
        deque.removeLeft();
        System.out.println(deque);
        System.out.println(deque.size());
        deque.removeRight();
        deque.removeRight();
        deque.removeRight();
        deque.removeRight();
        System.out.println(deque);
        System.out.println(deque.size());
        deque.insertLeft('4');
        deque.insertLeft('5');
        deque.insertLeft('6');
        deque.insertLeft('7');
        System.out.println(deque);
        System.out.println(deque.size());
        deque.insertRight('l');
        deque.insertRight('h');
        System.out.println(deque);
        System.out.println(deque.size());
    }
}
