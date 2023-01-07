// Letter Combinations of a Phone number : Leetcode 17
// Backtracking with Hashtable
class LetterCombinations {
    List<String> answer=new ArrayList<String>();
    public List<String> letterCombinations(String digits) {

        HashMap<Character, Character[]> mapping = new HashMap<Character, Character[]>();

        mapping.put('2',new Character[]{'a','b','c'});
        mapping.put('3',new Character[]{'d','e','f'});
        mapping.put('4',new Character[]{'g','h','i'});
        mapping.put('5',new Character[]{'j','k','l'});
        mapping.put('6',new Character[]{'m','n','o'});
        mapping.put('7',new Character[]{'p','q','r','s'});
        mapping.put('8',new Character[]{'t','u','v'});
        mapping.put('9',new Character[]{'w','x','y','z'});
        char [] digitsar = digits.toCharArray();
        System.out.println("length= "+digitsar.length);
        Character[] digitsarr = new Character[digitsar.length];
        Character start='2';
        for(int i=0;i<digitsarr.length;i++)
        {
            digitsarr[i] = Character.valueOf(digitsar[i]);
            if(i==0)
            {
                start = digitsarr[i];
            }
            System.out.println(digitsarr[i]);
        }

        findCombinations(digitsarr,start,mapping,"",0);
        return answer;

    }

    void findCombinations(Character[]digitsarr, Character letter, Map<Character,Character[]> mapping,
                          String ans,int k)
    {

        k++;
        Character[] temparr = mapping.get(letter);
        int size = temparr.length;
        for(int i=0;i<size;i++)
        {

            ans = ans+temparr[i];

            if(k<(digitsarr.length))
            {

                findCombinations(digitsarr,digitsarr[k],mapping,ans,k);

            }
            if(k==(digitsarr.length))
            {
                System.out.println(ans);

                answer.add(ans);

            }
            ans = ans.substring(0, ans.length() - 1);
        }




    }


}