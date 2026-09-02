class Person {
    private String name; private int age;

    public Person(String name, int age){
        this.name = name; this.age = age;
    }

    public void introduce(){
        System.out.println("Hello!");
    }

    public int getAge() { return age;}
}


public class practice {
    public static void main(String[] args){
        Person p1 = new Person("Alice", 21);
        p1.introduce();
        System.out.println(p1.getAge());
    }
}
