package org.tasks.Amazon.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.ContentHandler;

public class AmazonPageAutomation extends Utilities {

	// public

	
	static Actions act = new Actions(driver);
	
	public static void switchSearchToLaptop() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement categoryElement = driver.findElement(By.id("nav-link-shopall"));
		WebElement computerElement = driver
				.findElement(By.xpath("//span[@class = 'nav-text' and contains( text(), 'Mobiles, Computers')]"));
		WebElement laptopElement = driver
				.findElement(By.xpath("//span[@class = 'nav-text' and contains( text(), 'Laptops')]"));
		Action mouseOver = act.moveToElement(categoryElement).build();
		mouseOver.perform();
		WebElement visibleComputerElement = wait.until(ExpectedConditions.visibilityOf(computerElement));

		act.moveToElement(visibleComputerElement).build().perform();
		WebElement visibleLaptopElement = wait.until(ExpectedConditions.visibilityOf(laptopElement));
		act.moveToElement(visibleLaptopElement).build().perform();
		Action click = act.click().build();
		click.perform();

	}

	public static void searchBrand(String laptopMake) throws InterruptedException {
		Actions act = new Actions(driver);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(laptopMake); 
		Thread.sleep(1000);
		act.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
		//driver.findElement(By.id("//*[@type= 'submit' and @class = 'nav-input']")).click();

	}
	
	public static void addToCart(){
		driver.findElement(By.xpath("//*[@id='result_3']/div/div[3]/div[1]")).click();
		String parentWindowID = driver.getWindowHandle();
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String x : allWindowsID) {
			if(!parentWindowID.equals(x))
				driver.switchTo().window(x);
				
			
			
		}
		driver.findElement(By.id("add-to-cart-button")).click();
		try{
			Thread.sleep(1000);
			driver.findElement(By.id("siNoCoverage-announce")).click();
		}catch(Exception e){
			System.out.println("Exception has been successfully encountered");
		}
		
	}
	
	public static boolean verifyLaptopNames() throws InterruptedException{
		Boolean a = true;
		driver.findElement(By.id("nav-cart")).click();
		Thread.sleep(2000);
		List<WebElement> cartElements = driver.findElements(By.xpath("//span[@class = 'a-size-medium sc-product-title a-text-bold']"));
		List<String> contentString = new ArrayList<String>();
		for (WebElement element : cartElements) {
			contentString.add(element.getText());
		}
		
		for (String string : contentString) {
			System.out.println(string);
			if(string.contains("Lenovo")||string.contains("Asus")||string.contains("HP")||string.contains("Dell")||string.contains("ACER")){
				a=true&&a;
			}
			else{
				a=false;
			}
		}
		return a;
		
	}
	
	/*public static void navToSubMenu(String mainMenu, String subMenu) throws InterruptedException{
		
		String mainMenuRef = "//span[text()='$']";
		String mainMenuLocator = mainMenuRef.replace("$", mainMenu);
		WebElement mainMenuElement = driver.findElement(By.xpath(mainMenuLocator)); 
		
		
		WebElement categoryElement = driver.findElement(By.id("nav-link-shopall"));
		act.moveToElement(categoryElement).build().perform();
		Thread.sleep(500);
		act.moveToElement(mainMenuElement).build().perform();
		
		Thread.sleep(3000);
		
		String subMenuRef = "//a/span[text()='$']";
		String subMenuLocator = subMenuRef.replace("$", subMenu);
		System.out.println(subMenuLocator);
		WebElement subMenuElement = driver.findElement(By.xpath(subMenuLocator));
		
		act.moveToElement(subMenuElement).click().build().perform();
		Thread.sleep(3000);
		
	}*/
	
public static void navToSubMenuComplex(String mainMenu, String subMenu) throws InterruptedException{
		
		String mainMenuRef = "//span[text()='$']";
		String mainMenuLocator = mainMenuRef.replace("$", mainMenu);
		WebElement mainMenuElement = driver.findElement(By.xpath(mainMenuLocator)); 
		WebElement reqdElement = null;
		
		WebElement categoryElement = driver.findElement(By.id("nav-link-shopall"));
		act.moveToElement(categoryElement).build().perform();
		Thread.sleep(500);
		act.moveToElement(mainMenuElement).build().perform();
		
		Thread.sleep(3000);
		
		String subMenuRef = "//a/span[text()='$']";
		String subMenuLocator = subMenuRef.replace("$", subMenu);
		System.out.println(subMenuLocator);
		List<WebElement> subMenuElements = driver.findElements(By.xpath(subMenuLocator));
		for (WebElement ele : subMenuElements) {
			boolean dispStatus = ele.isDisplayed();
			if(dispStatus){
				reqdElement = ele;
				break;
			}
			
		}
		
		act.moveToElement(reqdElement).click().build().perform();
		Thread.sleep(3000);
		
		
		
		
	}

}
