package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GaneshAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		driver.manage().window().maximize();//to maxmimize the window
		
		driver.findElement(By.xpath("//input[@placeholder='Search GitHub']")).sendKeys("react");//github search
		driver.findElement(By.id("jump-to-suggestion-search-global")).click(); //enter to be clicked
		
		driver.findElement(By.linkText("Advanced search")).click(); //hyperlinks can be activated by linktext
		//static dropdowns for language
        WebElement Languages = driver.findElement(By.id("search_language"));
        Select desiredLanguage = new Select(Languages);
        desiredLanguage.selectByValue("JavaScript"); //language selected
        
        driver.findElement(By.id("search_stars")).sendKeys(">45");
        driver.findElement(By.id("search_followers")).sendKeys(">50");
        
        //static dropdown for license
        
        WebElement licenses = driver.findElement(By.id("search_license"));
		Select desiredLicense = new Select(licenses);
		desiredLicense.selectByVisibleText("Boost Software License 1.0");

        driver.findElement(By.xpath("//button[@type='submit']")).click(); //search
        
       String actualText = driver.findElement(By.xpath("//div[@class='d-flex flex-column flex-md-row flex-justify-between border-bottom pb-3 position-relative']")).getText();
       
       Assert.assertEquals(actualText, "1 repository result");
       
     String actualRepository = driver.findElement(By.cssSelector("a[class='v-align-middle']")).getText();
     Assert.assertEquals(actualRepository, "mvoloskov/decider");
     driver.findElement(By.cssSelector("a[class='v-align-middle']")).click();
     
     WebElement readMe = driver.findElement(By.xpath("//div[@data-target='readme-toc.content']"));
     String expectedText = readMe.getText();
     System.out.println(expectedText.substring(0, 300));
     
   

	}

}
