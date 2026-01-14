class Solution {
    public double myPow(double x, int n) {
        long pow = n;
        if(pow < 0){
            return 1/fastpow(x,-pow);
        }
        return fastpow(x,pow);
    }

    private double fastpow(double x,long n){
        if(n==0){
            return 1;
        }
        double half = fastpow(x,n/2);

        if(n%2==0){
            return half*half;
        }
        return half*half*x;
    }
}