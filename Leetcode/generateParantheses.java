//generate paranthesis
class Solution {
    List<String> answer = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        recursive(n,n,"");
        return answer;
    }

    void recursive(int open, int close, String str)
    {
        if((open==0)&&(close==0))
        {
            //System.out.println(str);
            answer.add(str);
        }

        else if(open==close)
        {
            str = str + '(';
             recursive(open-1,close,str);
        }

        else if(open<close)
        {
            if(open>0)
            {
                   str = str + '(';
                   recursive(open-1,close,str);
                   str = str.substring(0,str.length()-1);
            }

            if(close >0)
            {
                str = str +')';
                   recursive(open,close-1,str);
                   str = str.substring(0,str.length()-1) ;
            }
        }
    }


}
