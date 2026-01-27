class Solution {
    public boolean isSubsetSum(int[] arr, int target) {
      int n=arr.length;
      boolean []prev=new boolean[target+1];
      // base case
      prev[0]=true; // sum 0 is always possible

      if(arr[0] <= target){
        prev[arr[0]]=true;
      }
      // process remaining elements
      for(int i=1;i<n;i++){
        boolean curr[]=new boolean[target+1];
        curr[0]=true;
        for(int sum=1;sum<=target;sum++){
            boolean not_take=prev[sum];
            boolean take=false;

            if(arr[i] <= sum){
                take=prev[sum-arr[i]];
            }
            curr[sum] = take||not_take;
        } 
        prev=curr;
      }
      return prev[target];
    }
}
