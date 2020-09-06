
// Task4.java

package Task4;

import Task2.Task2;
import Task3.Task3;
import Task3.Task3Thread;

public class Task4 extends Task3 {
	private double failureRate;
	
	public Task4(double failureRate) {
		this.failureRate = failureRate;
	}
	
	@Override
	public Task3Thread getThread(Task2 task2, int column, int row, double[][] data) {
		Task4Thread task4Thread;
		task4Thread = new Task4Thread(this, column, row, data, failureRate);
		return task4Thread;
	}
	
	@Override
	public void joinThreads() {
		for (int i = 0; i < threads.size(); i++) {
	        Task4Thread task4Thread;
	        task4Thread = (Task4Thread) threads.get(i);
	        
		    try {
				task4Thread.join();
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
		    
		    Double result;
	        int column;
	        int row;
		    
		    result = task4Thread.getResult();
		    column = task4Thread.column;
		    row = task4Thread.row;
		    
	        if (result == null) {
	        	newThread(column, row);
	        } else {
	        	setResult(column, row, result);
	        }
		}
	}
}
