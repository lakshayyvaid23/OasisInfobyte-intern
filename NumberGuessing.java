package OasisInfobyte;
import java.util.Random;
import java.util.Scanner;


public class NumberGuessing {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int a = r.nextInt(1, 10);
        Boolean b =  true;
        while (b){
            System.out.println("Enter your Number from 1 to 10 :");
        int c = sc.nextInt();
        if(a == c){
            System.out.println("Congratulations............You Win");
        }
        }
    }
}
