//pure backtracking
class Solution {
  
    boolean[] added;
   List<List<Integer>>answer = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        added = new boolean[n];   
List<Integer> temp;

for(int i=0;i<=n-k;i++)
{

temp = new ArrayList<Integer>();
temp.add(i+1);
added[i]=true;

recursive(i,k-1,temp);
added[i]=false;
temp.remove(temp.size()-1);

}
  
       return answer;
    }


  void  recursive(int index,int k, List<Integer>temp)
    {
   
if(k==0)
{
  //System.out.println(temp);
    answer.add(new ArrayList<>(temp));
    return;
}

else
{
for(int i=index+1;i<added.length;i++)
{
    if(added[i]==true)
    {
        continue;
    }

    else
    {
        temp.add(i+1);
      
        added[i]=true;
        k--;
        recursive(i,k,temp); // this i becomes the index that should not be added. since the logic of combinations follows the ascending order to prevent duplications and 
      // element at index i (i.e i+1) has already been added

        temp.remove(temp.size()-1);
        k++;
        added[i]=false;
    }
}
}
    }
}
