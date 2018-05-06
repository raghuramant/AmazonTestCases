package MainScriptAmazon;

import org.tasks.Amazon.Pages.AmazonPageAutomation;
import org.tasks.Amazon.Pages.Utilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDef {
	@Given("^User is on Amazon page$")
	public void user_is_on_Amazon_page() throws Throwable {
		Utilities.browserOpen();
		Utilities.launchURL("https://www.amazon.in/");
	}
	
	@When("^User searches \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and adds five laptops to the cart individually$")
	public void user_searches_and_adds_five_laptops_to_the_cart_individually(String laptop1, String laptop2, String laptop3, String laptop4, String laptop5) throws Throwable {
		String[] laptop = {laptop1,laptop2,laptop3,laptop4,laptop5};
		for (String currentLaptop : laptop) {		
		AmazonPageAutomation.switchSearchToLaptop();
		AmazonPageAutomation.searchBrand(currentLaptop);
		AmazonPageAutomation.addToCart();
		}
	}
/*
	@When("^User searches \"([^\"]*)\" and adds the first laptop to cart$")
	public void user_searches_and_adds_the_first_laptop_to_cart(String laptop1) throws Throwable {
		AmazonPageAutomation.switchSearchToLaptop();
		AmazonPageAutomation.searchBrand(laptop1);
		AmazonPageAutomation.addToCart();
	}

	@When("^User searches \"([^\"]*)\" and adds the second laptop to cart$")
	public void user_searches_and_adds_the_second_laptop_to_cart(String laptop2) throws Throwable {
		AmazonPageAutomation.switchSearchToLaptop();
		AmazonPageAutomation.searchBrand(laptop2);
		AmazonPageAutomation.addToCart();
	}

	@When("^User searches \"([^\"]*)\" and adds the third laptop to cart$")
	public void user_searches_and_adds_the_third_laptop_to_cart(String laptop3) throws Throwable {
		AmazonPageAutomation.switchSearchToLaptop();
		AmazonPageAutomation.searchBrand(laptop3);
		AmazonPageAutomation.addToCart();
	}

	@When("^User searches \"([^\"]*)\" and adds the fourth laptop to cart$")
	public void user_searches_and_adds_the_fourth_laptop_to_cart(String laptop4) throws Throwable {
		AmazonPageAutomation.switchSearchToLaptop();
		AmazonPageAutomation.searchBrand(laptop4);
		AmazonPageAutomation.addToCart();
	}

	@When("^User searches \"([^\"]*)\" and adds the fifth laptop to cart$")
	public void user_searches_and_adds_the_fifth_laptop_to_cart(String laptop5) throws Throwable {
		AmazonPageAutomation.switchSearchToLaptop();
		AmazonPageAutomation.searchBrand(laptop5);
		AmazonPageAutomation.addToCart();
	}
*/
	@Then("^User verifies whether all the selected laptops were in cart or not$")
	public void user_verifies_whether_all_the_selected_laptops_were_in_cart_or_not() throws Throwable {
	boolean verifyLaptopNames = AmazonPageAutomation.verifyLaptopNames();
	Assert.assertTrue(verifyLaptopNames);
	System.out.println("The cart has been successfully verified");
	}


}
