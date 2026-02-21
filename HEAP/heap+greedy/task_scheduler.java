class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []freq=new int [26];
        // step 1 count frequency
        for(char ch:tasks){
            freq[ch-'A']++;
            
        }
        // step 2 find the maxfrequency
        int maxfreq=0;
        for(int i=0;i<26;i++){
            maxfreq=Math.max(maxfreq,freq[i]);
        }
        // step 3 count how many have same frequency
        int countmax=0;
        for(int i=0;i<26;i++){
            if(freq[i]==maxfreq){
                countmax++;
            }
        }
        // step 4 apply formula
        int calculated=(maxfreq-1)*(n+1)+countmax;

        return Math.max(tasks.length,calculated);

    }
}