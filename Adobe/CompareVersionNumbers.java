class Solution {
    public int compareVersion(String version1, String version2) {
        int len1=version1.length();
        int len2=version2.length();
        
        int i=0,j=0;
        int revision1=0,revision2=0;
        while(i<len1 || j<len2)
        {
            revision1=0;
            while(i<len1 && version1.charAt(i)!='.')
            {
                // System.out.println("r1 "+(version1.charAt(i)-'0'));
                revision1=revision1*10+(version1.charAt(i)-'0');
                i++;
            }
            // System.out.println(revision1);
            
            revision2=0;
            while(j<len2 && version2.charAt(j)!='.')
            {
                // System.out.println("r2 "+(version2.charAt(j)-'0'));
                revision2=revision2*10+(version2.charAt(j)-'0');
                j++;
            }
            // System.out.println(revision2);
            
            if(revision1<revision2)
                return -1;
            else if(revision1>revision2)
                return 1;
            
            i++;
            j++;
        }
        
        return 0;
    }
}