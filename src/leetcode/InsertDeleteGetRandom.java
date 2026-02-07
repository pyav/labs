/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * 
 * Output:
 * ------
 * 2
 * 2
 * 2
 * 1
 */

import java.util.HashSet;
import java.util.Set;

public class InsertDeleteGetRandom {
	
	Set<Integer> set = null;
	
	public InsertDeleteGetRandom() {
		this.set = new HashSet<Integer>();
    }
    
    public boolean insert(int val) {
    	boolean isExist = false;
        
        if (!this.set.contains(val)) {
        	isExist = true;
        	this.set.add(val);
        }
        
        return isExist;
    }
    
    public boolean remove(int val) {
        boolean isExist = false;
        
        if (this.set.contains(val)) {
        	isExist = true;
        	this.set.remove(val);
        }
        
        return isExist;
    }
    
    public int getRandom() {
        double rand = Math.random() * this.set.size();
        Object[] arr = this.set.toArray();
        return (int) arr[(int) rand];
    }

	public static void main(String[] args) {
		InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
		obj.insert(1);
		obj.remove(2);
		obj.insert(2);
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
	}

}
