package introduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click(); //blinking text format
		Set<String> windows = driver.getWindowHandles();//parent id, child id etc.,,,is stored in this handle
        Iterator<String>it = windows.iterator(); 
        String parentId = it.next();
        String childId = it.next();
		driver.switchTo().window(childId); //next tab is selected where element is present parent to child
	    System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
	    driver.findElement(By.cssSelector(".im-para.red")).getText();
	    String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0]; //parsing the text got
	    driver.switchTo().window(parentId); //switch to parentId to enter the text got
	  
	    driver.findElement(By.id("username")).sendKeys(emailId);
		
		

	}

}
