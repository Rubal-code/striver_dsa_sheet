class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character>maxheap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        maxheap.addAll(map.keySet());

        StringBuilder result = new StringBuilder();
        while(!maxheap.isEmpty()){
            char ch = maxheap.poll();
            int freq=map.get(ch);

            while(freq-- > 0){
                result.append(ch);
            }
        }
        return result.toString();
    }
}