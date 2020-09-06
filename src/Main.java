
// Main.java

import Task1.Task1;
import Task2.Task2;
import Task3.Task3;
import Task4.Task4;

public class Main {
	public static void main(String[] args) {
		println(1);
		new Task1().run();
		
		println(2);
		new Task2().run();
		
		println(3);
		new Task3().run();
		
		println(4);
		double networkInstability;
		networkInstability = 0.5;
		new Task4(networkInstability).run();

	}
	
	private static void println(int number) {
		System.out.println("Task " + number);
	}
}
