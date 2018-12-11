package ClonningInHashMap;

import java.util.*;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.sun.xml.internal.ws.api.databinding.MappingInfo;

interface A{
	int x =45;
}

interface B{
	int x =55;
}
public class test implements A,B {
	 public static void main(String[] args) {
		System.out.println(A.x);
		System.out.println(B.x);
	}
	
}
