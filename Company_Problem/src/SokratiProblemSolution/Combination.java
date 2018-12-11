package SokratiProblemSolution;
import java.util.ArrayList;


public class Combination {
	static ArrayList<int[]> combos = new ArrayList<int[]>();
	
	public static ArrayList<int[]> generate(int[][] elements) {
	    int rows = elements.length;
	    int[] elementsIndex = new int[rows];
	    int[] elementsTotals = new int[rows];
	    java.util.Arrays.fill(elementsTotals, elements[0].length);
	    int curIdx = 0;
	    int[] c = new int[rows];//since Every combination should have number of elements equal to number of rows.
	    while(true){
	        while(curIdx >= 0){
	            if(curIdx == rows) {
	                addCombo(c);
	                curIdx--;
	            }
	            if(elementsIndex[curIdx] == elementsTotals[curIdx]){
	                elementsIndex[curIdx] = 0;
	                curIdx--;
	            } else break;
	        }
	        if(curIdx < 0) break;
	        c[curIdx] = elements[rows-curIdx-1][elementsIndex[curIdx]++];
	        curIdx++;
	    }
		return combos;
	}
	private static void addCombo(int[] c){
	    int[] a = new int[c.length];
	    System.arraycopy(c, 0, a, 0, c.length);
	    combos.add(a);
	}
}
