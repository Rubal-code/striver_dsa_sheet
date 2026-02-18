class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minheap=new PriorityQueue<>();

        for(int num:nums){                     //num nu itertae kita nums tak
            minheap.add(num);          //num di value prioriyqueue vich add karta

            if(minheap.size()>k){        // je minheap da size given k to vadda ho jave tan
            minheap.poll();              // ode top vala ele remove kardo ji
        }
        }
    
        return minheap.peek();       //top vala element daso keda hega
    }
}