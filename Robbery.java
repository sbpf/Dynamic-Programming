
public class Robbery {

	/*LeetCode 198.House Robber
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing 
	 * each of them is that adjacent houses have security system connected and it will automatically 
	 * contact the police if two adjacent houses were broken into on the same night.

	Given a list of non-negative integers representing the amount of money of each house, 
	determine the maximum amount of money you can rob tonight without alerting the police.

	Example 1:

	Input: [1,2,3,1]
	Output: 4
	Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	             Total amount you can rob = 1 + 3 = 4.
	Example 2:

	Input: [2,7,9,3,1]
	Output: 12
	Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
	             Total amount you can rob = 2 + 9 + 1 = 12.
	*/
	static int maxStolenValueDP(int[] values)
    {
	   if(values.length == 0) return 0;
       int[] dp = new int[values.length+3];
       int vlength = values.length;
       dp[vlength] = 0;
       dp[vlength+1] = 0;
       dp[vlength+2] = 0;
       dp[vlength-1] = values[values.length-1];
        
        for(int i=vlength-2; i>=0; i--)
        {
            dp[i] = Math.max((values[i] + dp[i+2]), (values[i+1] + dp[i+3]));
        }
        return dp[0];
    }
    
    //recursive    
    static int maxStolenValue(int[] values) {
        return maxRobbery(values,0);
    }
    
    static int maxRobbery(int[] values, int i)
    {
        if(i==values.length-1) return values[values.length-1];
        if(i>=values.length) return 0;
        return Math.max((values[i] + maxRobbery(values,i+2)), (values[i+1] + maxRobbery(values,i+3)));
    }
	
	public static void main(String[] args) {		

	}

}
