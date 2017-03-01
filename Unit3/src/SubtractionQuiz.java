import java.util.*;
public class SubtractionQuiz {

	public static void main(String[] args) {
		int number1 = (int )(Math.random()*10);
		int number2 = (int )(Math.random()*10);
		if(number1<number2){
			int t= number1;
			number1= number2;
			number2= t;
			}
		
		Scanner input = new Scanner(System.in);
		System.out.println("What is "+number1+" - "+number2+" ? ");
		int answer = input.nextInt();
		if(number1-number2 == answer){
			System.out.println("You are correct!");
		}
		else{
			System.out.println("You are wrong!");
			System.out.println(number1+" - "+number2+" should be "+(number1-number2));
		}
}
} 
