
public class RopeCut {

	/*Given a rope of length L, prices array which
	 * has price for every increasing unit length of rope
	 * return the maximum profit.
	 */
	//Recursive solution
	public static int maxProfit(int[] prices, int length)
	{
		if(length == 0)
			return 0;
		int result = prices[length-1];
		for(int i=0; i<length; i++)
		{
			result = Math.max(result, prices[i] + maxProfit(prices,length-i-1));
		}
		return result;
	}
	
	//Iterative DP Solution
	public static int maxProfitDP(int[] prices, int length)
	{
		int[] dp = new int[length+1];
		dp[0] = 0;
		for(int l= 1; l<=length ; l++)
		{
			int result = prices[l-1];
			for(int i=0; i<l; i++)
			{
				result = Math.max(result, prices[i]+dp[l-i-1]);
			}
			dp[l] = result;
		}
		return dp[length];
	}
	
	public static void main(String[] args)
	{	
		int[] prices = {1,2,4,4,5};
		int length = 5;
		System.out.println(maxProfit(prices,length));
		System.out.println(maxProfitDP(prices,length));
	}
}
