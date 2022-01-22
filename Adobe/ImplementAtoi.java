// { Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	    int num=0;
	    int start=0;
	    if(str.charAt(0)=='-')
	        start=1;
	    int len=str.length();
	   
	    for(int i=start;i<len;i++)
	    {
	        int curr=str.charAt(i)-'0';
	        if(curr>=0 && curr<=9)
	        {
	            num=num*10+curr;
	        }
	        else
	        {
	            return -1;
	        }
	    }
	    
	    if(start==1)
	        num=-num;
	        
	    return num;
    }
}