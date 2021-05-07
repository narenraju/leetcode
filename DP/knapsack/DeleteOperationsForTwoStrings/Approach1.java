//Recursion with memoization
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
        return cal(word1,word2,word1.length(),word2.length());
    }
    public int cal(String s1,String s2,int idx1,int idx2){
        if(idx1==0 || idx2==0){
            return dp[idx1][idx2];
        }
        if(dp[idx1][idx2]!=-1)
                return dp[idx1][idx2];   
        if(s1.charAt(idx1-1)==s2.charAt(idx2-1)){ //if last characters match calclate the ans for remaining characters of words by excluding the last characters
            return dp[idx1][idx2]=cal(s1,s2,idx1-1,idx2-1);
        }     
        return dp[idx1][idx2]=1+Math.min(cal(s1,s2,idx1,idx2-1),cal(s1,s2,idx1-1,idx2));
    }
}
