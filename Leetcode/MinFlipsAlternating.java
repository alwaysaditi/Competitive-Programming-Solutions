package Leetcode;
// Leetcode 1888 : Minimum Flips to make string alternating
public class MinFlipsAlternating {
    public int minFlips(String s) {
        int evenones =0;
        int oddones=0;
        int evenzeros=0;
        int oddzeros=0;
        if(s.length()==1)
        {
            return 0;
        }
        for(int i=0;i<s.length();i++)
        {
            if(i%2==0)
            {
                if(s.charAt(i)=='1')
                {
                    evenones++;
                }
                else
                {
                    evenzeros++;
                }
            }
            else
            {
                if(s.charAt(i)=='0')
                {
                    oddzeros++;
                }
                else
                {
                    oddones++;
                }
            }
        }
        //  System.out.println((evenones)+(evenzeros)+(oddones)+(oddzeros));
        //  System.out.println(oddones);
        // System.out.println(oddzeros);
        //  System.out.println(evenones);
        //  System.out.println(evenzeros);
        int flag = s.length()%2;
//System.out.println(flag);
        //dont think about it greedily
        //thinking about it greedily just solves the problem for the starting and ending positions and doesnt change stuff for the whole string
        //no. of cycles = length-1
        int  minones = Integer.MAX_VALUE;
        int  minzeros = Integer.MAX_VALUE;
        int total = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++)
        {
            // count for present round then change itfor the next round
            // System.out.println("oddones= "+oddones+" evenones= "+evenones+" oddzeros= "+oddzeros+" evenzeros= "+evenzeros);
            minones = Math.min(oddones,evenones);
            minzeros= Math.min(oddzeros,evenzeros);
            if((minones+minzeros)<total)
            {
                total = minones+minzeros;
            }
//System.out.println("total= "+total);
            if(s.charAt(i)=='1')
            {
                int temp = evenzeros;
                evenzeros=oddzeros;
                oddzeros=temp;
// remove the character that is gonna go to the back. by subtracting one from the evens. then flip evens to odds and vice versa and then add to evens or odds behind by deciding from length lf string
                evenones--;
                temp=evenones;
                evenones=oddones;
                oddones=temp;
                if(flag==0)
                {
                    oddones++;
                    //evenones--;
                }
                else
                {
                    evenones++;
                    //  oddones--;
                }

            }


            else if(s.charAt(i)=='0')

            {
                int temp= evenones;
                evenones=oddones;
                oddones=temp;
                evenzeros--;
//oddzeros--;
                temp = evenzeros;
                evenzeros=oddzeros;
                oddzeros=temp;
                if(flag==0)
                {
                    //evenzeros--;
                    oddzeros++;
                }
                else
                {
                    evenzeros++;
                    // oddzeros--;
                }

            }


        }

        return total;
    }
}
