package study.problems;

/* Given an array a[]. find the majority element of the list. Majority element means 
 * number of occurrence of element is more than n/2 where 
 * n is the size of the list */

/*
 * Using Moors voting algorithm.
 * Complexity is O(n)*/

public class Problem2 {

	int FindCandidateElement(int list[]){
		int can_index = 0;
		int count = 1;
		
		for(int i=1;i<list.length;i++){
			if(list[can_index]==list[i])
				count++;
			else
				count--;
			if(count==0){
				count=1;
				can_index=i;
			}
		}
		return list[can_index];
	}
	
	void findMajorityElement(int list[]){
		int cand_element=FindCandidateElement(list);
		int count=0;
		for(int i=0;i<list.length;i++)
			if(list[i]==cand_element)
				count++;
		if(count>list.length/2)
			System.out.println("Majority Element is: "+cand_element);
		else
			System.err.println("The list has no majority elemene");
	}
	
	
	public static void main(String arg[]){
		int list[]={1,3,1,2,1,1,1,3};
		new Problem2().findMajorityElement(list);
	}
}
  