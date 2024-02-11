class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int last = triangle.size();
        int answer = Integer.MAX_VALUE;
        if(last==1)
        {
            return triangle.get(0).get(0);
        }
        for(int i=1;i<triangle.size();i++)
        {   
            
                for(int j=0;j<triangle.get(i).size();j++)
                {
                    int left , right;
if(j-1>=0)
{
    left = triangle.get(i-1).get(j-1);
    
}

else
{
    left = Integer.MAX_VALUE;
}

//System.out.println("left= "+left);
if(j<triangle.get(i-1).size())
{
right = triangle.get(i-1).get(j);
}

else 
{
    right = Integer.MAX_VALUE;
}

//System.out.println("rightt= "+right);

int result = Math.min(left,right);
//System.out.println("old value ="+triangle.get(i).get(j));

triangle.get(i).set(j,triangle.get(i).get(j)+result);
//System.out.println("new value ="+triangle.get(i).get(j));
if((i==triangle.size()-1)&&(triangle.get(i).get(j)<answer))
{
answer = triangle.get(i).get(j);
}
                }
            }
    return answer;    
    }
}
