package VuClip;
/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */
public class Main {
	public static Map<String,Integer> processData(ArrayList<String> array) {
		/* 
		 * Modify this method to process `array` as indicated
		 * in the question. At the end, return the appropriate value.
		 *
		 * Please create appropriate classes, and use appropriate
		 * data structures as necessary.
		 *
		 * Do not print anything in this method.
		 *
		 * Submit this entire program (not just this method)
		 * as your answer
		 */

		ConcurrentHashMap<String,String> lowestSalaryMap = new ConcurrentHashMap<String,String>();
		HashMap<String,HashMap<String,String>> companyInfoMap = new HashMap<String,HashMap<String,String>>();
		Map<String,Integer> retVal = new HashMap<String,Integer>();
		for(int i=0; i<array.size();i++){

			String arrInputFileRows = array.get(i);
			String[] arrRowData = arrInputFileRows.split(",");
			String strKey = arrRowData[0];
			String companyName = arrRowData[2];
			if (companyInfoMap.containsKey(companyName)){
				companyInfoMap.get(companyName).put(strKey,arrRowData[1]);
			}
			else{
				HashMap<String,String> comInfo = new HashMap<String,String>();
				comInfo.put(strKey,arrRowData[1]);
				companyInfoMap.put(companyName,comInfo);
			}
			//salary comparison to get lowest salary. 
			if (lowestSalaryMap.containsKey(strKey)){
				if(isLowestSalary(arrRowData[1],lowestSalaryMap.get(strKey))){
					lowestSalaryMap.put(strKey,arrRowData[1]);
				}
			}
			else if (!lowestSalaryMap.containsKey(strKey)){
				lowestSalaryMap.put(strKey,arrRowData[1].trim());
			}
		} 

		Set s = companyInfoMap.entrySet();
		Iterator itr = s.iterator();
		Map<String,Integer> temp = new HashMap<String,Integer>();
		while(itr.hasNext()){
			Map.Entry entryForOuterMap = (Map.Entry) itr.next();
			/**** Creating iterator for inner Hashmap of 'companyInfoMap' Hashmap ****/
			HashMap<String, String> innerMap= (HashMap<String, String>) entryForOuterMap.getValue();
			boolean flag = true;
			Iterator<Entry<String, String>> innerIterator = ((HashMap<String, String>) entryForOuterMap.getValue()).entrySet().iterator();
			if(!temp.isEmpty()){
				retVal.putAll(temp);
				temp.clear();
			}
			while(innerIterator.hasNext()){
				Entry<String, String> entryForInnerMap = innerIterator.next();
				/**** Creating iterator for 'lowestSalaryMap' Hashmap ****/
				Iterator oldestVersionIterator  = lowestSalaryMap.entrySet().iterator();
				long min =0;
				while(oldestVersionIterator.hasNext()){
					Map.Entry oldestVersionIteratorMap = (Map.Entry) oldestVersionIterator.next();
					/**** Comparing and getting server name which has lowest salary****/
					long value = Long.parseLong((String) oldestVersionIteratorMap.getValue());
					if(flag){
						min = value;
						flag = false;
					}

					if(value <= min){
						min = value;
						if(!temp.isEmpty())
							temp.clear();

						temp.put(entryForOuterMap.getKey().toString(), (int) Long.parseLong((String)oldestVersionIteratorMap.getValue()));
					}
					lowestSalaryMap.remove(entryForInnerMap.getKey());
				}
			}
		}
		
		// Putting last value which is not put into retVal HashMap.
		if(!temp.isEmpty())
			retVal.putAll(temp);

		return retVal;
	}

	
	private static Boolean isLowestSalary(String v1, String v2) {
		String s1 = normalisedVersion(v1);
		String s2 = normalisedVersion(v2);
		int cmp = s1.compareTo(s2);
		Boolean result = cmp < 0 ? true : false;
		return result;
	}
	
	public static String normalisedVersion(String version) {
		String[] split = Pattern.compile(".", Pattern.LITERAL).split(version);
		StringBuilder sb = new StringBuilder();
		for (String s : split) {
			sb.append(String.format("%3s", s));
		}
		return sb.toString();
	}
	
	public static void main (String[] args) {
		ArrayList<String> inputData = new ArrayList<String>();
		String line;
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader("d:/input.txt")));
			while(in.hasNextLine())
				inputData.add(in.nextLine());
			Map<String,Integer> retVal = processData(inputData);
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("d:/output.txt")));
			for(Map.Entry<String,Integer> e: retVal.entrySet())
				output.println(e.getKey() + ": " + e.getValue());
			output.close();
		} catch (IOException e) {
			System.out.println("IO error in input.txt or output.txt");
		}
	}
}
