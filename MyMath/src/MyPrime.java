
public class MyPrime {
	
	public boolean isPrime(int x) {
				if(x<2)
					return false;
		
		for (int i = 2; i <= x / 2; i++) {
		      // condition for nonprime number
		      if ((x % i) == 0) {
		        return false;
		        
		      }
		    }

		    return true;
		}
}

