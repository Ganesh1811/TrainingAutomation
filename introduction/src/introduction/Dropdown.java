package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//departure of flight
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//from box departure
		driver.findElement(By.xpath("//a[@value='BLR']")).click(); //xpath for from Bengaluru
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //xpath for destination chennai
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); // xpath for parent vhild relation
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		
		
		
	}

}
