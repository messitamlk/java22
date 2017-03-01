package Uinon2;
import java.util.*;
public class DisplayTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer for seconds: ");
		int seconds = input.nextInt();
		int minutes = seconds/60;
		int remainingSenconds = seconds%60;
		System.out.println(seconds+" seconds is " + minutes +" minutes and " +remainingSenconds+" seconds");
		
	}

}
