package JavaAssignment;

import java.util.Scanner;

public class PrimeOrNot {

    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }

        if(num==2){
            return true;
        }else if(num%2 == 0){
            return false;
        }else{
            for(int i=3;i<=Math.sqrt(num);i+=2){
                if(num%i == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean res = isPrime(n);
        if(res){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        sc.close();
    }
}
