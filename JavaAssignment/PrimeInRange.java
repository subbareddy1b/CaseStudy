package JavaAssignment;

import java.util.Scanner;

public class PrimeInRange {
    public static void main(String[] args) {
        System.out.println("Enter a number greater than 2");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<2){
            System.out.println("0 prime numbers in the range specified");
        }
        int count;

		for(int i = 2 ; i <= n ; i++)
		{
			count = 0;
			for(int j = 1 ; j <= i ; j++)	
			{
				if(i % j == 0)
					count = count+1;
			}
			if(count == 2)
				System.out.println(i);
		}
        sc.close();
    }
}
