// { Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code here
          int n=str.length();
          
          if(n==1)
          {
              return (str+"1");
          }
          
          StringBuilder resultBuilder=new StringBuilder();
          char refChar=str.charAt(0);
          int currCount=1;
          for(int i=1;i<n;i++)
          {
              char currChar=str.charAt(i);
              if(refChar==currChar)
              {
                  currCount++;
              }
              else
              {
                  resultBuilder.append(refChar);
                  resultBuilder.append(currCount);
                  refChar=currChar;
                  currCount=1;
              }
          }
          
          if(currCount>0)
          {
              resultBuilder.append(refChar);
              resultBuilder.append(currCount);
          }
          
          String encoded=resultBuilder.toString();
          
          return encoded;
	}
	
 }