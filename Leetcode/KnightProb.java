// knight probability : recursive , backtracking

class Solution {
    int dimension,rounds;
    double total;
    public double knightProbability(int n, int k, int row, int column) {
        dimension =n; rounds =k;
        recursive(row,column,1,0);
        return total;
    }

    void recursive(int m , int n , double prob, int k)
    
    {

if(k==rounds)
{
total = total + prob;
return;
}

else
{
    if((m-2>=0)&&(n-1>=0))
    {
recursive(m-2,n-1,prob*0.125,(k+1));
    }

    if((m-2>=0)&&(n+1<=dimension-1))
    {
        recursive(m-2,n+1,prob*0.125,(k+1));
    }

    if((m+2<=dimension-1)&&(n-1>=0))
    {
        recursive(m+2,n-1,prob*0.125,(k+1));
    }
    if((m+2<=dimension-1)&&(n+1<=dimension-1))
    {
        recursive(m+2,n+1,prob*0.125,(k+1));
    }
    if((m-1>=0)&&(n+2<=dimension-1))
    {
        recursive(m-1,n+2,prob*0.125,(k+1));
    }
    if((m-1>=0)&&(n-2>=0))
    {
        recursive(m-1,n-2,prob*0.125,(k+1));
    }
    if((m+1<=dimension-1)&&(n-2>=0))
    {
        recursive(m+1,n-2,prob*0.125,(k+1));
    }
    if((m+1<=dimension-1)&&(n+2<=dimension-1))
    {
        recursive(m+1,n+2,prob*0.125,(k+1));
    }
}
    }
}
