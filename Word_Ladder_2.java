class Solution
{
    String b;
    HashMap<String,Integer>map;
    ArrayList<ArrayList<String>>ans;
    public void dfs(String word,ArrayList<String> seq)
    {
        if(word.equals(b))
        {
            ArrayList<String> dup=new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int steps=map.get(word);
        for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char replaceCharArray[]=word.toCharArray();
                    replaceCharArray[i]=ch;
                    String replacedWord=new String(replaceCharArray);
                    if(map.containsKey(replacedWord) && map.get(replacedWord)+1==steps)
                    {
                        //map.put(replacedWord,steps-1);
                        seq.add(replacedWord);
                        dfs(replacedWord,seq);
                        seq.remove(seq.size()-1);
                    }
                }
            }
    }
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String> st=new HashSet<>();
        for(String s:wordList)
        {
            st.add(s);
        }
        b=startWord;
        Queue<String>qu=new LinkedList<>();
        qu.add(b);
        map=new HashMap<>();
        map.put(b,1);
        st.remove(b);
        int size=b.length();
        while(qu.size()>0)
        {
            String word=qu.peek();
            int steps=map.get(word);
            qu.poll();
            if(word.equals(targetWord))
            break;
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char replaceCharArray[]=word.toCharArray();
                    replaceCharArray[i]=ch;
                    String replacedWord=new String(replaceCharArray);
                    if(st.contains(replacedWord))
                    {
                        st.remove(replacedWord);
                        qu.add(replacedWord);
                        map.put(replacedWord,steps+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        
        if(map.containsKey(targetWord))
        {
            ArrayList<String> seq=new ArrayList<>();
            seq.add(targetWord);
            dfs(targetWord,seq);
        }
        return ans;
    }
}
