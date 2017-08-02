package study.sortedArray;

import java.util.Scanner;

public class SortedArray {
	
	private int list[];
	private int size;
	
	SortedArray(){
		list = new int[10];
		size=0;
	}
	SortedArray(int capacity){
		list = new int [capacity];
		size=0;
	}
	int createList(){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int num=0;
		while(size!=list.length){
			try{
				System.out.print("Enter Element ");
				num = keyboard.nextInt();
				if(num==-1) break;
				list[size++]=num;
			}catch(Exception e){
				System.out.println("Invalid key. numbers only");
				keyboard.nextLine();
			}
		}
		return 1;
	}
	
	int binarySearch(int key){
		int low=0;
		int high=size-1;
		int mid;
		while(low<=high){
			mid=(low+high)/2;
			if(list[mid]==key) return mid;
			if(list[mid]<key){
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		return -1;
	}

	public static void main(String arg[]){
		SortedArray s =  new SortedArray();
		s.createList();
		System.out.println("List Search status: "+s.binarySearch(3));
		System.out.println("List Search status: "+s.binarySearch(10));
	}
}
