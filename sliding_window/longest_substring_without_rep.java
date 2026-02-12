class Solution {
    public int longestNonRepeatingSubstring(String s) {
        //your code goes here
        int i=0;// left pointer
        int j=0;// right pointer
        int n=s.length();
        int ans=0;

        HashMap<Character,Integer>map=new HashMap<>();

        // main code
        while(j<n){
            char ch=s.charAt(j);

            // add current Character to map 
            map.put(ch,map.getOrDefault(ch,0)+1); // (char,freq)

            // shrink window if invalid
            while(map.get(ch) > 1){   // if freq of char is more then one time
                char left_char=s.charAt(i);
                map.put(left_char,map.get(left_char)-1);// (ch,freq decrease by one)

                if(map.get(left_char)==0){
                    map.remove(left_char);
                }
                i++;
            }
            // update the answer 
            ans=Math.max(ans,j-i+1);
            j++;


        }
        return ans;
    }
}