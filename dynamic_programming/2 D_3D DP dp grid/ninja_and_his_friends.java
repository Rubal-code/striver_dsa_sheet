class ninja_and_his_friends{
    public int maxChocolates(int[][] g) {
        // Your code goes here
        int n=g.length;
        int m=g[0].length;
        int[][][] dp= new int[n][m][m]; //3d array because we need three info like row, colalice, colbob

        // base case means best case and no further we can go means last row to last row best case
        for (int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                    dp[n-1][j1][j2]=g[n-1][j1];
                }
                else{
                    dp[n-1][j1][j2]=g[n-1][j1] + g[n-1][j2];
                }
            }
        }

        //dp transitions
        for (int i=n-2;i>=0;i--){ // from last we second row we start because we already computed n-1 which help us to compute n-2 then n-3 from n-2 and go on
            for (int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=Integer.MIN_VALUE;
                    for (int dj1=-1;dj1<=1;dj1++){
                        for (int dj2=-1;dj2<=1;dj2++){
                            int nj1=j1+dj1;// alice new move
                            int nj2=j2+dj2;// bob new move
                            if(nj1>=0 && nj1<m && nj2>=0 && nj2<m){
                                int value;// total choclates if you choose this move
                                if(j1==j2){
                                    value=g[i][j1];
                                }
                                else{
                                    value=g[i][j1] + g[i][j2];
                                }
                                value+=dp[i+1][nj1][nj2];
                                maxi=Math.max(maxi,value);
                            }
                        }
                    }
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
}