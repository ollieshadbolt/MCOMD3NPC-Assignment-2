
public class RandomMatrix {
	public final double[][] matrix;
	
	public RandomMatrix() {
		int size;
		size = 1000;
		matrix = new double[size][size];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Math.random();
			}
		}
	}
}
