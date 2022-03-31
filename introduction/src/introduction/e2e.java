package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click(); //one way trip button
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();//from box departure
		driver.findElement(By.xpath("//a[@value='DEL']")).click(); //xpath for from Delhi
		Thread.sleep(2000);
		
		//xpath for chennai, which is arrival location from delhi
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); // xpath for parent child relation
        
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();//calendar depart
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) //to get the radio button on, calendar(return) calendar
		{
			System.out.println("its enabled");
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); //checkboxes in url

		driver.findElement(By.id("divpaxinfo")).click();//to open dropdown
		Thread.sleep(2000L);

		int i=1;
		while(i<5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
        driver.findElement(By.id("btnclosepaxoption")).click(); //button to close
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult"); //dropdown of passenger selection
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();//search button for flights
				




		
		

	}

}
