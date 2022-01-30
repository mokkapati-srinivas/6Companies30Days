class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend==Integer.MIN_VALUE && divisor==-1)
            return Integer.MAX_VALUE;
        
        if(dividend==Integer.MIN_VALUE && divisor==1)
            return Integer.MIN_VALUE;
        
        int sign=1;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor>0))
            sign=-1;
        
        long div=(long)dividend;
        long dis=(long)divisor;
        if(dividend<0)
            div=-1L*(long)dividend;
        if(divisor<0)
            dis=-1L*(long)divisor;
        
        int quotient=0;
        while(div>=dis)
        {
            int shifts=0;
            // We first double the divisor and then check because we havent made the shifts
            // Since we havent made the shifts we have to check one ahead
            // For example, we have to check for 3<<2 but our shifts are 1 now
            // So we make 3<<1 => 6 and then check 6<<1 => 12 is less than or equal to dividend
            long newDis=dis<<1;
            while(div-(newDis<<shifts)>=0)
                shifts++;
            quotient+=(1<<shifts);
            div-=(dis<<shifts);
        }
        
        quotient=sign*quotient;
        return quotient;
    }
}