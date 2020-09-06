
// Task4Thread.java

package Task4;

import Task2.Task2;
import Task3.Task3Thread;

public class Task4Thread extends Task3Thread {
	private final double failureRate;
	
	public Task4Thread(Task2 task2, int column, int row, double[][] data, double failureRate) {
		super(task2, column, row, data);
		this.failureRate = failureRate;
	}
	
	public void run() {
		if (failureRate <= Math.random()) {
			super.run();
		}
	}
}
