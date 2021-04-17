import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	
	 public List<List<String>> groupStrings(String[] strings) {
	        Map<String,List<String>> map = new HashMap<>();
	        for(String str :strings){
	            int[] tmp = new int[str.length()];
	            for(int i=1;i<str.length();i++){
	                    tmp[i]=((str.charAt(i)-str.charAt(i-1)+26)%26); 
	            }
	            String key = Arrays.toString(tmp);
	            map.putIfAbsent(key,new ArrayList<>());
	            map.get(key).add(str);
	        }
	        List<List<String>> values = new ArrayList<>();
	        for(List<String> val:map.values()){
	            Collections.sort(val,(a,b)->a.compareTo(b));
	            values.add(val);
	        }
	        return values;
	    }

}
