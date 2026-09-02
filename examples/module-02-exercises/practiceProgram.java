import java.util.ArrayList;

public class practiceProgram {
    public static int convert() {
        double test = 24.0;
        int output = (int) test;
        return output;
    }

    public static ArrayList<String>  exampleImport(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");

        return list;
    }

    public static void main(String[] args){
        practiceProgram test = new practiceProgram();
        System.out.println(convert());
        System.out.println(exampleImport());
    }
}