package Practice_package;

import java.util.Random;

public class Random_numbertest {

	public static void main(String[] args) {
		Random ran=new Random();
		int randomnum = ran.nextInt(100);
		System.out.println(randomnum);
	}

}
