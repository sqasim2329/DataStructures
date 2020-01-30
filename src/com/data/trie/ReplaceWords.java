package com.data.trie;

public class ReplaceWords {
	
	public static void main(String args[]) {
		String[] dict = {"cat", "bat", "rat","co","ca"};
		String sentence = "the cattle was rattled by the battery";
		NodeTrie root=new NodeTrie();
        
        for(int i=0;i<dict.length;i++)
            createTrie(dict[i],root);
        
        String[] words=sentence.split("\\s");
        for(int j=0;j<words.length;j++){
        	NodeTrie current = root;
            String word=words[j];
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(current.children.containsKey(ch) && !current.endOfWord){
                    current=current.children.get(ch);
                }else if(current.endOfWord){
                    words[j]=word.substring(0,i);
                    break;
                }else{
                    break;
                }
            }
        }
        
        System.out.println(String.join(" ",words));
	}

	private static void createTrie(String word, NodeTrie root) {
		NodeTrie current=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            NodeTrie node=current.children.get(ch);
            if(node==null){
                node = new NodeTrie();
                current.children.put(ch,node);
            }
            current=node;
        }
        current.endOfWord=true;		
	}

}
