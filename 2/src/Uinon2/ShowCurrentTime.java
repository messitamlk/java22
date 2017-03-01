package Uinon2;

public class ShowCurrentTime {
	public static void main (String[] args)
	{
		long totalMilliseconds = System.currentTimeMillis();
		long totalSeconds = totalMilliseconds/1000;
		long currentSecond =  totalSeconds%60;
		long totalMintes =  totalSeconds/60;
		long currentMintes = totalMintes%60;
		long totalHours = totalMintes /60;
		long currentHour = totalHours%24+7;
		System.out.println("Current time is "+currentHour+" : "+currentMintes+" : "+currentSecond+"GMT");
	}

}
