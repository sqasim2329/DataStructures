package backTracking;

public class PowerSet {
	
	public List<String> AllPossibleStrings(String s)
    {
        List<String> ls = new ArrayList<>();
        backTrack(s,ls,"",0);
        Collections.sort(ls);
        return ls;
    }
    
    private void backTrack(String s, List<String> ls, String t, int indx){
        
        if(indx >= s.length()){
            return ;
        }
            
        
        
        for(int i=indx;i<s.length();i++){
            ls.add(t+s.charAt(i));
            backTrack(s,ls,t+s.charAt(i),i+1);
        }
            
    }

}
