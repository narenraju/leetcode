// Leetcode 416. Partition Equal Subset Sum

class Solution {
    public boolean canPartition(int[] nums) {
    int total=0;
    for(int val:nums)
        total+=val;
    if((total&1)==1) //if the total sum is odd then we cannot partition the total into two equal halves
        return false;
    int target=total>>1; //if total is even, then we need to half the total and search if there is a subset with that target
    boolean dp[][]=new boolean[nums.length+1][target+1]; 
    for(int i=0;i<dp.length;i++) dp[i][0]=true; //i->index of array values,j->sum
    for(int i=1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            if(nums[i-1]<=j) dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
            else dp[i][j]=dp[i-1][j];
        }
    }
    return dp[nums.length][target];
    }
}
