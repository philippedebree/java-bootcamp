public class ControlFlow {
    public static void main(String[] args) {
        int number = 4;

        if (number % 2 == 0){
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
        for (int i = 1; i <= 5 ; i++){
            System.out.println(i);
        }

        int count = 3;
        // TODO: while loop — countdown from 3 to 1 ("countdown " + count)

        while (count >=1){
            System.out.println("countdown " + count);
            count = count - 1;
        }


        int day = 2;
        // TODO: switch on day — 1 Monday, 2 Tuesday, default Other day

        String dayCheck = switch (day) {
            case 2 -> "Tuesday";
            default -> "Other day";
        };

        System.out.println(dayCheck);
    }
}
