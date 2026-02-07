class Solution {
    
    public int countGoodNumbers(long n) {
        long M = 1000000007L;
        long part1 = findPower(5,(n+1)/2,M);
        long part2 = findPower(4,(n/2),M);
        return (int)((part1*part2)%M);
        
    }
    long findPower(long a,long b,long M){
        if(b == 0)
        {
            return 1;
        }
        long half=findPower(a,b/2,M);
        long result = (half*half)%M;
        if(b%2 == 1)
        {
            result=(result*a)%M;
        }
        return result;
    }
}