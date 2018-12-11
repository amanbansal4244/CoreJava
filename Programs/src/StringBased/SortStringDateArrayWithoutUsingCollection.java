package StringBased;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
/*
Write a function to sort an array of dates represented by String. The format of the date is mm/dd/yyy, means date 
should be sorted in order like : month then day then year. 
*/
public class SortStringDateArrayWithoutUsingCollection {

	static public String[] sortDates(String dates[]){

		Arrays.sort(dates, new Comparator<String>() {
			private SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");

			@Override
			public int compare(String o1, String o2) {
				int result = -1;
				try {
					result = sdf.parse(o1).compareTo(sdf.parse(o2));
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
				return result;
			}
		});
		
		return dates;
	}

	public static void main(String[] args) {
		// String dates[] = {"05-11-2014", "23-08-2014","05-02-2013"};
		String dates[] = {"11/24/2010", "2/2/2008","1/30/2008","11/23/2010"};
		String res [] = sortDates(dates);
		for (String date : res) {
			System.out.println(date);
		}
	}
}
