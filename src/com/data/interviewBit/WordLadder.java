package com.data.interviewBit;



public class WordLadder {
//	https://leetcode.com/problems/as-far-from-land-as-possible/	
	class Solution {
	    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        
	        Queue<String> q = new LinkedList<>();
	        Set<String> seen = new HashSet<>(wordList);
	        q.add(beginWord);
	        int distance =1;
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int j=0;j<size;j++){
	                String word = q.poll();
	                if(word.equals(endWord))
	                    return distance;
	                for(int i=0;i<word.length();i++){
	                    char tmp = word.charAt(i);
	                    char[] wordChar = word.toCharArray();
	                    for(char c='a';c<='z';c++){
	                        char chr = wordChar[i];
	                        wordChar[i] = c;
	                        String w = new String(wordChar);
	                        if(!seen.contains(w)) continue;
	                        seen.remove(w);
	                        q.add(w);
	                        wordChar[i] = chr;
	                    }
	                    wordChar[i]=tmp;
	                }
	                
	            }
	            distance++;
	        }
	        
	        return 0;
	        
	    }
	}
	
	
	
	class Solution {
	    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	            Set<String> wordSet = new HashSet<>(wordList);
	            HashMap<String,List<String>> neigh = new HashMap<>();
	            HashMap<String,Integer> dist = new HashMap<>();
	            List<List<String>> result = new ArrayList<>();
	            List<String> ls = new ArrayList<>();
	        
	            bfs(beginWord,endWord,wordSet,neigh,dist);
	            dfs(beginWord,endWord,wordSet,neigh,dist,ls,result);
	            return result;
	            
	    }
	    
	    
	    private void dfs(String beginWord,String endWord, Set<String> wordSet,HashMap<String,List<String>> neigh,HashMap<String,Integer> dist, List<String> ls, List<List<String>> res){
	            List<String> neighBours = neigh.get(beginWord);
	            ls.add(beginWord);
	            if(beginWord.equals(endWord)){
	                res.add(new LinkedList<String>(ls));
	            }else{
	                int currDisatnce = dist.get(beginWord);
	                for(String neighBour:neighBours){
	                    if(dist.get(neighBour)==currDisatnce+1){        
	                        dfs(neighBour,endWord,wordSet,neigh,dist,ls,res);
	                    }
	                }    
	            }
	        ls.remove(ls.size()-1);
	            
	    }
	    
	    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
	            ArrayList<String> res = new ArrayList<String>();
	            char chs[] = node.toCharArray();

	            for (char ch ='a'; ch <= 'z'; ch++) {
	                for (int i = 0; i < chs.length; i++) {
	                    if (chs[i] == ch) continue;
	                        char old_ch = chs[i];
	                        chs[i] = ch;
	                      if (dict.contains(String.valueOf(chs))) {
	                              res.add(String.valueOf(chs));
	                        }
	                    chs[i] = old_ch;
	                }
	            }
	        return res;
	        }
	    
	    private void bfs(String beginWord,String endWord, Set<String> wordSet,HashMap<String,List<String>> neigh,HashMap<String,Integer> dist){
	        Queue<String> q = new LinkedList<>();
	        q.add(beginWord);
	        dist.put(beginWord,0);
	        while(!q.isEmpty()){
	            int size = q.size();
	            boolean foundEnd =false;
	            for(int i=0;i<size;i++){
	                String word = q.poll();
	                int currDisatnce = dist.get(word);
	                List<String> neighBours = getNeighbors(word,wordSet);
	                neigh.putIfAbsent(word,new ArrayList<>());
	                for(String neighBour: neighBours){
	                    neigh.get(word).add(neighBour);
	                    if(!dist.containsKey(neighBour)){
	                        dist.put(neighBour,currDisatnce+1);
	                        if(neighBour.equals(endWord)){
	                            foundEnd = true;
	                        }else{
	                            q.add(neighBour);    
	                        }
	                        
	                    }
	                }
	                if(foundEnd)
	                break;
	            }
	        }
	    }
	    
	    
	}


	 

}
