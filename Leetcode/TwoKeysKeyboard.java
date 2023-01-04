class TwoKeyKeyboard{
    public int minSteps(int n) {
        int memoize[] = new int[1000];
        Arrays.fill(memoize,-1);
        int answer =-1;
        memoize[0]=0;
        memoize[1]=2;
        memoize[2]=3;
        memoize[4]=5;
        memoize[6]=7;
        memoize[10]=11;
        memoize[12]=13;
        memoize[16]=17;
        memoize[18]=19;

        if(memoize[n-1]!=-1)
        {
            return memoize[n-1];
        }
        else
        {
            answer = recursive(memoize,n);
        }

        return answer;

    }

    public int recursive(int[] memoize,int n)
    {
        int answer=-1;
        if(memoize[n-1]!=-1)
        {
            answer= memoize[n-1];
        }

        else
        {
            for(int i=n-2;i>=0;i--)
            {
                if((n%(i+1)==0)&&(memoize[i]!=-1))
                {
                    if(i!=0)
                    {
                        System.out.println("largest divisor of n= "+n+" is "+(i+1));
                        answer= ((n/(i+1))+memoize[i]);
                        memoize[n-1]=answer;

                        System.out.println("memoize of "+(n)+" is "+answer);
                        break;
                    }
                    else
                    {
                        memoize[n-1]= n;
                        answer=n;
                    }


                }

                else
                {
                    recursive(memoize,(i+1));
                }

            }
        }
        return answer;
    }
}