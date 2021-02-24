package backTracking;

public class UnCommonWOrdsBetweenSentences {
	
	public String[] uncommonFromSentences(String A, String B) {
        Map<String,Integer> wordCountMap = new HashMap<>();
        List<String> ls = new ArrayList<>();
        String[] str1 = A.split("\\s+");
        String[] str2 = B.split("\\s+");
        
        for(String a:str1){
            wordCountMap.put(a,wordCountMap.getOrDefault(a,0)+1);
        }
        
        for(String b:str2){
                wordCountMap.put(b,wordCountMap.getOrDefault(b,0)+1);
        }
        
        
        
       return wordCountMap.entrySet().stream().filter(e-> e.getValue()==1).map(e->e.getKey()).toArray(String[]::new);
        
    }

}
