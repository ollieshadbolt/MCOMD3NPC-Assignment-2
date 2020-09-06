
// Task3Thread.java

package Task3;

import Task2.Task2;
import Task2.Task2Thread;

public class Task3Thread extends Task2Thread {
	public final double[][] data;
	private Double result;
	
	public Task3Thread(Task2 task2, int column, int row, double[][] data) {
		super(task2, column, row);
		this.data = data;
	}
	
	public Double getResult() {
		return result;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
		
		double result;
		result = 0;
		
		for (double[] row : data) {
			result += row[0] * row[1];
		}
		
		this.result = result;
	}
}
