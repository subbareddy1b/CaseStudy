package JavaAssignment;

import java.util.Scanner;

public class VowelOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        switch(Character.toLowerCase(ch)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("The entered character is a vowel");
                break;
            
            default:
                System.out.println("The entered character is not a vowel");

        }
        
        sc.close();
    }
    
}
