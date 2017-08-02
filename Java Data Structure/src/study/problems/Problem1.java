package study.problems;

import java.util.Arrays;

/* Given an array A[] find all possible pair(x1,x2) whose sum is x*/

public class Problem1 {
	
	void pairX(int list[], int key){
		Arrays.sort(list);
		int low=0;
		int high=list.length-1;
		while(low<high){
			if(list[low]+list[high]==key){
				System.out.println("pair:= ("+list[low]+","+list[high]+") : "+key);
				low++;
				high--;
				continue;
			}
			if(list[low]+list[high]>key)
				high--;
			else
				low++;
			
		}
	}
	
	public static void main(String arg[]){
		int list[]={1,3,5,6,2,3,9,5,6,7,8};
		Problem1 p = new Problem1();
		p.pairX(list, 9);
	}
}

