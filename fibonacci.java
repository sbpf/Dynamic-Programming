import java.util.*;

public class fibonacci {

	// Memoized DP - recursion
	public static int getFibonacci_Memoized(int n)
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		return fibonacci_memoized(n, map);		
	}
	
	public static int fibonacci_memoized(int n, HashMap<Integer,Integer> map)
	{
		if(n<=2) return 1;
		if(map.containsKey(n)) return map.get(n);
		int fibn = fibonacci_memoized(n-1,map) + fibonacci_memoized(n-2,map);
		map.put(n, fibn);
		return fibn;
	}	
	
	//Iterative DP
	public static int fibonacci_iterativeDP(int n)
	{
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++)
		{
			if(i<2) 
				arr[i] = 1;
			else
				arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n-1];
	}
	
	public static void main(String[] args)
	{
		for(int i=1; i<20; i++)
		{
			System.out.print(getFibonacci_Memoized(i));
			System.out.print("    ");
			System.out.print(fibonacci_iterativeDP(i) + "\n");
		}		
	}
}
