package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) throws InterruptedException {
		String text = "Ganesh";
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text); //alert text name
		
		driver.findElement(By.id("alertbtn")).click(); //to click on alert after entering text in name box
		Thread.sleep(2000);
		System.out.println(driver.switchTo().alert().getText()); //to get text from alert block
		driver.switchTo().alert().accept(); //context will switched from browser to alert explicitly and positive mode accept(OK)
		
		driver.findElement(By.id("confirmbtn")).click(); //confirm button 
		System.out.println(driver.switchTo().alert().getText()); //to get text from alert block

		driver.switchTo().alert().dismiss(); //negative mode of confirm(cancel)

	}

}
