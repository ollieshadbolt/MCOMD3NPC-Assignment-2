
// Task3.java

package Task3;

import Task2.Task2;

public class Task3 extends Task2 {
	public Task3Thread getThread(Task2 task2, int column, int row, double[][] data) {
		Task3Thread task3Thread;
		task3Thread = new Task3Thread(this, column, row, data);
		return task3Thread;
	}
	
	@Override
	public void newThread(int column, int row) {
		double[][] data;
		data = new double[size][2];
		
		for (int i = 0; i < data.length; i++) {
			data[i][0] = matrices[0][row][i];
			data[i][1] = matrices[1][i][column];
		}
		
		Task3Thread task3Thread;
		task3Thread = getThread(this, column, row, data);
		threads.add(task3Thread);
		task3Thread.start();
	}
	
	@Override
	public void joinThread(Thread thread) {
		Task3Thread task3Thread;
		task3Thread = (Task3Thread) thread;
		
		try {
			thread.join();
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
		
		setResult(task3Thread.column, task3Thread.row, task3Thread.getResult());
	}
}
