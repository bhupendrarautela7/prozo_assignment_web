package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import common.LaunchBrowser;

public class Login extends LaunchBrowser {
	

	@Test(priority = 0)
	public void open_login_page() throws Exception {

		try {
			System.out.println("==================================");
			openURL(propConfig.getProperty("prozo_home_page_url"));
			System.out.println("=====================================");
			System.out.println("Successfully opened login page.");

		} catch (Exception e) {
			addErrorlogs(e, "Error on opening the login page");
		}

	}
	
	
	@Test(priority = 1)
	public void verify_presence_of_domain_name_input_field() throws Exception {

		try {

			
			verifyElement(By.name(propObjctRepo.getProperty("domain_textbox_name")));
			System.out.println("Verified the prasence of domain name textbox.");

					

		} catch (Exception e) {
			addErrorlogs(e, "Error while verifying the prasence of domain name textbox.");
		}

	}
	

	@Test(priority = 2)
	public void enter_domain_name() throws Exception {

		try {

			
			
			click(By.name(propObjctRepo.getProperty("domain_textbox_name")));
			clear(By.name(propObjctRepo.getProperty("domain_textbox_name")));
			type(By.name(propObjctRepo.getProperty("domain_textbox_name")), propConfig.getProperty("domain_name"));
			System.out.println("Entered domain name value in domain name text box.");


		} catch (Exception e) {
			addErrorlogs(e, "Error on entering the the domain name.");
		}

	}
	
	

	@Test(priority = 3)
	public void verify_presence_of_domain_submit_button() throws Exception {

		try {

			
			
			verifyElement(By.xpath(propObjctRepo.getProperty("domian_submit_button_xpath")));
			System.out.println("Verified the prasence of domain submit button.");

					

		} catch (Exception e) {
			addErrorlogs(e, "Error while verifying the prasence of domain submit button.");
		}

	}
	
	@Test(priority = 4)
	public void submit_domain_name() throws Exception {

		try {

			
			
			click(By.xpath(propObjctRepo.getProperty("domian_submit_button_xpath")));
			System.out.println("Clicked on the domain name button.");

					

		} catch (Exception e) {
			addErrorlogs(e, "Error on clicking the the domain name button.");
		}

	}
	
	
	
	@Test(priority = 5)
	public void verify_presence_of_email_textbox() throws Exception {

		try {

			
			
			verifyElement(By.name(propObjctRepo.getProperty("email_textbox_name")));
			System.out.println("Verified the prasence of loginid text box.");

					

		} catch (Exception e) {
			addErrorlogs(e, "Error while verifying the prasence of loginID textbox.");
		}

	}
	
	
	@Test(priority = 6)
	public void verify_presence_of_password_textbox() throws Exception {

		try {

			
			verifyElement(By.name(propObjctRepo.getProperty("password_textbox_name")));
			System.out.println("Verified the prasence of password textbox.");

					

		} catch (Exception e) {
			addErrorlogs(e, "Error while verifying the prasence of password textbox.");
		}

	}
	
	
	
	
	@Test(priority = 7)
	public void verify_presence_of_login_details_submit_button() throws Exception {

		try {

			
			
			verifyElement(By.xpath(propObjctRepo.getProperty("login_submit_button_xpath")));
			System.out.println("Verified the prasence of login details submit button.");

					

		} catch (Exception e) {
			addErrorlogs(e, "Error while verifying the prasence of login submit button.");
		}

	}
	
	
	
	@Test(priority = 8)
	public void enter_and_submit_invalid_login_details() throws Exception {

		try {

			
			click(By.name(propObjctRepo.getProperty("email_textbox_name")));
			clear(By.name(propObjctRepo.getProperty("email_textbox_name")));
			type(By.name(propObjctRepo.getProperty("email_textbox_name")), propConfig.getProperty("invalid_user_id"));
			System.out.println("Entered invalid userid");

			
			click(By.name(propObjctRepo.getProperty("password_textbox_name")));
			clear(By.name(propObjctRepo.getProperty("password_textbox_name")));
			type(By.name(propObjctRepo.getProperty("password_textbox_name")), propConfig.getProperty("invalid_password"));
			System.out.println("Entered invalid password");

			
			click(By.xpath(propObjctRepo.getProperty("login_submit_button_xpath")));
			

			System.out.println("Invalid login password details submitted");

			
			



		} catch (Exception e) {
			
			addErrorlogs(e, "Error on submittting the invalid userid password details.");
		}

	}
	
	
	
	
	@Test(priority = 9)
	public void verify_invalid_login_validation() throws Exception {

		try {

			Thread.sleep(2000);
			verifyElement(By.xpath(propObjctRepo.getProperty("login_validation_snackbar")));

			System.out.println("Verified Negative Case- Shown validation for the invalid user login");
			
			


		} catch (Exception e) {
			
			addErrorlogs(e, "Error on validating the invalid userid password details.");
		}

	}
	
	
	
	
	@Test(priority = 10)
	public void enter_and_submit_valid_login_details() throws Exception {

		try {

			
			click(By.name(propObjctRepo.getProperty("email_textbox_name")));
			clear(By.name(propObjctRepo.getProperty("email_textbox_name")));
			type(By.name(propObjctRepo.getProperty("email_textbox_name")), propConfig.getProperty("user_id"));
			System.out.println("Entered valid userid");

			
			click(By.name(propObjctRepo.getProperty("password_textbox_name")));
			clear(By.name(propObjctRepo.getProperty("password_textbox_name")));
			type(By.name(propObjctRepo.getProperty("password_textbox_name")), propConfig.getProperty("password"));
			System.out.println("Entered valid password");

			
			click(By.xpath(propObjctRepo.getProperty("login_submit_button_xpath")));

			System.out.println("Verified Positive Case- Successfully logged in with the valid user login");


		} catch (Exception e) {
			
			addErrorlogs(e, "Error on submitting userid password details.");
		}

	}
	
	


	
}
