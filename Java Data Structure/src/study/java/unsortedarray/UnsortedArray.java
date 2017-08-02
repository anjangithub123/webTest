package study.java.unsortedarray;

import java.util.Scanner;

public class UnsortedArray {
	private int list[];
	private int listSize;
	
	public UnsortedArray() {
		setList(new int[10]);
		listSize=0;
	}
	UnsortedArray(int capacity){
		setList(new int[capacity]);
		listSize=0;
	}
	
	public int[] getList() {
		return list;
	}
	public void setList(int list[]) {
		this.list = list;
	}
	public int getListSize() {
		return listSize;
	}
	
	int searchElement(int key){
		for(int i=0;i<listSize;i++){
			if(list[i]==key) return i;
		}
		return -1;
	}
	int insertElement(int key, int postion){
		//System.out.println("list lenght: "+list.length+" List size: "+listSize);
		if(list.length==listSize) return -1;
		if(list.length<=postion) return -2;
		  for(int i=listSize-1;i>=postion;i--){
			list[i+1]=list[i];
		}   
		  list[postion]=key;
		  if(listSize-1<=postion){
			  listSize=postion+1;
			  return 1;
		  }
		  listSize++;
		return 1;
	}
	int insertAllElemets(int data[], int position){
		int insert_size=0;
		for(int i=0;i<data.length;i++){
			if(insertElement(data[i],position+i)<0) break;
			insert_size++;
		}
		return insert_size;
	}
	int deleteElement(int key){
		int postion=searchElement(key);
		if(postion<0){
			System.out.println("Element is not fount in the list");
			return -1;
		}
		for(int i=postion;i<list.length-1;i++){
			list[i]=list[i+1];
		}
		listSize--;
		return 1;
	}  
	int deleteAllElements(int key){
		int tempList[] = new int [listSize];
		int temp_index=0;
		int i;
		for(i=0;i<listSize;i++){
			if(list[i]!=key){
				tempList[temp_index]=list[i];
				temp_index++;
			}
		}
		list=tempList;
		listSize=temp_index;
		return i-temp_index;
		
	}
	int createList(){
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		int a = 0;
		while(true){
			if(list.length==listSize){
				System.out.println("Capacity Error");
				break;
			}
			System.out.println("Enter the Input: ");
			try{
				a =sc.nextInt();
			}catch(Exception e){
				System.out.println("ERROR: Numbers are valid!!");
				sc.nextLine();
				continue;
			}
			if (a==-1) break;
			list[listSize]=a;
			listSize++;
		}
		return 1;
	}
	void displayList(){
		for(int i=0;i<listSize;i++){
			System.out.print(list[i]+" ");
		}
	}
	
	public static void main(String arg[]){
		UnsortedArray s= new UnsortedArray();
		s.createList();
		s.displayList();
	/*	int k=s.searchElement(10);
		if(k>0){
			System.out.println("Element is found");
		}
		else{
			System.out.println("Element is not found");
		}
		k=s.insertElement(4, 2);
		if(k<0){
			System.out.println("Insertion ERROR");
		}
		s.deleteElement(5);
		s.displayList();
		System.out.println("no of key deleted "+s.deleteAllElements(2));
		System.out.println("no of key deleted "+s.deleteAllElements(100));*/
		int data[]={3,4,5};
		System.out.println("Insert Size: "+s.insertAllElemets(data, 3));
		s.displayList();
		int data1[]={1,2,3};
		System.out.println("Insert Size: "+s.insertAllElemets(data1, 7));
		s.displayList();
		}		
}
