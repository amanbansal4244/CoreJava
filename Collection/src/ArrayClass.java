import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ArrayClass {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int arr[]=new int[5];
		for(int i=0;i<4;i++){
			System.out.println("enter the integer");
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		System.out.println("display array elements");
		display(arr);
		Arrays.sort(arr);
		System.out.println("sorted array elements");
		display(arr);
		
		System.out.println("which elements u wants to search");
		int ele=Integer.parseInt(br.readLine());
		int index=Arrays.binarySearch(arr, ele);
		if(index<0)
			System.out.println("no element found");
		else
			System.out.println("found elements position is "+(index+1));
		}

	private static void display(int[] arr) {
		for(int i:arr)
		{
			System.out.println(i);
		}
	}
}
