class Solution {
    public int kDistinctChar(String s, int k) {
        int i=0;
        int maxlen=-1;
        HashMap<Character,Integer>map=new HashMap<>();
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size() > k){
                char leftchar=s.charAt(i);
                map.put(leftchar,map.get(leftchar)-1);
                if(map.get(leftchar)==0){
                    map.remove(leftchar);
                }
                i++;
            }
            // if exactly k distinct → update max length
            if (map.size() == k) {
                maxlen = Math.max(maxlen, j - i + 1);
            }
        }
        return maxlen;
    }
}