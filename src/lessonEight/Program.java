package lessonEight;

public class Program {
    public static void main(String[] args) {
//        MyChainingHashMap<Character, Integer> hashMap = new MyChainingHashMap<>();
//        hashMap.put('s', 1);
//        hashMap.put('e', 1);
//        hashMap.put('a', 1);
//        System.out.println(hashMap.contains('a'));
//        System.out.println(hashMap.contains('d'));
//        hashMap.put('r', 1);
//        hashMap.put('c', 1);
//        hashMap.put('h', 1);
//        hashMap.put('x', 1);
//        hashMap.put('x', 2);
//        hashMap.put('x', 3);
//        System.out.println(hashMap.contains('x'));
//        System.out.println(hashMap.size());


        MyLinearProbbingHashMap<Character, Integer> linearProbbingHashMap = new MyLinearProbbingHashMap<>();
        System.out.println(linearProbbingHashMap.size());
        linearProbbingHashMap.put('s', 1);
        linearProbbingHashMap.put('e', 1);
        linearProbbingHashMap.put('a', 1);
        linearProbbingHashMap.put('r', 1);
        linearProbbingHashMap.put('c', 1);
        linearProbbingHashMap.put('h', 1);
        System.out.println(linearProbbingHashMap.contains('x'));
        linearProbbingHashMap.put('x', 1);
        System.out.println(linearProbbingHashMap.contains('x'));
        linearProbbingHashMap.put('c', 1);
        linearProbbingHashMap.put('h', 2);
        linearProbbingHashMap.put('h', 3);
        System.out.println(linearProbbingHashMap.size());
    }
}
