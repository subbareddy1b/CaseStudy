package JavaAssignment;

public class SwapNos {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
