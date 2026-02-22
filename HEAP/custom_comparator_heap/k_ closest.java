class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max heap based on the distance
        PriorityQueue<int[]>maxheap=new PriorityQueue<>((a,b)->(b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        for(int[] point:points){
            maxheap.add(point);
            if(maxheap.size()>k){
                maxheap.poll();
            }
        }
        int [][]result=new int [k][2];
        int i=0;
        while(!maxheap.isEmpty()){
            result[i++]=maxheap.poll();
        }
        return result;
    }
}