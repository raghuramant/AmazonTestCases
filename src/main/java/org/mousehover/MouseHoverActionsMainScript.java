package org.mousehover;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.tasks.Amazon.Pages.Utilities;

public class MouseHoverActionsMainScript extends Utilities {

	public static void main(String[] args) {
		Utilities.browserOpen();
		Utilities.launchURL("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement yourOrders_Btn = driver.findElement(By.id("nav-link-yourAccount"));
		Actions act = new Actions(driver);
		act.moveToElement(yourOrders_Btn).build().perform();
		driver.findElement(By.linkText("Start here.")).click();
		
		
		driver.findElement(By.id("ap_customer_name")).sendKeys("arun");
		driver.findElement(By.id("ap_phone_number")).sendKeys("9876543211");
		driver.findElement(By.id("ap_email")).sendKeys("arun@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("mypass!@#123");
		driver.findElement(By.id("continue")).click();
		
		Utilities.browserClose();

	}

}
