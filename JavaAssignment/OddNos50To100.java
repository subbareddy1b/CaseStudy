package JavaAssignment;

public class OddNos50To100 {
    public static void main(String[] args) {
        int num = 50;
        do {
            if(num%2 != 0){
                System.out.println(num);
            }

            num++;
        } while (num<=100);
    }
    
}
