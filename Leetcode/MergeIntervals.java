class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        for (int i = 0; i <= n - 1; i++) {
        
        for (int j = 0; j < n - i - 1; j++) {
            int []temp = new int[2];
            if (intervals[j][0] > intervals[j + 1][0]) {
               // swap(arr[j], arr[j + 1]);
                temp = intervals[j];
                intervals[j] = intervals[j+1];

                intervals[j+1] = temp;
            }
        }
    }
List<List<Integer>>arrayList = new ArrayList<List<Integer>>();

for(int i=0;i<intervals.length;i++)
{
    List<Integer> temp = new ArrayList<Integer>();
    temp.add(intervals[i][0]);
    temp.add(intervals[i][1]);
    arrayList.add(temp);
}
//System.out.println("printing sorted "+arrayList);
int i =1;

while(i<arrayList.size())
{
     //System.out.println("current state= "+arrayList);
    //System.out.println("element in considertauion= "+arrayList.get(i));
    if(arrayList.get(i).get(0)<=arrayList.get(i-1).get(1))
    {
        
        int var = arrayList.get(i-1).get(1);
        arrayList.get(i-1).remove(1);
        arrayList.get(i-1).add(Math.max(arrayList.get(i).get(1),var));
        arrayList.remove(i);
    }

    else
    {
        i++;
    }
}
//System.out.println(arrayList);
int[][] answer = new int[arrayList.size()][2];

for(int j=0;j<answer.length;j++)
{
    answer[j][0] = arrayList.get(j).get(0);
    answer[j][1] = arrayList.get(j).get(1);
}
return answer;

}
}
