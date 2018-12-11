package StringBased;
import java.util.Arrays;

public class SortStringArray_Using_Arrays_sort {

	static public String[] sortDates(String dates[]){
		Arrays.sort(dates);
		return dates;
	}

	public static void main(String[] args) {
		String dates[] = {"11/24/2010", "2/2/2008","1/30/2008","11/23/2010"};
		String res [] = sortDates(dates);
		for (String date : res) {
			System.out.println(date);
		}
	}
}
