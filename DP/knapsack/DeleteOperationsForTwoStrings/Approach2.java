//Top Down approach with DP table
class Solution {
    static int dp[][]=new int[501][501];
    public int minDistance(String word1, String word2) {
        //initialization
        for(int i=0;i<501;i++){
            for(int j=0;j<501;j++){
                if(i==0){
                    dp[i][j]=j;
                    continue;
                }
                if(j==0){
                    dp[i][j]=i;
                    continue;
                }
                dp[i][j]=-1;
            }
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
            }
            System.out.println();
        }
        return dp[word1.length()][word2.length()];
    }
}
