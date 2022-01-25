package JavaAssignment;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a%2==0){
            System.out.println(a+" is an even number");
        }else{
            System.out.println(a+" is an odd number");
        }

        sc.close();
    }
    
}
