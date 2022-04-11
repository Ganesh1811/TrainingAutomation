
package TaskAutomation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Selenium{
WebDriver driver = null;
@Given("user is on GitHub home page")
public void user_is_on_git_hub_home_page() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ganesh.bandaru\\Downloads\\chromedriver.exe");

//webDriver -- interface
//EdgeDriver -- class
//driver object has to access all the methods in chromeDriver that is defined in webDriver
WebDriver driver = new EdgeDriver();
//wait for 5 sec to
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//open github
driver.get("https://github.com/");
driver.close();
} @When("user is search REACT in search bar")
public void user_is_search_react_in_search_bar() {
WebDriver driver = new EdgeDriver();
driver.get("https://github.com/");
WebElement p=driver.findElement(By.name("q"));
p.sendKeys("react");
//click on submit
p.submit();
driver.close();
} @Then("click on advanced search")
public void click_on_advanced_search() throws InterruptedException {
WebDriver driver = new EdgeDriver();
driver.get("https://github.com/");
WebElement p=driver.findElement(By.name("q"));
p.sendKeys("react");
//click on submit
p.submit();
Thread.sleep(2000);
driver.findElement(By.linkText("Advanced search")).click();
driver.close();
} @Then("change some options in advanced search")
public void change_some_options_in_advanced_search() {
WebDriver driver = new EdgeDriver();
driver.get("https://github.com/");
WebElement p=driver.findElement(By.name("q"));
p.sendKeys("react");
//click on submit
p.submit();
driver.findElement(By.linkText("Advanced search")).click();
driver.findElement(By.id("search_language")).sendKeys("javascript");
driver.findElement(By.id("search_stars")).sendKeys(">45");
driver.findElement(By.id("search_license")).sendKeys("Boost Software License 1.0");
driver.findElement(By.id("search_followers")).sendKeys(">50");
driver.findElement(By.className("btn")).click();
driver.close();
} @Then("click on mvoloskv")
public void click_on_mvoloskv() {
WebDriver driver = new EdgeDriver();
driver.get("https://github.com/");
WebElement p=driver.findElement(By.name("q"));
p.sendKeys("react");
//click on submit
p.submit();
driver.findElement(By.linkText("Advanced search")).click();
driver.findElement(By.id("search_language")).sendKeys("javascript");
driver.findElement(By.id("search_stars")).sendKeys(">45");
driver.findElement(By.id("search_license")).sendKeys("Boost Software License 1.0");
driver.findElement(By.id("search_followers")).sendKeys(">50");
driver.findElement(By.className("btn")).click();
driver.findElement(By.linkText("mvoloskov/decider")).click();
driver.close();
} @And("print first {int} characters from readme")
public void print_first_characters_from_readme(Integer int1) {
WebDriver driver = new EdgeDriver();
driver.get("https://github.com/");
WebElement p=driver.findElement(By.name("q"));
p.sendKeys("react");
//click on submit
p.submit();
driver.findElement(By.linkText("Advanced search")).click();
driver.findElement(By.id("search_language")).sendKeys("javascript");
driver.findElement(By.id("search_stars")).sendKeys(">45");
driver.findElement(By.id("search_license")).sendKeys("Boost Software License 1.0");
driver.findElement(By.id("search_followers")).sendKeys(">50");
driver.findElement(By.className("btn")).click();
driver.findElement(By.linkText("mvoloskov/decider")).click();
WebElement readmeDriver = driver.findElement(By.xpath("//div[@data-target='readme-toc.content']"));
String expectedText = readmeDriver.getText();
//Printing the first 300 characters
System.out.println(expectedText.substring(0, 300));
}}

