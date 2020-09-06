
// Task2.java

package Task2;

import java.util.ArrayList;

import Task1.Task1;

public class Task2 extends Task1 {
	public final ArrayList<Thread> threads;
	private final Double[][] result;
	
	public Task2() {
		threads = new ArrayList<Thread>();
		result = new Double[size][size];
	}
	
	public void run() {
		super.run();
		
		// Start threads
		for (int row = 0; row < result.length; row++) {
			for (int column = 0; column < result[row].length; column++) {
				newThread(column, row);
			}
		}
		
		// Join threads
		joinThreads();
		
		// Print result
		printMatrix("Threaded Result", result);
		
		// Subtract matrices
		Double[][] matrixSubtraction;
		matrixSubtraction = new Double[size][size];
		
		for (int row = 0; row < matrixSubtraction.length; row++) {
			for (int column = 0; column < matrixSubtraction[row].length; column++) {
				matrixSubtraction[row][column] = super.result[row][column] - result[row][column];
			}
		}
		
		// Print subtraction
		printMatrix("Subtract Matrix", matrixSubtraction);
	}
	
	public void setResult(int column, int row, Double result) {
		this.result[row][column] = result;
	}
	
	public void newThread(int column, int row) {
		Task2Thread task2Thread;
		task2Thread = new Task2Thread(this, column, row);
		threads.add(task2Thread);
		task2Thread.start();
	}
	
	public void joinThread(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
	}
	
	public void joinThreads() {
		for (Thread thread : threads) {
			joinThread(thread);
		}
	}
}
