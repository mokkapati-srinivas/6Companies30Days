// { Driver Code Starts
import java.util.*;
import java.lang.Math;
class Pots{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0)
		{
			int n = sc.nextInt();
			int[] a =new  int[n];
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
			}
			GfG g = new GfG();
			System.out.println(g.maxCoins(a,n));
			
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
    
    public static int maxCoinsUtil(int arr[], int n, int left, int right, int dp[][])
    {
        if(left>right)
            return 0;
            
        if(dp[left][right]!=-1)
            return dp[left][right];
            
        int choiceLeft=arr[left]+Math.min(maxCoinsUtil(arr,n,left+2,right,dp),maxCoinsUtil(arr,n,left+1,right-1,dp));
        int choiceRight=arr[right]+Math.min(maxCoinsUtil(arr,n,left+1,right-1,dp),maxCoinsUtil(arr,n,left,right-2,dp));
        
        dp[left][right]=Math.max(choiceLeft,choiceRight);
        
        return dp[left][right];
    }
    
	public static int maxCoins(int A[],int n)
	{
          //add code here.
          int dp[][]=new int[n][n];
          for(int i=0;i<n;i++)
          {
              for(int j=0;j<n;j++)
              {
                  dp[i][j]=-1;
              }
          }
          
          int maxX=maxCoinsUtil(A,n,0,n-1,dp);
          
          return maxX;
    }
}