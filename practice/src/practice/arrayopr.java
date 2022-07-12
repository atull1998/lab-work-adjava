package practice;
import java.util.*;

public class arrayopr {

	public static void main (String args[]) {
		
		ArrayList <Integer> list=new ArrayList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(2, 15);
		list.add(60);
		//list.add(null);
		list.add(10);
		list.add(13);
		list.add(17);
		list.add(19);
		list.add(15);
		
		System.out.println(list);
		System.out.println(list.indexOf(50));
		list.remove(3);
		System.out.println(list);
		
		int a=list.size();
		System.out.println(a);
		
		System.out.println(list.isEmpty());
		System.out.println(list.contains(40));
		
		for(int i=0;i<a;i++) {
			int b=list.get(i);
			
			if(b%2==0) {
				System.out.println("even ="+b);
			}
			else {
				System.out.println("odd ="+b);
			}
		}
	}
}
