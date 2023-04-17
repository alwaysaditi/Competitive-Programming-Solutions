package Leetcode;

//Kth Lexicographical String of all Happy Strings of length n
class HappyStrings {
    public String getHappyString(int n, int k) {

        String answer[];

        answer = recursive(n);


        String finalanswer;
        if(k-1>=answer.length)
        {
            finalanswer="";
        }
        else
        {
            finalanswer= answer[k-1];
        }
        return finalanswer;

    }

    public String[] recursive(int n)
    {
        String ref[] = {"a","b","c"};
        int startscore =0;
        int endscore = 0;
        int lengthref;
        String refarray[];
        if(n==1)
        {
            return ref;
        }
        else
        {

            refarray= recursive(n-1);
            lengthref = refarray.length;


        }


        int length =
                lengthref*2;
        String answer[] = new String[length];
        //System.out.println("length= "+length+" and lengthref= "+lengthref);
        int i=0;
        int j=0;
        while(i<(lengthref))
        {
            System.out.println("i= "+i);
            char endLetter = refarray[i].charAt(refarray[i].length()-1);
            //System.out.println("endletter= "+endLetter);
            if (endLetter=='a')
            {
                answer[j] = refarray[i]+"b";
                j++;

                answer[j]= refarray[i]+"c";
                j++;

            }


            else  if (endLetter=='b')
            {
                answer[j] = refarray[i]+"a";
                j++;
                answer[j]= refarray[i]+"c";
                j++;

            }

            else
            {
                answer[j] = refarray[i]+"a";
                j++;

                answer[j]= refarray[i]+"b";
                j++;
            }
            i++;

        }
        return answer;
    }
}