package ArrayBased;
//I have an algorithm that works in O(n3) time, but I have no hard proof it is optimal.
// It seems to work for every test input I give it (including some with negative numbers), so I figured it was worth sharing.
//
//You start by splitting the input into two equally sized arrays (call them one[] and two[]?).
//Start with one[0], and see which element in two[] would give you the best result if swapped.
//Whichever one gives the best result, swap. If none give a better result, don't swap it. 
//Then move on to the next element in one[] and do it again.
//
//That part is O(2) by itself. The problem is, it might not get the best results the first time through. 
//If you just keep doing it until you don't make any more swaps, you end up with an ugly 
//bubble-type construction which makes it O(n3) total.

import java.util.Arrays;


public class SplittingAnArrayIntoTwoSubarraysWithMaximumSum {

	//static int[] input = {1,2,3,4,5,-6,7,8,9,10,200,-1000,100,250,-720,1080,200,300,400,500,50,74};

	static int[] input = { 100 ,340,210 ,100 ,75,33};
	public static void main(String[] args) {    
	    int[] two = new int[input.length/2];
	    int[] one = new int[input.length - two.length];

	    int totalSum = 0;
	    for(int i=0;i<input.length;i++){
	        totalSum += input[i];
	        if(i<one.length)
	            one[i] = input[i];
	        else
	            two[i-one.length] = input[i];
	    }

	    float goal = totalSum / 2f; 

	    boolean swapped;
	    do{
	        swapped = false;
	        for(int j=0;j<one.length;j++){
	            int curSum = sum(one);
	            float curBestDiff = Math.abs(goal - curSum);
	            int curBestIndex = -1;

	            for(int i=0;i<two.length;i++){
	                int testSum = curSum - one[j] + two[i];
	                float diff = Math.abs(goal - testSum);
	                if(diff > curBestDiff){
	                    curBestDiff = diff;
	                    curBestIndex = i;
	                }
	            }

	            if(curBestIndex >= 0){  
	                swapped = true;
	                System.out.println("swapping " + one[j] + " and " + two[curBestIndex]);
	                int tmp = one[j];
	                one[j] = two[curBestIndex];
	                two[curBestIndex] = tmp;
	            }
	        }
	    } while(swapped);

	    System.out.println(Arrays.toString(one));
	    System.out.println(Arrays.toString(two));
	    System.out.println("diff = " + Math.abs(sum(one) - sum(two)));
	}

	static int sum(int[] list){
	    int sum = 0;
	    for(int i=0;i<list.length;i++)
	        sum += list[i];
	    return sum;
	}	
}
