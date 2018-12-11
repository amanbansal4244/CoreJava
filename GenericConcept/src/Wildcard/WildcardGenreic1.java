package Wildcard;

import java.util.ArrayList;

public class WildcardGenreic1 {

	public static <X> void m1(ArrayList<? super X> l){
		
		l.add((X) new Test());
		l.add(null);

	}
}
