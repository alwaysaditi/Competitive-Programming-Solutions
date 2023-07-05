// leetcode 2140: solving questions with brainpower DP 

class QuestionsBrainpower {
    public long mostPoints(int[][] questions) {
    long maxval , maxuntiln , ans;
    maxval = maxuntiln = ans = 0;
    long  currsum[] = new long [questions.length];
    long  maxuntil[] = new long [questions.length];

    for(int i=0;i<questions.length;i++)
    {
        maxval = Math.max(maxuntiln, currsum[i]);
        maxval = Math.max(maxval,maxuntil[i]);
        currsum[i] = questions[i][0] + maxval;

        if((questions[i][1]+i+1)<=maxuntil.length-1)
        {
            if(currsum[i]>maxuntil[questions[i][1]+i+1])
            {
                maxuntil[questions[i][1]+i+1] = currsum[i];
            }
        }
        if(maxuntiln<maxuntil[i])
        {
            maxuntiln = maxuntil[i];
        }
         ans = Math.max(ans,currsum[i]);
    }   
    return ans; 
    }
}
