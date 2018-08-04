import java.util.Arrays;

public class CoinChange {
/*322. Coin Change
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note: You may assume that you have an infinite number of each kind of coin.
*/	
	//DP
	public static int getCoins1(int[] deno, int target)
	{
		int[] arr = new int[target+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		
		for(int i = 1; i<=target; i++)
		{
			for(int d:deno)
			{
				if(d<=i && (arr[i-d] < arr[i]))
				{
					arr[i] = arr[i-d];
				}
			}
			if(arr[i] < Integer.MAX_VALUE)
				arr[i] += 1;
		}
		return arr[target];
	}
	
	//Accepted Leetcode
	public static int coinChange(int[] arr, int target)
    {
        int[] dp = new int[target+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		for(int i=1; i<=target; i++)
		{
			int result = dp[i];
			for(int d:arr)
			{
				if(d<=i && dp[i-d] != Integer.MAX_VALUE)
					result = Math.min(result, 1+dp[i-d]);
			}
			dp[i] = result;
		}
		return (dp[target]==Integer.MAX_VALUE?-1:dp[target]);
		//return dp[target]
    }
	
	//regular recursion - not preferable
	public static int getCoins_Recursive(int[] arr, int target)
	{
		if(target == 0)
			return 0;
		if(target<0)
			return Integer.MAX_VALUE;
		
		int result = Integer.MAX_VALUE;
		
		for(int deno : arr)
		{
			int resultTemp = getCoins_Recursive(arr,target-deno);
			if(resultTemp != Integer.MAX_VALUE)
				result =  Math.min(result, 1+resultTemp);		
		}		
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {2,3,5};
		int result = getCoins1(arr,100);
		if(result != Integer.MAX_VALUE)
			System.out.println(result);
		else
			System.out.println("-1");
		
		result = coinChange(arr,100);		
		System.out.println(result);
		
	}
}
