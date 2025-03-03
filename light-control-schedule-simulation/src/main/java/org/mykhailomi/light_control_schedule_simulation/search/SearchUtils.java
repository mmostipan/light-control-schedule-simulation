package org.mykhailomi.light_control_schedule_simulation.search;

public class SearchUtils {
	
	private SearchUtils() {}
	
 	public static int binarySearchLeftmostHour(int[] array, int n) {
		int l = 0;
		int r = array.length;
		
		while (l < r) {
			int m = (l + r) / 2;
			
			if (array[m] == n) { return m; }
			
			if (array[m] < n) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		
		return --l;
	}

}
