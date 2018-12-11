package Stream_udemy;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

import LambdaBasicExcercisePackage.Person;

public class _14Stream_summaryStatistics {


	public static void main(String[] args) {
		java.util.List<Person1> people = Arrays.asList(
				new Person1("aman", "bansal", 26),
				new Person1("aman1", "bansal1", 68), 
				new Person1("aman2", "Walia", 23), 
				new Person1("aman3", "Garg", 28)

				);

		//Using summaryStatistics, we can get all operation like average, count, min, max, count
		DoubleSummaryStatistics doubleSummaryStatistics = people.stream() // people is source
				.mapToDouble(Person1:: getAge)
				.summaryStatistics();

		System.out.println("doubleSummaryStatistics: " + doubleSummaryStatistics);
		System.out.println("doubleSummaryStatistics average:" + doubleSummaryStatistics.getAverage());
		System.out.println("doubleSummaryStatistics count:" + doubleSummaryStatistics.getCount());
		System.out.println("doubleSummaryStatistics max: " + doubleSummaryStatistics.getMax());
		System.out.println("doubleSummaryStatistics min:" + doubleSummaryStatistics.getMin());
		System.out.println("doubleSummaryStatistics sum:" + doubleSummaryStatistics.getSum());


	}

}
