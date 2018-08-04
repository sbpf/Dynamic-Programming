
public class EditDistance {

	static int editDistance(String s1, String s2) 
	{
		System.out.println(s1 + s2);
	       
	       int[][] DP = new int[s1.length()+1][s2.length()+1];
	       
	       for(int i=0; i<=s1.length(); i++)
	          DP[i][s2.length()] = s1.length()-i;
	       for(int j=0; j<=s2.length(); j++)
	          DP[s1.length()][j] = s2.length()-j;
	       
	       
	       //print DP table
	       for(int i=0; i<DP.length; i++)
	       {
	    	   for(int j=0; j<DP[0].length; j++)
	    	   {
	    		   System.out.print(DP[i][j]);
	    	   }
	    	   System.out.println(" ");
	       }
	       
	       for(int i = s1.length()-1; i>=0; i--)
	       {
	           for(int j= s2.length()-1; j>=0; j--)
	           {
	                if(s1.charAt(i) == s2.charAt(j)) 
	                    DP[i][j] = DP[i+1][j+1];
	                else
	                {
	                    DP[i][j] = DP[i][j+1];
	                    DP[i][j] = Math.min(DP[i][j],DP[i+1][j]);
	                    DP[i][j] = Math.min(DP[i][j],DP[i+1][j+1]);
	                    DP[i][j] += 1;
	                }
	           }
	       }
	      
	       System.out.println("After DPPPPPPPPPPPPPPPPPPPPPPP");
	       
	     //print DP table
	       for(int i=0; i<DP.length; i++)
	       {
	    	   for(int j=0; j<DP[0].length; j++)
	    	   {
	    		   System.out.print(DP[i][j]);
	    	   }
	    	   System.out.println(" ");
	       }
	       return DP[0][0];
	    }
	
	
	public static void main(String[] args) {
		
		editDistance("cart", "bag");
	}

}
