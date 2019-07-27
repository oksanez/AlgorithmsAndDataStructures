package lessonSix;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        MyTreeMap<Character, Integer> treeMap = new MyTreeMap<>();
        System.out.println("Проверяем пустое ли дерево: " + treeMap.isEmpty());
        System.out.println("Количество узлов в дереве = " + treeMap.size());
        treeMap.put('S', 1);
        treeMap.put('E', 2);
        treeMap.put('A', 3);
        treeMap.put('R', 4);
        treeMap.put('C', 5);
        treeMap.put('H', 6);
        System.out.println("Количество узлов в дереве = " + treeMap.size());
        System.out.println("Индекс максимального узла: " + treeMap.max());
        treeMap.put('X', 8);
        treeMap.put('M', 9);
        System.out.println("Проверяем пустое ли дерево: " + treeMap.isEmpty());
        System.out.println("Получаем индекс узла: " + treeMap.get('E'));
        System.out.println("Индекс максимального узла: " + treeMap.max());
        System.out.println("Индекс минимального узла: " + treeMap.min());
        treeMap.remove('R');

        binaryTree();


    }

    public  static  void binaryTree(){

        int count = 1000;

        int min = -100;
        int max = 100;
        Random rnd = new Random();

        int notBalancedTree = 0;

        for (int i = 0; i <= count ; i++) {
            MyTreeMap<Integer, Integer> treeMap = new MyTreeMap<>();
            System.out.println("Дерево № " + i);
            while (treeMap.height() < 6) {
                int key = min + rnd.nextInt(max - min + 1);
                int value = rnd.nextInt(100);
                treeMap.put(key, value);
                System.out.println("Заполненный узел: key = " + key +", value = " + value + ". И высота = " + treeMap.height());

            }
            System.out.println("Сбалансированно ли дерево: " + treeMap.isBalanced());
            if(!treeMap.isBalanced()) {
                notBalancedTree++;
            }
        }
        System.out.println("Количество несбалансированных деревьев: " + notBalancedTree);
        System.out.println("Процент несбалансированных деревьев: " + ((double) notBalancedTree * 100 / count));
    }
}