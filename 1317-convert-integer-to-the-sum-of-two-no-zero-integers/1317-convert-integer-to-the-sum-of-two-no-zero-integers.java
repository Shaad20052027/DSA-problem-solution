class Solution {
    public int[] getNoZeroIntegers(int n) {
       
       for(int i=1; i<n; i++)
       {
        int j=n-i;
        if(!containzero(i) && !containzero(j))
        {
            return new int[]{i,j};
        }
       }
       return new int[]{};
    }
    private boolean containzero(int n)
    {
        while(n>0)
        {
            if(n%10 == 0)
            return true;
            n/=10;
        }
        return false;
    }

}