package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> answer = new ArrayList<String>();
        for(int i=2;i<=n;i++)
        {//the den
            for(int j=1;j<i;j++)
            {//the numerator
                if(findGCD(i,j)!=1)
                {
                    continue;
                }
                else
                {
                    answer.add(Integer.toString(j)+"/"+Integer.toString(i));
                }
            }
        }
        return answer;
    }
    int findGCD(int num1,int num2)
    {
        if(num1%num2==0)
        {
            return num2;
        }
        else
        {
            while((num2>0)&&(num1>0))
            {
                if(num1>num2)
                {
                    num1=num1-num2;
                }
                else
                {
                    num2=num2-num1;
                }
            }
        }
        if(num1>0)
        {
            return num1;
        }
        else return num2;
    }
}
