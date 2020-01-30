package com.data.trie;

class TNode
{
    TNode children[]=new TNode[26];
    boolean endOfWord;
    TNode()
    {
        endOfWord=false;
    }
}
public class CountDistinctSubstrings{
    static void insert(TNode current,String word,int k)
    {
        int l=word.length();
        for(int i=k;i<l;i++)
        {
            int ch=word.charAt(i)-'a';
            if(current.children[ch]==null)
            {
                c++;
                current.children[ch]=new TNode();
            }
            current=current.children[ch];
            current.endOfWord=true;
        }
    }
   static int c=0;
   public static void main(String args[])
   {
	   String st="abb";
      TNode root=new TNode();
      int n=st.length();
      c=0;
      for(int i=0;i<n;i++)
      {
              insert(root,st,i);
      }
      System.out.println(c);
   }
}
