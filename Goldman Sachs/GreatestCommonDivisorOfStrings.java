// class Solution {
//     public String gcdOfStrings(String str1, String str2) {
        
//         int n1=str1.length();
//         int n2=str2.length();
        
//         if(n2<n1)
//         {
//             String temp=str1;
//             str1=str2;
//             str2=temp;
//             int tempLen=n1;
//             n1=n2;
//             n2=tempLen;
//         }
        
//         String prefix="";
//         int prefixLen=0;
//         String gcd="";
//         for(int i=0;i<n1;i++)
//         {
//             prefix+=str1.charAt(i);
//             prefixLen++;
//             if(isPossible(prefix,prefixLen,str1,str2,n1,n2))
//             {
//                 gcd=prefix;
//             }
//         }
        
//         return gcd;
//     }
    
//     public boolean isPossible(String prefix, int prefixLen, String str1, String str2, int n1, int n2)
//     {
//         if(n1%prefixLen!=0 || n2%prefixLen!=0)
//             return false;
        
//         int k1=n1/prefixLen;
//         int k2=n2/prefixLen;
//         String str1Built="";
//         for(int i=0;i<k1;i++)
//         {
//             str1Built+=prefix;
//         }
//         String str2Built="";
//         for(int i=0;i<k2;i++)
//         {
//             str2Built+=prefix;
//         }
        
//         if(str1.equals(str1Built) && str2.equals(str2Built))
//             return true;
//         else
//             return false;
//     }
// }

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        int n1=str1.length();
        int n2=str2.length();
        
        if(n2<n1)
        {
            String temp=str1;
            str1=str2;
            str2=temp;
            int tempLen=n1;
            n1=n2;
            n2=tempLen;
        }
        
        String s1s2=str1+str2;
        String s2s1=str2+str1;
        
        if(!s1s2.equals(s2s1))
        {
            return "";
        }
        else
        {
            int gcdLen=gcd(n1,n2);
            return str1.substring(0,gcdLen);
        }
    }
    
    public int gcd(int n1, int n2)
    {
        if(n2==0)
            return n1;
        
        return gcd(n2,n1%n2);
    }
}