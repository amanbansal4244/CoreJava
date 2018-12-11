package IDeaS_Company;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
import java.net.StandardSocketOptions;
import java.io.*;
import java.util.regex.Pattern;
 
/* Name of the class has to be "Main" only if the class is public. */
class MaintainSoftwareInstallationVersion
{
	static FileWriter fileWriter=null;
	static BufferedWriter bufferedWriter=null;

	public static void main (String[] args) throws java.lang.Exception
	{
		FileReader fr = new FileReader("d:/input.txt");
		BufferedReader br = new BufferedReader(fr);
		try {
			fileWriter = new FileWriter("d:/output.txt");
			bufferedWriter = new BufferedWriter(fileWriter);

			MaintainSoftwareInstallationVersion obj = new MaintainSoftwareInstallationVersion();
			obj.reader(br);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			br.close();
			bufferedWriter.close();
		}
	}

	private void reader(BufferedReader br) throws IOException{
		HashMap<String,String> oldestVersionMap = new HashMap<String,String>();
		HashMap<String,HashMap<String,String>> serverInfoMap = new HashMap<String,HashMap<String,String>>();
		try{
			String strFileContent = null;

			while ((strFileContent = br.readLine()) != null) {

				String[] arrInputFileRows = strFileContent.split("\n");
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
			//System.out.println("Server Info: " + serverInfo + "\n\nOldest Version: "+oldestVersion);

			Set s = serverInfoMap.entrySet();
			Iterator itr = s.iterator();
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
							//System.out.println(entryForOuterMap.getKey());
							String res = entryForOuterMap.getKey().toString();
							writer(res);
						}
					}
				}
			}
		}catch (IOException x) {
		}
	}

	public void writer(String res) throws IOException{
		try {
		
            bufferedWriter.write(res);
            bufferedWriter.newLine();
		}
		 catch(IOException ex) {
	            
	            ex.printStackTrace();
	        }
		
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
}