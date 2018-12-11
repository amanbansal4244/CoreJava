import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class FindXYCoordinatesOfElement {
	
	public static void main (String [] args) throws InterruptedException {
		final String sUrl = "https://icegate.gov.in/iceLogin/loginAction?";                             
	    System.setProperty("webdriver.chrome.driver","D:\\Personal\\Java_Aman\\Workspace\\Jars\\Selenium Jar\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(sUrl);
		WebElement element = driver.findElement(By.xpath("//*[@id='header']")); 
		Point point = element.getLocation();
		int xcord = point.getX();
		System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		int ycord = point.getY();
		System.out.println("Position of the webelement from top side is "+ycord +" pixels");
	} 
}