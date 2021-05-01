import java.util.Arrays;

public class MyMath {
	/**
	 * 
	 * @param x The first number to be added
	 * @param y Second number to be added
	 * @return The result of the addition
	 */
	public int add(int x, int y) {
		int result = x + y;
		return result;

	}

	/**
	 * 
	 * @param x The first number in the subtraction
	 * @param y Number to be subtracted
	 * @return The subtraction's result
	 */
	public int subtract(int x, int y) {
		int result = x - y;
		return result;

	}

	/**
	 * 
	 * @param x The first number in the multiplication
	 * @param y The second number in the multiplication
	 * @return The result of the multiplication
	 */
	public int multiply(int x, int y) {
		int result = x * y;
		return result;

	}

	/**
	 * 
	 * @param x The first number in the division
	 * @param y The second number in the division
	 * @return The result of the division
	 */
	public double divide(double x, double y) throws Exception{

		if (y == 0)
			throw new Exception("Error cannot divide by zero");
			//return 0;
		double d5 = x / y;

		double result = Math.round(d5 * 100000) / 100000.0d;

		return result;

	}

	public int[] mulvec(int[] x, int[] y) throws Exception {
		if (x.length == 0 || y.length == 0) {
			throw new Exception("BadVector array length = 0");
		}
		if (x.length != y.length) {
			throw new Exception("Not equal");
		}
		int[] result = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			result[i] = x[i] * y[i];
		}
		return result;
	}
	public int[] matXvec(int[][] x,int y[]) throws Exception {
	    int rows = x.length;
	    int columns = x[0].length;
	    
	    if (columns != y.length || columns == 0 || rows == 0) {
			throw new Exception("Column/Row length mismatch");
	    }
	    int[] result = new int[rows];

	    for (int r = 0; r < rows; r++) {
	        int sum = 0;
	        for (int c = 0; c < columns; c++) {
	            sum += x[r][c] * y[c];
	        }
	        result[r] = sum;
	    }
	    return result;
	}
	
	
	
	
	
	public boolean idmatrix(int[][] x) throws Exception {
        int rows, cols;    
        boolean flag = true;    
  
        rows = x.length;    
        cols = x[0].length;   
        
        
        if(rows!=cols)
        	throw  new Exception("not a squared matrix");
        	//flag=false;
        for(int i=0; i<rows; i++)
        {
        	if(x[i].length != cols)
        		//flag =false;
        		throw new Exception("Length of "+i+"'s column is not right");        	
        }
       
        if(rows != cols){  
        }    
        else {    
            for(int i = 0; i < rows; i++){    
                for(int j = 0; j < cols; j++){    
                  if(i == j && x[i][j] != 1){    
                      flag = false;    
                      break;    
                  }    
 
                }    
            }    
                
            if(flag) 
            	//throw new Exception("Given matrix is an identity matrix");

            	return true;
            else   
            	//throw new Exception("Given matrix is not an identity matrix");

            	return false;
        }
		return flag;    
    }

	
	public int[][] matByMat(int[][] matrix1, int[][] Matrix2) throws Exception{
	    int rowM1 = matrix1.length;
	    int colM1 = matrix1[0].length;
	    int colM2 = Matrix2[0].length;
	    
	    
	   
	    int[][] matrixThree = new int[rowM1][colM2];
	    for(int i = 0; i < rowM1; i++) {
	        for (int j = 0; j < colM2; j++) {
	            for (int k = 0; k < colM1; k++) {
	                matrixThree[i][j] += matrix1[i][k] * Matrix2[k][j];
	            }
	        }
	    }
	    for(int i = 0; i < matrixThree.length; i++) {
	    System.out.println(Arrays.toString(matrixThree[i]));
	    }
	    return matrixThree;
	   
	}	
   
public static int[][] transpose(int[][] x) throws Exception {
	 int rows = x.length;    
     int cols = x[0].length;   
     
     if(rows!=cols)
     	throw  new Exception("not a squared matrix");
     for(int i=0; i<rows; i++)
     {
     	if(x[i].length != cols)
     		//flag =false;
     		throw new Exception("Length of "+i+"'s column is not right");        	
     }
     
	int original[][]=x;
    int transpose[][]=new int[x[0].length][x.length];  
	    
    
	for(int i=0;i<x.length;i++){    
	for(int j=0;j<x[0].length;j++){    
	transpose[i][j]=original[j][i];  
	}    
	}    
	  
	System.out.println("Matrix before transposition:");  
	for(int i=0;i<x.length;i++){    
	for(int j=0;j<x[0].length;j++){    
	System.out.print(original[i][j]+" ");    
	}    
	System.out.println("");    
	}    
	System.out.println("Matrix post Transposition:");  
	for(int i=0;i<x.length;i++){    
	for(int j=0;j<x[0].length;j++){    
	System.out.print(transpose[i][j]+" ");    
	}    
	System.out.println("");    
	}
	return transpose;    
	}
}
	
	


