// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static void possibleWordsUtil(int a[], int n, ArrayList<String> result, int currInd, HashMap<Integer,ArrayList<Character>> numbers, String curr)
    {
        if(currInd==n)
        {
            result.add(curr);
            return;
        }
        
        for(char c: numbers.get(a[currInd]))
        {
            possibleWordsUtil(a,n,result,currInd+1,numbers,curr+c);
        }
    }
    
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here 
        ArrayList<String> result=new ArrayList<>();
        HashMap<Integer,ArrayList<Character>> numbers=new HashMap<>();
        char start='a';
        for(int i=2;i<=9;i++)
        {
            numbers.put(i,new ArrayList<>());
            int count=0;
            int range=0;
            if(i<=6 || i==8)
                range=3;
            else
                range=4;
            while(count<range)
            {
                numbers.get(i).add(start++);
                count++;
            }
        }
        possibleWordsUtil(a,N,result,0,numbers,"");
        
        return result;
    }
}