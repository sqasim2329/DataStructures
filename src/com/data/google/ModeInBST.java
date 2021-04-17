package com.data.google;

public class ModeInBST {
	
	public int[] findMode(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        int num = -1;
        int count = 0;
        int max = 0;
        
        List<Integer> ls = new ArrayList<>();
        while(!stk.isEmpty() || root!=null){
            while(root!=null){
                stk.push(root);
                root = root.left;
            }
            
            root = stk.pop();
            
            
            if(num == root.val)
                count++;
            else{
                count=1;
                num = root.val;
            }//similar to Majority element
                
            
            if(max < count){
                ls.clear();
                max = count;
                ls.add(num);
            }else if(max ==count){
                ls.add(num);
            }
            
            root =root.right;
        }
        return ls.stream().mapToInt(i->i).toArray();
   }

}
