//letter case permutations 

class Solution {
    List<String> answer = new ArrayList<String>();
    int finallength;
    public List<String> letterCasePermutation(String s) {
         finallength = s.length();
        recursive(0,s,"");
       
        
        return answer;
    }

    void recursive(int index,String s, String str)
    {
 
        if(index==finallength)
        {
          
            answer.add(str);

        }
        else if(Character.isDigit(Character.valueOf(s.charAt(index))))
        {
            str = str + s.charAt(index);
           
           // System.out.println(str);
            recursive(index+1,s,str);
             if(str.length()>0)
            {
  str = str.substring(0,str.length()-1);
            }
        }

 else if(Character.isLetter(Character.valueOf(s.charAt(index))))
        {
         
 str = str+Character.toLowerCase(Character.valueOf(s.charAt(index)));
   
            recursive(index+1,s,str);
              if(str.length()>0)
            {
  str = str.substring(0,str.length()-1);
            }
 str = str+Character.toUpperCase(Character.valueOf(s.charAt(index)));
          
            recursive(index+1,s,str);
            if(str.length()>0)
            {
  str = str.substring(0,str.length()-1);
            }
          
        }
    
    }
}
