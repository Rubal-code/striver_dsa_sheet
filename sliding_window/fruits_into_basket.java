class Solution {
    public int totalFruits(int[] fruits) {
        //your code goes here
        int i=0;
        int j=0;
        int n=fruits.length;
        int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();

        while(j<n){
            // Add current fruit to map
            map.put(fruits[j] , map.getOrDefault(fruits[j],0)+1);
            // If more than 2 types → shrink window
            while(map.size() > 2){
                // reduce the count of left fruit 
                map.put(fruits[i] , map.get(fruits[i])-1);

                // If count becomes 0 → remove from map
                if(map.get(fruits[i])==0){
                    map.remove(fruits[i]);
                }
                i++; // move left pointer
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}