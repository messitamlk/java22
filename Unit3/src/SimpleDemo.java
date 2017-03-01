import java.util.*;
public class SimpleDemo {
public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.println("Enter an integer:");
	int number = input.nextInt();
	if(number%5==0)System.out.println("HiFive!");
	if(number%3==0)System.out.println("HiEven!");
}
}
