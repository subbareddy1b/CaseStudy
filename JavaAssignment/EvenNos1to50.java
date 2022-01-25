package JavaAssignment;

import java.util.Scanner;

public class EvenNos1to50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1;
        while(num<=50){
            if(num%2==0){
                System.out.println(num);
            }
            
            num++;
        }
        sc.close();
    }
}
