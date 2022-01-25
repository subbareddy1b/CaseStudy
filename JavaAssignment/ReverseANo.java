package JavaAssignment;

import java.util.Scanner;

public class ReverseANo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 0;
        while(n>0){
            int a = n%10;
            num = num*10 + a;
            n = n/10;
        }
        System.out.println("The reverse of the given number is = " + num);
        sc.close();
    }
}
