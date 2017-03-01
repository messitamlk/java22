package Uinon2;
import java.util.*;
public class ComputerAreaWithConstant {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final double PI = 3.1415926;
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a anumber for radius :");
		double radius = input.nextDouble();
		double area = radius * radius * PI;
		System.out.println("The area for circle of radius " +radius  +" is "  +area);
		
	}

}
