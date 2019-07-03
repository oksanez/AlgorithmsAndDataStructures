package lessonOne;

/**
 * Java. Алгоритмы и структуры данных. Урок 1
 */
public class Person {

    private String firstName;
    private String secondName;
    private int age;
    private boolean gender;

    public String getFirstName() { return firstName; }

    public String getSecondName() {
        if (gender) {
            return "Mr. " + secondName;
        }
        else {
            return "Ms. " + secondName;
        }
    }

    public int getAge() { return age; }

    public boolean isGender() { return gender; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setSecondName(String secondName) {this.secondName = secondName; }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст человкеа не можеть быть отрицательным!");
        }
        this.age = age;
    }

    public void setGender(boolean gender) { this.gender = gender; }

    public Person(String firstName, String secondName, int age, boolean gender) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAge(age);
        setGender(gender);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }

        Person that = (Person) obj;

        return this.firstName.equals(that.firstName) &&
                this.secondName.equals(that.secondName) &&
                this.age == that.age &&
                this.gender == that.gender;
    }


    public static void main(String[] args) {
        Person perOne = new Person("Oleg", "Leskov", 33, true);
        Person perTwo = perOne;
        Person perThree = new Person("Oleg", "Leskov", 33, true);

        //System.out.println(perOne.equals(perTwo));
        System.out.println(perOne.equals(perThree));
    }
}
