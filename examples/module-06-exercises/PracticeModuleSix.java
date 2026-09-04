import java.util.List;
import java.util.Arrays;

@FunctionalInterface interface MyFuncInterface { void perform(String message);};

public class PracticeModuleSix {
    public static void main(String[] args) {
        MyFuncInterface obj = (message) -> System.out.println("Hello " + message);
        obj.perform("Java");

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n )
                .sorted()
                .forEach(System.out::println);
    }
}

