class Person {
    private String name; private int age;

    //Default constructor
    public Person(){
        name = "unknown"; age = 0;
    }

    //Paramaterized constructor
    public Person(String name, int age){
        this.name = name; this.age = age;
    }

    public void introduce(){
        System.out.println("Hello!");
    }

    public String getName() { return name;}
}


public class practice {
    public static void main(String[] args){
        Person p1 = new Person();
        p1.introduce();
        System.out.println(p1.getName());
    }
}