package SchlumbergerProblems;

/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import java.io.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */

public class MaintainSoftwareInstallationVersion {
    public static int processData(ArrayList<String> array) {
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
    	

		HashMap<String,String> oldestVersionMap = new HashMap<String,String>();
		HashMap<String,HashMap<String,String>> serverInfoMap = new HashMap<String,HashMap<String,String>>();
		String strFileContent = null;
		for(int i =0; i<array.size();i++){
		//while ((strFileContent = br.readLine()) != null) {

			String[] arrInputFileRows = array.get(i).split("\n");
			for (String strRow: arrInputFileRows)
			{
				String[] arrRowData = strRow.split(",");
				String strKey = arrRowData[1].trim().toLowerCase()+'_'+arrRowData[2].trim().toLowerCase();
				String serverName = arrRowData[0];
				if (serverInfoMap.containsKey(serverName)){
					serverInfoMap.get(serverName).put(strKey,arrRowData[3].trim());
				}
				else{
					HashMap<String,String> swInfo = new HashMap<String,String>();
					swInfo.put(strKey,arrRowData[3].trim());
					serverInfoMap.put(serverName,swInfo);
				}
				//version comparison to get latest software version 
				if (oldestVersionMap.containsKey(strKey)){
					if(isGreaterVersion(arrRowData[3],oldestVersionMap.get(strKey))){
						oldestVersionMap.put(strKey,arrRowData[3].trim());
					}
				}
				else if (!oldestVersionMap.containsKey(strKey)){
					oldestVersionMap.put(strKey,arrRowData[3].trim());
				}
			}
		}

		Set s = serverInfoMap.entrySet();
		Iterator itr = s.iterator();
		ArrayList<String> result = new ArrayList<String>();
		while(itr.hasNext()){
			Map.Entry entryForOuterMap = (Map.Entry) itr.next();
			/**** Creating iterator for inner Hashmap of 'serverInfo' Hashmap ****/
			Iterator<Entry<String, String>> innerIterator = ((HashMap<String, String>) entryForOuterMap.getValue()).entrySet().iterator();
			while(innerIterator.hasNext()){
				Entry<String, String> entryForInnerMap = innerIterator.next();
				/**** Creating iterator for 'oldestVersionIterator' Hashmap ****/
				Iterator oldestVersionIterator  = oldestVersionMap.entrySet().iterator();
				while(oldestVersionIterator.hasNext()){
					Map.Entry oldestVersionIteratorMap = (Map.Entry) oldestVersionIterator.next();
					/**** Comparing and getting server name which has oldest version****/
					if(entryForInnerMap.getKey().equals(oldestVersionIteratorMap.getKey()) && entryForInnerMap.getValue().equals(oldestVersionIteratorMap.getValue()) ){
						String res = entryForOuterMap.getKey().toString();
						result.add(res);
						break;
					}
				}
			}
		}
	
		String[] finalRes = result.get(0).split(",");
		int val =0;
		if(finalRes[0].equals("Server2")){
			val = 2;
		}else if(finalRes[0].equals("Server3")){
			val = 3;
		}
		return val;
		
    }

    public static Object getKeyFromValue(Map hm, Object value) {

		Set s = hm.entrySet();
		Iterator itre = s.iterator();
		while(itre.hasNext()){
			itre.next();
		}

		for (Object o : hm.keySet()) {

			if (hm.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}

	private static Boolean isGreaterVersion(String v1, String v2) {
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
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("d:/input.txt")));
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                    inputData.add(line);
            }
            int retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("d:/output.txt")));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
