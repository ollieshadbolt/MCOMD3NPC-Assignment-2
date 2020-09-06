
// Task2Thread.java

package Task2;

public class Task2Thread extends Thread {
	private final Task2 task2;
	public final int column;
	public final int row;
	
	public Task2Thread(Task2 task2, int column, int row) {
		this.task2 = task2;
		this.column = column;
		this.row = row;
	}
	
	public void run() {
		double result;
		result = 0;
		
		for (int i = 0; i < task2.size; i++) {
			result += task2.matrices[0][row][i] * task2.matrices[1][i][column];
		}
		
		task2.setResult(column, row, result);
	}
}
