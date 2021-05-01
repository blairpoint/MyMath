import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        MyMath m = new MyMath();
        System.out.println("Addition = " + m.add(7, 3));
        System.out.println("Division = " + m.divide(1, 3));
        System.out.println("Multiplication = " + m.multiply(5, 5));
        System.out.println("Subtraction = " + m.subtract(20, 16));
   
        int arr1[]  = m.mulvec( new int[] {1,2,3},new int[] {1,2,3});
        System.out.println(Arrays.toString(arr1));
        
        
        int[][] x = {{1,2,3},{1,2,3}};
        int[] y = {1,2,3};
        
        int[] arr2 = m.matXvec(x, y);
        System.out.println(Arrays.toString(arr2));
        
        int[][] o = {
        		{1,0,0},
        		{0,1,0},
        		{0,0,1}
        		};
        boolean arr3 = m.idmatrix(o);
        System.out.println(arr3);
       
        
        
        
        
        int[][] t = {
        		{1,0,9},
        		//{5,1,0},
        		{0,0,9}
        		};
//        int[][] t = {
//        		{1}
//        		};
               

     //  t = m.transpose(t);
       
       m.matByMat(
    		   new int[][] 
    				   { 
    			   {1,2},
    			   {1,2},
    			   {1,2}},
    		   
    		   new int[][] {
    			   {9},
    			   {6}
    		   }
    		   
    		   );
       

	}
	
	
	
}
