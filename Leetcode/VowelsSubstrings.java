// leetcode 2063 : DP without recursion
class VowelsSubstrings {
    public long countVowels(String word) {
        long answer =0;
        long strlen = word.length();

        for(int i=0;i<word.length();i++)
        {
            if((word.charAt(i)=='a')||(word.charAt(i)=='e')||(word.charAt(i)=='i')||(word.charAt(i)=='o')||(word.charAt(i)=='u'))
            {
                answer = answer + countEach(i,strlen);
            }


        }
        return answer;
    }

    public long countEach(int index,long strlen)
    {
        long left = index;
        long right = strlen - index-1;
        long combine = left*right;
        return(left+right+combine+1);
    }
}