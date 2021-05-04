// Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 
// Top down Approach using dp table
public class SubsetSum{
     public static void main(String []args){
        int arr[]={ 1,2,3,4 };
        int target=11;
        boolean dp[][]=new boolean[arr.length+1][target+1];
        
        for(int i=0;i<dp.length;i++) dp[i][0]=true;
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr[i-1]<=j)  dp[i][j]=dp[i-1][j-arr[i-1]]||dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        }
        
        System.out.print(dp[arr.length][target]);
        return ;
     }
}
