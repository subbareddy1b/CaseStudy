package JavaAssignment;

import java.util.Scanner;

public class Factorial {

    public static int getFactorial(int n){
        if(n==1){
            return 1;
        }
        return n*getFactorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getFactorial(n));
        sc.close();
    }
}
