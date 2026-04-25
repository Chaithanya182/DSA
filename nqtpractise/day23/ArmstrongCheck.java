import java.util.Scanner;

public class ArmstrongCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        int original = num;
        int sum = 0;
        int digits = 0;
        
        // Count digits
        int temp = num;
        while (temp > 0) {
            digits++;
            temp = temp / 10;
        }
        
        // Calculate sum of digits raised to power of digit count
        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            int power = 1;
            for (int i = 0; i < digits; i++) {
                power = power * digit;
            }
            sum += power;
            temp = temp / 10;
        }
        
        if (original == sum) {
            System.out.println(original + " is an Armstrong number");
        } else {
            System.out.println(original + " is not an Armstrong number");
        }
        
        sc.close();
    }
}