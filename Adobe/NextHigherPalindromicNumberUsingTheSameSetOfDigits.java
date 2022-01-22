// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.nextPalin(s));
        }
            
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void swap(char arr[], int i, int j)
    {
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    public void reverse(char arr[], int i, int j)
    {
        while(i<j)
        {
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    
    public StringBuilder getNextGreaterPermutation(String half, int halfLen)
    {
        char halfArr[]=new char[halfLen];
        for(int i=0;i<halfLen;i++)
        {
            halfArr[i]=half.charAt(i);
        }
        
        int breakPoint=halfLen-2;
        while(breakPoint>=0 && halfArr[breakPoint]>=halfArr[breakPoint+1])
        {
            breakPoint--;
        }
        
        if(breakPoint>=0)
        {
            int swapInd=halfLen-1;
            while(halfArr[swapInd]<=halfArr[breakPoint])
            {
                swapInd--;
            }
            swap(halfArr,breakPoint,swapInd);
        }
        
        reverse(halfArr,breakPoint+1,halfLen-1);
        
        StringBuilder newHalf=new StringBuilder();
        for(int i=0;i<halfLen;i++)
        {
            newHalf.append(halfArr[i]);
        }
        
        return newHalf;
    }
    
    public String nextPalin(String N) 
    { 
        //complete the function here
        int len=N.length();
        if(len<=3)
            return "-1";
        
        String half=N.substring(0,(len/2));
        StringBuilder nextGreaterPermutation=getNextGreaterPermutation(half,(len/2));
        if(nextGreaterPermutation.toString().compareTo(half)<=0)
            return "-1";
            
        int start=0;
        if(len%2!=0)
        {
            start=(len/2)+1;
            nextGreaterPermutation.append(N.charAt((len/2)));
        }
        else
        {
            start=(len/2);
        }
        
        for(int i=start;i<len;i++)
        {
            nextGreaterPermutation.append(nextGreaterPermutation.charAt(len-1-i));
        }
        
        return nextGreaterPermutation.toString();
    }
}
