class Pair
{
    String word;
    int level;
    Pair(String word,int level)
    {
        this.word=word;
        this.level=level;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String> set=new HashSet<>();
        for(String s:wordList)
        {
            set.add(s);
        }
        Queue<Pair>qu=new LinkedList<>();
        qu.offer(new Pair(startWord,1));
        set.remove(startWord);
        while(qu.size()>0)
        {
            String word=qu.peek().word;
            int steps=qu.peek().level;
            qu.poll();
            if(word.equals(targetWord))
                return steps;
            //for checking the words
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char replaceCharArray[]=word.toCharArray();
                    replaceCharArray[i]=ch;
                    String replacedWord=new String(replaceCharArray);
                    if(set.contains(replacedWord))
                    {
                        set.remove(replacedWord);
                        qu.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
