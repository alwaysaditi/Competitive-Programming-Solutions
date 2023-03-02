import java.util.Collections;
import java.util.HashMap;

class MinCardPickUp{
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> first = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> diff = new HashMap<Integer,Integer>();
        for(int i=0;i<cards.length;i++)
        {
            if(first.containsKey(cards[i]))
            {
                if(diff.containsKey(cards[i])){
                if(diff.get(cards[i])>(i-first.get(cards[i])+1)){
                diff.put(cards[i],(i-first.get(cards[i])+1));
                }

            }
            else
            {
            diff.put(cards[i],(i-first.get(cards[i])+1));
            }}
            first.put(cards[i],i);

        }
        if(diff.isEmpty())
        {
return -1;
        }
        return Collections.min(diff.values());

    }
}