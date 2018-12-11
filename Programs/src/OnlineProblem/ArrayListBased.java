package OnlineProblem;

//Problem-> https://www.hackerrank.com/challenges/java-arraylist

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import java.util.*;

	/**
	 * @author amanba
	 *
	 */
	class ArrayListBased 
	{
		
		static int count=0;
		public static void main(String[] args) {
			
			ArrayList<ArrayList<Integer>> alll = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> al = new ArrayList<Integer>();
			ArrayList<Integer> al1 = new ArrayList<Integer>();
			int r=33;
			al.add(2);
			al.add(3);
			
			al1.add(22);
			al1.add(33);
			
			alll.add(0, al);
			alll.add(1, al1);
			
			Iterator<ArrayList<Integer>> e =alll.iterator();
			while(e.hasNext())
			{
				ArrayList x=e.next();
				if(x.contains(r)){
					System.out.println("element fount in array" +" " + count);
					System.out.println("index no " + " " +x.indexOf(r));
				}
				else{
				}
				count++;
			}
			
		
		}
		
	}