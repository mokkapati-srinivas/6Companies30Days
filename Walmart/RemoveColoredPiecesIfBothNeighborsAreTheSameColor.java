class Solution {
    
    public boolean winnerOfGame(String colors) {
        
        int n=colors.length();
        int as=0;
        int bs=0;
        int movesA=0;
        int movesB=0;
        for(int i=0;i<n;i++)
        {
            if(colors.charAt(i)=='A')
            {
                as++;
                bs=0;
            }
            else
            {
                bs++;
                as=0;
            }
            
            if(as>=3)
                movesA++;
            if(bs>=3)
                movesB++;
        }
        
        return movesA>movesB;
    }
}