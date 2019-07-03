package lessonOne;

/**
 * Java. Алгоритмы и структуры данных. Урок 1
 */
public class Program {

    public static void main(String[] args) {
        int a = 5;
        //int b = a;
        int b = 5;

        Person p1 = new Person("Andrey", "Limasov", 32, true);
        //lessonOne.Person p2 = p1;
        Person p2 = new Person("Andrey", "Limasov", 32, true);

        //b++;
        //p2.setAge(18);

        //System.out.println(a);
        //System.out.println(p1.getAge());

        //Передача параметров в метод
        //1. Передача по значению
        //2. Передача по ссылке
        //changePrimiteve(a);
        //changeRef(p1);
        //System.out.println(a);
        //System.out.println(p1.getFirstName());

        if (a == b) {
            System.out.println("Переменные равны");
        }
        else {
            System.out.println("Переменные неравны");
        }

        //equals
        //toString
        if (p1.equals(p2)) {
            System.out.println("Переменные равны");
        }
        else {
            System.out.println("Переменные неравны");
        }
    }

    public static void changePrimiteve(int x) { x++; }

    public static void changeRef(Person person) { person.setFirstName("Ivan"); }
}
