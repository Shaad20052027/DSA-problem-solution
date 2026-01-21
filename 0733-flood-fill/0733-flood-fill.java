class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int incolor = image[sr][sc];
        int[][] ans = image;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        dfs(sr,sc,image,ans,delrow,delcol,incolor,color);
        return ans;
    }

    public void dfs(int row, int col, int[][] image,int[][] ans,int[] delrow,int[] delcol,int incolor,int newcolor){
        ans[row][col] = newcolor;
        int n = image.length;
        int m = image[0].length;
        for(int i =0; i <4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == incolor && ans[nrow][ncol] != newcolor){
                dfs(nrow,ncol,image,ans,delrow,delcol,incolor,newcolor);
            }
        }
    }
}