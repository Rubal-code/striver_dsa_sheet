class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int i=0;
        int j=0;
        int maxfreq=0;//stores maxfrequency in each window
        int ans=0;
        int[]freq=new int[26];
        while(j<n){
            char ch=s.charAt(j);  // current character
            freq[ch-'A']++;//increase the frequency of that char 
            maxfreq=Math.max(maxfreq,freq[ch-'A']);

            int window_size=j-i+1;  // current window window_size
            // if replacements needed > k → shrink window
            if(window_size - maxfreq > k){
                freq[s.charAt(i) - 'A']--;         // remove left character
                i++;                               // move left pointer
            }
            ans = Math.max(ans, j - i + 1);        // update answer
            
            j++;                                   // expand window
        }
        return ans;
}
}