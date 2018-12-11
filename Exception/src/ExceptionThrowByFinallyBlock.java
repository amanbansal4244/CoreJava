
public class ExceptionThrowByFinallyBlock {

	public static void m1() throws Exception {
		try{
			System.out.println("in try");
			throw new Exception();
		}
		catch(Exception e){
			System.out.println("in catch");
			throw new Exception();
		}
		finally {
			System.out.println("in finally");
			try{
			throw new Exception();
			}catch(Exception e){
				System.out.println("FInally exception handaled");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		ExceptionThrowByFinallyBlock.m1();
	}
}
