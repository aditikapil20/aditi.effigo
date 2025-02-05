package localrepo;

import java.util.Scanner;

public class loops {
    
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the number of rows for the pyramid: ");
            int rows = s.nextInt();
            
            System.out.println("\nPyramid Pattern:");
            for (int i = 1; i <= rows; i++) {
                // Printing spaces
                for (int space = 1; space <= (rows - i); space++) {
                    System.out.print(" ");
                }
                // Printing stars
                for (int star = 1; star <= (2 * i - 1); star++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
