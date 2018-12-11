package CustomArrayList_ToAllowDuplicateOrNot;

public class Main {

	public static void main(String[] args) {
		CustomArrayList arrayList = new CustomArrayList(true);
	
		arrayList.add("Aman");
		arrayList.add("Aman");
		arrayList.add(10);
		arrayList.add(10.50);
		
		 for(int i=0;i<arrayList.size();i++){
	            System.out.print(arrayList.get(i)+" ");
	        }
	}
}
