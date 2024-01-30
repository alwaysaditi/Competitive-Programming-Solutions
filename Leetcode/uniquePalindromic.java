class Solution {
    public int countPalindromicSubsequence(String s) {
        int start [] = new int[26];
        int end[] = new int[26];
        Arrays.fill(start,-1);
int finalcount =0;
        for(int i=0;i<s.length();i++)
        {
            int numeric = s.charAt(i)-97;

            if(start[numeric]==-1)
            {
                start[numeric]=i;
            }

            else
            {
                end[numeric]=i;
            }
           
        }

        for(int i=0;i<start.length;i++)
        {
            if(start[i]==-1)
            {
                continue;
            }

            else
            {
                HashMap<Integer,Boolean> encountered = new HashMap<Integer,Boolean>();
                for(int j=start[i]+1;j<end[i];j++)
                {
                    int current = s.charAt(j)-97;
if(encountered.containsKey(current))
{
    continue;
}

else
{
    finalcount++;
    encountered.put(current,true);
}
                }
            }
        }

        return finalcount;
    }
}
