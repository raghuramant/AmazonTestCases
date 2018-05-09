package MainScriptAmazon;

import org.tasks.Amazon.Pages.AmazonPageAutomation;
import org.tasks.Amazon.Pages.Utilities;

public class MainscriptMenuAutomation {

	public static void main(String[] args) throws InterruptedException {
		Utilities.browserOpen();
		Utilities.launchURL("https://www.amazon.in/");
//		AmazonPageAutomation.navToSubMenu("Amazon Prime Music", "Open web player");
		//AmazonPageAutomation.navToSubMenuComplex("Amazon Prime Music", "Amazon Prime Music");
		AmazonPageAutomation.navToSubMenuComplex("Kindle E-Readers & eBooks", "Free Kindle Reading Apps");
		//Echo & Alexa
		
		Utilities.browserClose();
		
	}

}
