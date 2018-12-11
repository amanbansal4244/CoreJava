package ComparisonBoundedTypeParameterAndWildcard;

import java.util.List;

public class ComparisonBoundedTypeParameterAndWildcard {

	private static <T> void processList(List<T> someList)
	{


		T t = someList.get(0);
		if ( t.getClass() == Integer.class )
		{
			Integer myNum = new Integer(4);
			someList.add((T) myNum);
		}

	}

	// Upper bound wildcard
	private static void processList2(List<? extends Number> someList)
	{
		Object o = someList.get(0);
		if ( o instanceof Integer )
		{
			Integer myNum = new Integer(4);
			//someList.add(myNum); // Compile time error !!
		}
	}
}
