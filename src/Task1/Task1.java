
// Task1.java

package Task1;

public class Task1 {
	public final Double[][][] matrices;
	public final Double[][] result;
	public final int size;
	
	public Task1() {
		size = 1000;
		matrices = new Double[2][size][size];
		result = new Double[size][size];
	}
	
	public void run() {
		// Generate random matrices
		for (int matrix = 0; matrix < matrices.length; matrix++) {
			for (int row = 0; row < matrices[matrix].length; row++) {
				for (int column = 0; column < matrices[matrix][matrix].length; column++) {
					matrices[matrix][row][column] = Math.random();
				}
			}
			
			// Print each matrix
			printMatrix("Original Matrix " + (matrix + 1), matrices[matrix]);
		}
		
		// Multiply matrices
		for (int row = 0; row < result.length; row++) {
			for (int column = 0; column < result[row].length; column++) {
				result[row][column] = 0.0;
				
				for (int i = 0; i < matrices[0].length; i++) {
					result[row][column] += matrices[0][row][i] * matrices[1][i][column];
				}
			}
		}
		
		// Print result
		printMatrix("Standard Result", result);
	}
	
	public static void printMatrix(String title, Double[][] matrix) {
		System.out.println(title);
		
		for (Double[] row : matrix) {
			for (double cell : row) {
				System.out.print(String.format("%.17f ", cell));
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
}
