class Solution {
    public String reorganizeString(String s) {
        // step 1 count the frequency
        HashMap<Character,Integer>map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // step 2 maxheap based on the frequency
        PriorityQueue<Character>maxheap=new PriorityQueue<>((a,b)->map.get(b) - map.get(a));
        maxheap.addAll(map.keySet());

        StringBuilder result= new StringBuilder();
        // step 3 pic two most freqent charcters
        while(maxheap.size()>1){
            char first=maxheap.poll();
            char second=maxheap.poll();

            result.append(first);
            result.append(second);

            map.put(first,map.get(first)-1);
            map.put(second,map.get(second)-1);

            if(map.get(first)>0){
                maxheap.add(first);
            }
            if(map.get(second)>0){
                maxheap.add(second);
            }
        }
        if(!maxheap.isEmpty()){
            char last=maxheap.poll();
            if(map.get(last)>1){
                return "";
            }
            result.append(last);
        }
        return result.toString();
    }
}