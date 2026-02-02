class Solution {
    public int findMaximumCookieStudents(int[] Student, int[] Cookie) {
        //your code goes here
        Arrays.sort(Student);
        Arrays.sort(Cookie);
        // greedy approach
        int i=0;//student pointer
        int j=0;//Cookie pointer
        int count=0;// max number of students that will be satisfied
        while(i<Student.length && j<Cookie.length){
            if(Cookie[j] >= Student[i]){
                // assign cookie to student
                count++;
                i++;
                j++;
            }
            else{
                // too small cookie , try next cookie
                j++;
            }
        }
        return count;
    }
}