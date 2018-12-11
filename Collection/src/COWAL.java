import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWAL {

	public static void main(String[] args) {
		CopyOnWriteArrayList cw = new CopyOnWriteArrayList<>();
		//List cw = new ArrayList();
		cw.add(3);
		cw.add(33);
		cw.add(32);
		
		Iterator itr = cw.listIterator();
		while(itr.hasNext()){
			cw.remove(0);
			System.out.println("a:"+itr.next());
			//itr.remove();
			
		}
		
		Iterator itr1 = cw.listIterator();
		while(itr1.hasNext()){
			System.out.println("b:"+itr1.next());
			
		}
		
		while(itr.hasNext()){
			System.out.println("c:"+itr.next());
		}
	}
}
