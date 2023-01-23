class FindTownJudge {
    public int findJudge(int n, int[][] trust) {
        .
        int votes[]=new int[n];
        boolean[] voted = new boolean[n];
        Arrays.fill(votes,0);
        Arrays.fill(voted,false);
//nobody voted for him, in a boolean array, it would still remain as false if its status was changed if he didnt vote for anyone.
//possible cases : someone receives no votes and doesnt vote himself : not a town judge
// two people get the same number of votes and the highest : both voted for each other and no town judge
if(n==1)
{
    return 1;
}
if(trust.length==0)
return-1;
//else if(n==1)
//{return 1;}
        for(int i=0;i<trust.length;i++)
        {
voted[trust[i][0]-1]=true;
votes[trust[i][1]-1]++;
        }
int maxv =-1;
int index =0;
for(int i=0;i<votes.length;i++)
{
    if(votes[i]>maxv)
    {
        maxv=votes[i];
        index=i;
    }
}
if(voted[index]==true)
{
    return -1;
}
else if(maxv==n-1)
{
return (index+1);
}
else return -1;
    }
}
