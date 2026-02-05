public class longest_subsequence_palindrome{
    public int longestPalinSubseq(String s) {
    int n=s.length();
    int [][]dp=new int[n][n];
    //base case single character
    for(int i=0;i<n;i++){
        dp[i][i]=1;
    }
    // build the dp table for substrings for len 2 to n
    for(int len=2;len<=n;len++){
        for(int i=0;i<=n-len;i++){// starting of substring pointer
            int j=i+len-1;//ending point of the substring given
            if(s.charAt(i)==s.charAt(j)){
                dp[i][j]=2+dp[i+1][j-1];//when char match 
            }
            else{
                dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
    }
    return dp[0][n-1];  // from start to end of the string
    }
}

