/**
 *
 * Following program calculates the minimum trials in Egg Drop puzzle.
 *
 * Output
 * ------
 * 
 * Minimum number of trials in worst case with 2 eggs and 10 floors is 4
 * 
 * @author pyav
 *
 */
public class EggDropRecursive {

    static int max (int a, int b) {
	return (a > b? a: b);
    }
    
    static int calcMinTrials(int numEggs, int floors) {
	if (numEggs <= 0) {
	    return 0;
	} else if (numEggs == 1) {
	    return floors;
	}
	
	if (floors < 0) {
	    return 0;
	} else if (floors == 1) {
	    return floors;
	}
	
	int x;
	int result;
	int min = Integer.MAX_VALUE;
	for (x = 1; x <= floors; x++) {
	    result = max(calcMinTrials(numEggs, floors - x), calcMinTrials(numEggs - 1, x - 1));
	    if (result < min) {
		min = result; 
	    }
	}
	
	return min + 1;
    }
    
    public static void main(String[] args) {

	int numEggs = 2;
	int floors = 10;
	
	System.out.printf("\nMinimum number of trials in worst case with " + 
			   "%d eggs and %d floors is %d", numEggs, floors, 
			   calcMinTrials(numEggs, floors));
    }

}
