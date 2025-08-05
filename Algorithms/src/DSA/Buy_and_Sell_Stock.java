package DSA;

import java.util.HashMap;
import java.util.Map;

public class Buy_and_Sell_Stock {
	
	public static void main(String[] args) {
		
	
	int[] arr = new int[] {7,1,5,3,6,4};
	
	int maxp=0;
	
	int l=0,r=1;
	int n=arr.length;
	
	Map<Integer, Integer> map = new HashMap<>();
	map.put(0, 0);
	
	
	while(r<n) {
		
		if(arr[l]<arr[r]) {
			
			int p = arr[r] - arr[l];
			
			if(p>maxp) {
				
				map.clear();
				map.put(l+1, r+1);
				maxp = p;
			}
		
			
		}
		
		else {
			
			l=r;

		}
		
		r++;
	}
	
	System.out.println("The maximum attainable profit is " + maxp + 
            ", achieved by buying on day " + map.keySet() + 
            " and selling on day " + map.values() + ".");
	
	//var entry = map.entrySet().iterator().next();
//	System.out.printf("The maximum attainable profit is %d, achieved by buying on day %d and selling on day %d.%n",
    //        maxp, entry.getKey(), entry.getValue());

	
}
	
}


