class Solution {
    public boolean isPalindrome(int n) {
        int num=n;
        int d,rev=0;
        if(n<0)
        return false;
        else{
            while(n!=0)
            {
                d=n%10;
                rev=rev*10+d;
                n=n/10;
            }
        }
        if(num==rev)
        return true;
        else
        return false;
    }
        
}