package MainScriptAmazon;

import org.tasks.Amazon.Pages.AmazonPageAutomation;

public class MainScript extends AmazonPageAutomation {

	public static void main(String[] args) throws InterruptedException {
		browserOpen();
		launchURL("https://www.amazon.in/");
		switchSearchToLaptop();
		searchBrand("Dell");
		addToCart();
		switchSearchToLaptop();
		searchBrand("HP");
		addToCart();
		Thread.sleep(5000);
		//browserClose();
	}

}
