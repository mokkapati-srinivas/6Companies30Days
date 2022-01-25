// { Driver Code Starts
import java.util.*;
import java.lang.String;
import java.lang.Math;
class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			GfG g=new GfG();
			System.out.println(g.missingNumber(s));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int missingNumber(String s)
    {
        //add code here.
        int len=s.length();
        int maxLen=Math.min(6,(len/2));
        
        int refNum=0;
        int missing=-1;
        int noOfMissing=0;
        for(int i=0;i<maxLen;i++)
        {
            refNum=refNum*10+(s.charAt(i)-'0');
            int ind=i+1;
            int newNum=0;
            int prevNum=refNum;
            noOfMissing=0;
            while(ind<len)
            {
                newNum=newNum*10+(s.charAt(ind)-'0');
                if(newNum==(prevNum+2))
                {
                    missing=prevNum+1;
                    noOfMissing++;
                    prevNum=newNum;
                    newNum=0;
                }
                else if(newNum==(prevNum+1))
                {
                    prevNum=newNum;
                    newNum=0;
                }
                ind++;
            }
            
            if(noOfMissing==1)
                return missing;
        }
        
        return -1;
    }
}
