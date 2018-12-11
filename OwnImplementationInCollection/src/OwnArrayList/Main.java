package OwnArrayList;



public class Main {
	
	public static void main(String[] args) {
		
		OwnArrayList ownArrayList = new OwnArrayList();
		
		ownArrayList.add("Aman");
		ownArrayList.add("Bansal");
		ownArrayList.add(10);
		ownArrayList.add(10.8);
		
		 for(int i=0;i<ownArrayList.size();i++){
	            System.out.print(ownArrayList.get(i)+" ");
	        }
	}
}
