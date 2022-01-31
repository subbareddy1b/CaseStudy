package JavaAssignment;

import java.util.*;
public class SwapNos{

	public static void swap(int arr[]) {
		int i=0;
		int j=1;
		int k=0;
		int res[] = new int[arr.length];
		while(i<arr.length&&j<arr.length) {
		res[k] = arr[j];
		k++;
		res[j] =arr[i];
		k++;
		i = j+1;
		j = i+1;
		
		}
		
		while(i<arr.length) {
			res[i] = arr[i];
			i++;
		}
		
		for(int i1=0;i1<arr.length;i1++) {
			System.out.print(res[i1]+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Array Size : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
       swap(arr);
	}

}
