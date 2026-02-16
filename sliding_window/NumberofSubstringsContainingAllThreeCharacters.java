class Solution {    
    public int numberOfSubstrings(String s) {
        //your code goes here
        int i=0;
        int j=0;
        int n=s.length();
        int count=0;
        if(n==0) return 0;
        HashMap<Character,Integer>map=new HashMap<>();
        while(j<n){
            char ch=s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()==3){
                count+=(n-j);
                char leftchar=s.charAt(i);
                map.put(leftchar,map.get(leftchar)-1);
                if(map.get(leftchar)==0){
                    map.remove(leftchar);
                }
                i++;
            }
            j++;
        }
        return count;
    }
}