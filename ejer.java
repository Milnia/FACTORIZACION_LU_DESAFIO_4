
public class ejer {

	    public static void main(String[] args) {
	        // Matriz A (
	        double[][] A = {
	            {8, 4, -1},
	            {-2, 5, 1},
	            {2, -1, 6}
	        };
	        
	        // Vector b 
	        double[] b = {11, 4, 7};
	        
	        // Descomposición LU
	        int n = A.length;
	        double[][] L = new double[n][n];
	        double[][] U = new double[n][n];

	        // Inicializar L 
	        for (int i = 0; i < n; i++) {
	            L[i][i] = 1.0;
	        }

	        // Procedimiento para encontrar L y U
	        for (int i = 0; i < n; i++) {
	            for (int j = i; j < n; j++) {
	                // Calcular  U
	                U[i][j] = A[i][j];
	                for (int k = 0; k < i; k++) {
	                    U[i][j] -= L[i][k] * U[k][j];
	                }
	            }
	            for (int j = i + 1; j < n; j++) {
	                // Calcular L
	                L[j][i] = A[j][i];
	                for (int k = 0; k < i; k++) {
	                    L[j][i] -= L[j][k] * U[k][i];
	                }
	                L[j][i] /= U[i][i];
	            }
	        }

	        // 
	        double[] y = new double[n];
	        for (int i = 0; i < n; i++) {
	            y[i] = b[i];
	            for (int j = 0; j < i; j++) {
	                y[i] -= L[i][j] * y[j];
	            }
	        }

	        // Resolver Ux 
	        double[] x = new double[n];
	        for (int i = n - 1; i >= 0; i--) {
	            x[i] = y[i];
	            for (int j = i + 1; j < n; j++) {
	                x[i] -= U[i][j] * x[j];
	            }
	            x[i] /= U[i][i];
	        }

	        // solución
	        System.out.println("Solución del sistema:");
	        for (int i = 0; i < n; i++) {
	            System.out.printf("x%d = %.4f%n", i + 1, x[i]);
	        }
	    }
	
}