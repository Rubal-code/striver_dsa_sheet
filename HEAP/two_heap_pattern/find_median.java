class MedianFinder {

    private PriorityQueue<Integer>minheap;//storers larger half
    private PriorityQueue<Integer>maxheap;// stores smaller half
    

    public MedianFinder() {
        minheap=new PriorityQueue<>();
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // step 1 add num first to maxheap
        maxheap.add(num);
        // step 2 add num from maxheap to minheap
        minheap.add(maxheap.poll());
        // step 3 balance both minheap and maxheap
        if(minheap.size() > maxheap.size()){
            maxheap.add(minheap.poll());
        }
    }
    
    public double findMedian() {
        if(maxheap.size() > minheap.size()){
            return maxheap.peek();
        }
        else{
            return ((double)minheap.peek() + maxheap.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */