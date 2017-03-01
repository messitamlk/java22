import java.util.*;
public class TowerOfHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner input =new Scanner(System.in);
System.out.print("Enter numner of disks: ");
int n =input.nextInt();
System.out.println("The move are:");
MoveDisks(n,'A','C','B');

}
public static void MoveDisks(int n,char fromTower,char toTower,char auxTower){
	if(n==1)System.out.println("Move disk " + n +" from " +fromTower +" to "+ toTower);
	else{
		MoveDisks(n-1,fromTower,auxTower,toTower);
		System.out.println("Move disk " + n +" from " +fromTower +" to "+ toTower);
		MoveDisks(n-1,auxTower,toTower,fromTower);
		
		
	}
}
	}
