
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array2 {
	public static void main(String[] args) throws IOException {
	InputStreamReader obj = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(obj);
	System.out.println("Enter total no");
	String str = br.readLine();
	int n = Integer.parseInt(str);
	int n1 = 0;
	
	int arr[]=new int[n];
	System.out.println(arr.length); // array length
	for(int i=0;i<n;i++)
	{
		System.out.println("ENter MArks");
		String str1 = br.readLine();
		 arr[i]=Integer.parseInt(str1);
		 System.out.println("Marks :"+ arr[i]);
	}
	/*for(int i=0;i<=n;i++)
	{
	System.out.println("Marks :"+ arr[i]);
	}*/
	}
	
}

