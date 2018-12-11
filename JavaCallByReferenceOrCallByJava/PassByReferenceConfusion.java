package Testing;
public class PassByReferenceConfusion {
	private String brand;
    
    public PassByReferenceConfusion(String brand){
        this.brand = brand;
    }
    public static void main(String args[]) {
    	PassByReferenceConfusion car = new PassByReferenceConfusion("BMW");
       System.out.println("Brand of Car Inside main() before: "+ car.brand);
       printBrand(car);
       System.out.println("Brand of Car Inside main()after: "+ car.brand);
    }
  
    public static void printBrand(PassByReferenceConfusion car){
        car.brand = "Maruti";
        System.out.println("Brand of Car Inside printBrand(): "+car.brand);
    }
  
   
}
