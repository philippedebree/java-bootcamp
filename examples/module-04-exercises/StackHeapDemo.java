public class StackHeapDemo {
    static class Person {
        String name;
        Person(String name) {
            this.name = name;
        }
    }

    static void printPerson(Person person) {
        int nameLength = person.name.length();
        System.out.printf("%s has %d letters.%n", person.name, nameLength);
    }

    public static void main(String[] args) {
        int count = 1;
        Person person = new Person("Aman");
        printPerson(person);
        System.out.println("Count: " + count);
    }
}
