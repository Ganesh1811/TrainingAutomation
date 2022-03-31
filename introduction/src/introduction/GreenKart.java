package introduction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //waits for 5seconds to reload the page implicit wait
		WebDriverWait w = new WebDriverWait(driver,5); 		//explicit wait is applied globally


		
		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot","Carrot"};//array is created to store all elements
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/"); //greenkart website for practise of adding items
		Thread.sleep(3000);
		addItems(driver,itemsNeeded); //method created to clear understanding
		driver.findElement(By.cssSelector("img[alt='Cart']")).click(); //Add to bag option selected 
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();//after adding to bag proced to checkout option will enable
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); //explicit wait
		
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");//promocode is entered to discounts but error will come becoz it shiould wait for sometime
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}
	public static void addItems(WebDriver driver,String[] itemsNeeded)
	{
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); //list of all 30 elements will be found
		
		for(int i=0;i<products.size();i++) //to get required element by comparing
		{
			String[] name = products.get(i).getText().split("-"); //loop will run for 30 products and store in object and split vegetable name after '-'
			String formattedName = name[0].trim();
			//Ex. Cucumber - 1kg = Cucumber , - , 1kg, so we need only cucumber
			//format it to get actual vegetable name becoz it previously it gets cucumber-1kg  but we need to compare only with vegetable name
			
			//convert array into array list for easy search
			//check name weather you extracted is presented in arrayList or not
			
			List itemsNeededList = Arrays.asList(itemsNeeded);
		    
			int j=0; // becoz to check only 3times out of 30 elements
			if(itemsNeededList.contains(formattedName))
			{
				j++; // Loop should run upto 3times as satisfied by for loop enters into if to get checked with 3 elements
				//click add to cart now as condition satisfied
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); //static xpath which is never change 
				
			
				
				if(j==itemsNeeded.length)// arraylist length times loop should run
					break;
				
			}
		}
//so finally run in debug mode to clearly see the result, rather than run as mode which takes sometime to load the products but selenium works very fast


	}

}
