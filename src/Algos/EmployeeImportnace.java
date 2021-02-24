package Algos;

public class EmployeeImportnace {
	
	class Solution {
	    public int getImportance(List<Employee> employees, int id) {
	        
	        Map<Integer,Employee> employeeIdMap = new HashMap<>();
	        populateMap(employeeIdMap,employees);
	        return getImportance(id,employeeIdMap);
	        
	    }
	    
	    private void populateMap(Map<Integer,Employee> employeeIdMap,List<Employee> employees){
	        for(Employee emp:employees){
	            employeeIdMap.put(emp.id,emp);
	        }
	    }
	    
	    private int getImportance(int id,Map<Integer,Employee> employeeIdMap){
	        int total =0;
	        Employee emp = employeeIdMap.get(id);
	        for(Integer sub:emp.subordinates){
	            total+=getImportance(sub,employeeIdMap);
	        }
	        return total+emp.importance;
	    }
	}

}
