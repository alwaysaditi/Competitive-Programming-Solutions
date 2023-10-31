class interleavingStrings {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
    String strings[][] = new String[s1.length()+1][s2.length()+1];
    dp[0][0]=true;
    strings[0][0]="";
    if(s3.length()!=(s1.length()+s2.length()))
    {
        return false;
    }

    else if(((s1.length()==0)&&(s3.equals(s2)))||((s2.length()==0)&&(s3.equals(s1))))
    {
return true;
    }
    for(int i=0;i<=s1.length();i++)
    {
        //System.out.println(s1.substring(0,i));
if(s3.substring(0,i).equals(s1.substring(0,i)))
{
    dp[i][0]=true;
    strings[i][0] = s1.substring(0,i);
    
}
//System.out.println(dp[0][i]);
    }


       for(int i=0;i<=s2.length();i++)
    {
        //System.out.println(s2.substring(0,i));
if(s3.substring(0,i).equals(s2.substring(0,i)))
{
   // System.out.println(s2.substring(0,i));
    dp[0][i]=true;
 strings[0][i] = s2.substring(0,i);


}
//System.out.println(dp[i][0]);
//System.out.println(strings[i][0]);
    }


    for(int i=1;i<=s1.length();i++)
    {
        for(int j=1;j<=s2.length();j++)
        {
           // System.out.println("i= "+i+"j= "+j); 
            if(dp[i][j-1])
            {
               
                String new_string = strings[i][j-1] + Character.toString(s2.charAt(j-1));
                 //System.out.println("predecessor "+strings[i][j-1]+" checking "+new_string);
//System.out.println(new_string);
                if(s3.substring(0,new_string.length()).equals(new_string))
                {
                    dp[i][j]=true;
                    strings[i][j]=new_string;
              //System.out.println("inserted "+new_string+" predecessor "+strings[i][j-1]);     
                }
            }


            if(dp[i-1][j])
            {
                String new_string = strings[i-1][j] + Character.toString(s1.charAt(i-1));
 //System.out.println("predecessor "+strings[i-1][j]+" checking "+new_string);
                if(s3.substring(0,new_string.length()).equals(new_string))
                {
                    dp[i][j]=true;
                    strings[i][j]=new_string;
                    // System.out.println("inserted "+new_string+" predecessor "+strings[i-1][j]);
                }
            }
        }
    }

    return dp[s1.length()][s2.length()];
    }
}
