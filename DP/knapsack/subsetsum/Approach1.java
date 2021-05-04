//Recursion with all possibilities
// Time Complexity O(2^n)
public class HelloWorld{
     public static void main(String []args){
        int arr[]={1,5,6,8,2};
        int sum=18;
        System.out.println(subset(arr,arr.length,sum));
        return;
     }
     public static boolean subset(int[] arr,int n,int sum){
        if(sum==0)
            return true;
        if(n==0)
            return false;
        if(arr[n-1]<=sum)
            return subset(arr,n-1,sum-arr[n-1])||subset(arr,n-1,sum);
        return subset(arr,n-1,sum);
     }
}
