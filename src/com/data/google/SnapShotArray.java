package com.data.google;

public class SnapShotArray {
	
	class SnapshotArray {
	    
	    class Snapshot{
	        TreeMap<Integer,Integer> snapMap;
	        public Snapshot(){
	            snapMap = new TreeMap<>();
	        }
	    }
	    
	    Snapshot[] arr;
	    int snap=0;

	    public SnapshotArray(int length) {
	        arr = new Snapshot[length];
	        for(int i=0;i<length;i++){
	            arr[i] = new Snapshot();
	            arr[i].snapMap.put(0,0);// data is such that we can be asked to get snapId that doesnt exists
	        }
	    }
	    
	    public void set(int index, int val) {
	        arr[index].snapMap.put(snap,val);
	    }
	    
	    public int snap() {
	        snap++;
	        return snap-1;
	        
	        
	    }
	    
	    public int get(int index, int snap_id) {
	        return arr[index].snapMap.floorEntry(snap_id).getValue();
	    }
	}

}
