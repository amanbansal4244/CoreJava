package DataStructure;
// swap bas ek bar so log(n) swaping.
public class SelectionSort {
	
static public void selectionSort(int[] arr){
		
		int n = arr.length;
		int i, j=0;
		
		for(i = 0; i < n-1; i++) // for no of times
		{
			int min = i; // we take first element as minimum then search aage-> if aage vala element phele element se small milta h to use min set kr
						//  dete h then swape each other.
			for (j = i + 1; j < n; j++)
			{
				if (arr[j] < arr[min])
				{
					min = j;
				}
			}
			
			if (min != i)// coz phela hi sabse min hua to we dont need to shift
			{
				int temp=arr[i]; // isme bas ek bar shifting hoti h 
				arr[i]=arr[min];
				arr[min]=temp;
			}
		}
			
			for( j=0; j< n ; j++){
				System.out.println(arr[j]);
			}
		}
		
	public static void main(String[] args) {
		int [] arr = {4,6,2,7,3,9,1};
		selectionSort(arr);
	}
}