package introduction;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		System.out.println(driver.findElements(By.tagName("a")).size()); //will get all links which is having tagname 'a'
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); //limiting webdriver scope
		
    	System.out.println(footerdriver.findElements(By.tagName("a")).size()); //footer section links will be displayed
    	
    	WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //1st column of footer section
        System.out.println(columndriver.findElements(By.tagName("a")).size());
        
        //click on each links in column and check each page is opening 
        //Dynamically can be done to run the abive using html tag 'a' of count and loop
        
        for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
        {
        	
        	String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER); //all links will open in new tabs will open with help of 'key' control
        	
        	columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
        	Thread.sleep(5000L); //waits for 5Sec to load 4 new tabs
        	
        	Set<String> abc = driver.getWindowHandles();
        	Iterator<String> it = abc.iterator();
        	
        	while(it.hasNext()) 
        	{
        		driver.switchTo().window(it.next());
        		System.out.println(driver.getTitle());
        	
        		
        	}
        	
        	
        	
        }
    	
    	
    	
		
		

	}

}
