package lessonSix;

import java.util.NoSuchElementException;
import java.util.Optional;

public class MyTreeMap<Key extends Comparable<Key>, Value> {

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size; //кол-во узлов в дереве, корнем которого является данный узел
        int height; //высота дерева
        public Node(Key key, Value value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    private Node root = null; // Вершина дерева, от которого идем

    // Проверка на пустоту списка
    public boolean isEmpty() { return root == null; }

    /**
     * Получение размера дерева (количество узлов)
     * @return int размер
     */
    public int size() { return size(root); }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    /**
     * Получение высоты дерева
     * @return int размер
     */
    public int height() { return height(root); }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
//        if (node.size == 1) {
//            return 0;
//        }
        else {
            return node.height;
        }
    }

    /**
     * Получение значения узла по ключу
     * @param key - ключ (в нашем примере символы)
     * @return
     */
    public Value get(Key key) { return get(key, root); }

    private Value get(Key key, Node node) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        }
        if (cmp < 0) {
            return get(key, node.left);
        }
        else { //cmp > 0
            return get(key, node.right);
        }
    }

    /**
     * Вставка узла
     * @param key - ключ (в нашем примере символы)
     * @param value - значение (в нашем примере индекс)
     */
    public void put(Key key, Value value) { root = put(key, value, root); } //a[key] = value;

    private Node put(Key key, Value value, Node node) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        if (node == null) {
            return new Node(key, value, 1, 0);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        }
        else if (cmp < 0) {
            node.left = put(key, value, node.left);
        }
        else { //cmp > 0
            node.right = put(key, value, node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        // Обновляем высоту
        if(height(node.right) > height(node.left)) {
            node.height = height(node.right) + 1;
        } else if(height(node.right) < height(node.left)) {
            node.height = height(node.left) + 1;
        } else if(height(node.right) == height(node.left)) {
            node.height = height(node.right) + 1;
        }
        return node;
    }

    /**
     * Получение самого максимального узла (самый самый правый узел)
     * @return
     */
    public Value max() {
        return max(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        }
        else {
            return max(node.right);
        }
    }

    /**
     * Получение самого минимального узла (самый самый левый узел)
     * @return
     */
    public Value min() { return min(root).value; }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        else {
            return min(node.left);
        }
    }

    /**
     * Удаление самого минимального узла
     */
    public void removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Map is empty.");
        }
        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        else {
            node.left = removeMin(node.left);
        }
        node.size = size(node.left) + size(node.right) + 1;
        // Обновляем высоту
        if(height(node.right) > height(node.left)) {
            node.height = height(node.right) + 1;
        } else if(height(node.right) < height(node.left)) {
            node.height = height(node.left) + 1;
        } else if(height(node.right) == height(node.left)) {
            node.height = height(node.right) + 1;
        }
        return node;
    }

    /**
     * Удаление самого максимального узла
     */
    public void removeMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Map is empty.");
        }
        root = removeMax(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        else {
            node.right = removeMin(node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        // Обновляем высоту
        if(height(node.right) > height(node.left)) {
            node.height = height(node.right) + 1;
        } else if(height(node.right) < height(node.left)) {
            node.height = height(node.left) + 1;
        } else if(height(node.right) == height(node.left)) {
            node.height = height(node.right) + 1;
        }
        return node;
    }

    /**
     * Удаление узла по ключу
     * @param key - ключ ( нашем примере символы)
     */
    public void remove(Key key) {remove(key, root);}

    private Node remove(Key key, Node node) {
        if (key == null) {
            throw new IllegalArgumentException("Key can not be null.");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) { //remove
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node tmp = node;
            node = max(node.left);
            node.left = removeMax(tmp.left);
            node.right = tmp.right;
            tmp = null;
        }
        else if (cmp < 0) {
            node.left = remove(key, node.left);
        }
        else { //cmp > 0
            node.right = remove(key, node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        // Обновляем высоту
         if(height(node.right) > height(node.left)) {
            node.height = height(node.right) + 1;
        } else if(height(node.right) < height(node.left)) {
            node.height = height(node.left) + 1;
        } else if(height(node.right) == height(node.left)) {
            node.height = height(node.right) + 1;
        }
        return node;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        boolean result = false;
        if(node == null) {
            result = true;
        }
        if (node.left == null) {
            result = true;
        } else if (node.right == null) {
            result = true;
        } else if(height(node.right) > height(node.left)) {
            result = (height(node.right) - height(node.left)) <= 1;
        } else if(height(node.right) < height(node.left)) {
            result = (height(node.left) - height(node.right)) <= 1;
        } else if(height(node.right) == height(node.left)) {
            result = true;
        }
        return result;
    }
}