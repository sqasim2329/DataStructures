package com.data.google;

public class FrequentNodeInBST {
	
	public int[] findMode(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
            
            root = stk.pop();
            map.putIfAbsent(root.val,1);
            map.put(root.val,map.get(root.val)+1);
            root = root.right;
        }
        int max =0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(max < entry.getValue()){
                max = entry.getValue();
            }
        }
        List<Integer> ls = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            
            if(entry.getValue()==max){
                ls.add(entry.getKey());
            }
            
        }
        
        return ls.stream().mapToInt(t-> t).toArray();
        
    }

}
