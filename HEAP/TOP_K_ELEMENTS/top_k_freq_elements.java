import java.util.HashMap;
import java.util.PriorityQueue;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[]ans=new int [k];
        
        HashMap<Integer,Integer>map=new HashMap<>();
        // step 1 count the frequency 
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // step 2 min heap based on the frequency 
        PriorityQueue<Integer>minheap=new PriorityQueue<>((a,b)->map.get(a) - map.get(b));// this line sort the elements according to their     freq the minimum freq element will be the root node 
        
        // step 3 keep only top k elements 
        for(int num:map.keySet()){
            minheap.add(num);
            if(minheap.size() > k){
                minheap.poll();    // now the 3 will be removed and [2,1] remained as per example 1
            }
        }
        // step 4 insert the elements from backside to the ans 
        for(int i=k-1;i>=0;i--){
            ans[i]=minheap.poll();
        }

        return ans;
    }
}