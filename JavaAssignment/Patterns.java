package JavaAssignment;

import java.util.Scanner;

public class Patterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println("===========================");

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(n);
            }
            System.out.println();
        }

        System.out.println("===========================");
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j<=n-i){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
                
            }
            
            System.out.println();
        }
        sc.close();
    }
    
}
