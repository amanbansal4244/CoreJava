
class StringBuffer1 {

public static void main(String[] args) {
	String st = new String("IS");
	StringBuffer sb=new StringBuffer("amab");
	StringBuffer sb1=new StringBuffer(" bansal ");
	
	StringBuffer temp =sb;
	sb=sb1;
	sb1=temp;
	System.out.println(sb);
	System.out.println(sb1);
	
	
	/*sb.append(2);
	sb.append('c');
	System.out.println(sb);
	sb.insert(2, 'b');
	System.out.println(sb);
	sb.delete(2, 5);
	System.out.println(sb);
	sb.deleteCharAt(3);
	System.out.println(sb);
	sb.reverse();
	System.out.println(sb);
	
	//sb.toString();
	int q=sb1.length();
	System.out.println(q);
	int x=sb.indexOf(st);
	System.out.println(x);

	boolean s=sb.equals(sb1);
	System.out.println(s);*/
}
}

