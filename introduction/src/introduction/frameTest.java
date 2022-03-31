package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/"); //url for frame testing
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"))); //control comes inside the frame
		//driver.findElement(By.id("draggable")).click();
		
		Actions a = new Actions(driver); // to perform actions like drag and drop
		WebElement source = driver.findElement(By.id("draggable")); //creating webelemnet for source i,e..drag file 
		WebElement target = driver.findElement(By.id("droppable")); //creating webelement for target i,e..drop file location
		
		a.dragAndDrop(source, target).build().perform(); //drag and drop action will be done
		driver.switchTo().defaultContent(); //comes back to original state
		
		
		
	}

}
