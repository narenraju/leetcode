//Recursion with Memoization
public class HelloWorld{
     static int dp[][]=new int[1001][1001]; //no of rows is (array size + 1) and no of columns is (target sum + 1)
     public static void main(String []args){
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                dp[i][j]=-1;
        int arr[]={1,5,6,8,2};
        int sum=35;
        if(subset(arr,arr.length,sum)==1)
            System.out.println("Subset present");
        else
            System.out.println("No Subset");
        return;
     }
     public static int subset(int[] arr,int n,int sum){
        if(sum==0)
            return 1;
        if(n==0)
            return 0;
        if(dp[n][sum]!=-1)
            return dp[n][sum];
        if(arr[n-1]<=sum)
            return dp[n][sum]=subset(arr,n-1,sum-arr[n-1]) | subset(arr,n-1,sum);
        return dp[n][sum]=subset(arr,n-1,sum);
     }
}
