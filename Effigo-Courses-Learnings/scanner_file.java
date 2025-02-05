import java.util.Scanner;

public class scanner_file {
    public static void main(String[] args) {
        System.out.println("hey, enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine(); 
        scanner.close();
        System.out.println("okayyyy!!!! "+ name + " bye!");
    }
}
