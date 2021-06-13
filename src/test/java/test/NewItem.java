package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import common.LaunchBrowser;

public class NewItem extends LaunchBrowser {
	
   String testskuid = null;

	@Test(priority = 3)
	public void verify_dashboard_menu() throws Exception {

		try {




			click(By.xpath(propObjctRepo.getProperty("menu_items_xpath")));

			click(By.xpath(propObjctRepo.getProperty("submenu_items_xpath")));




		} catch (Exception e) {
			addErrorlogs(e, "Error on submitting the domain name.");
		}

	}



	@Test(priority = 4)
	public void create_new_item() throws Exception {

		try {



			click(By.xpath(propObjctRepo.getProperty("create_new_item_button_xpath")));



		} catch (Exception e) {
			addErrorlogs(e, "Error on clicking the create new item button");
		}

	}
	
	
	@Test(priority = 5)
	public void check_negative_case_try_to_submit_form_without_data_values() throws Exception {

		try {


			scrolltoElement(By.xpath(propObjctRepo.getProperty("save_button_xpath")));
			System.out.println("scrolled to save button");
			click(By.xpath(propObjctRepo.getProperty("save_button_xpath")));
			System.out.println("Verified Negative Case- User is not able to submit the blank data.");
			scrolltoTop();
			
			


		} catch (Exception e) {
			addErrorlogs(e, "Error on submitting the domain name.");
		}

	}
	
	
	

	
	


	@Test(priority = 6)
	public void fill_form_to_create_new_item() throws Exception {
		
		
		testskuid=propConfig.getProperty("sku_id") + randomNumber();
		System.out.println("test SKU id for this test case : "+ testskuid);

		try {



			click(By.name(propObjctRepo.getProperty("name_textbox_name")));
			clear(By.name(propObjctRepo.getProperty("name_textbox_name")));
			type(By.name(propObjctRepo.getProperty("name_textbox_name")), propConfig.getProperty("item_name"));



			click(By.xpath(propObjctRepo.getProperty("brand_dropdown_xpath")));
			type(By.xpath(propObjctRepo.getProperty("brand_dropdown_xpath")), propConfig.getProperty("brand_name"));
			click(By.xpath(propObjctRepo.getProperty("brand_dropdown_option_xpath")));

			System.out.println("selected brand");


			click(By.xpath(propObjctRepo.getProperty("category_dropdown_xpath")));
			type(By.xpath(propObjctRepo.getProperty("category_dropdown_xpath")),propConfig.getProperty("category_name"));
			click(By.xpath(propObjctRepo.getProperty("category_dropdown_option_xpath")));

			System.out.println("selected category");


			click(By.xpath(propObjctRepo.getProperty("skuid_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("skuid_textbox_xpath")), testskuid);

			System.out.println("entered SKU ID");

			click(By.xpath(propObjctRepo.getProperty("ean_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("ean_textbox_xpath")), propConfig.getProperty("ean_id"));

			System.out.println("entered ean ID");


			click(By.xpath(propObjctRepo.getProperty("upc_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("upc_textbox_xpath")), propConfig.getProperty("upc_id"));

			System.out.println("entered UPC ID");



			click(By.xpath(propObjctRepo.getProperty("minrecodvalue_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("minrecodvalue_textbox_xpath")), propConfig.getProperty("min_reorder_value"));

			System.out.println("entered Min Reorder value");


			click(By.xpath(propObjctRepo.getProperty("hsn_dropDown_xpath")));
			type(By.xpath(propObjctRepo.getProperty("hsn_dropDown_xpath")),propConfig.getProperty("hsn_number_value"));
			click(By.xpath(propObjctRepo.getProperty("hsn_dropdown_option_xpath")));

			System.out.println("selected HSN");		


			click(By.xpath(propObjctRepo.getProperty("mrp_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("mrp_textbox_xpath")), propConfig.getProperty("mrp_value"));

			System.out.println("Entered MRP value");


			click(By.xpath(propObjctRepo.getProperty("uom_dropdown_xpath")));
			type(By.xpath(propObjctRepo.getProperty("uom_dropdown_xpath")),propConfig.getProperty("uom_value"));
			click(By.xpath(propObjctRepo.getProperty("uom_dropdown_option_xpath")));

			System.out.println("Selected unit of mesurement");	


			click(By.xpath(propObjctRepo.getProperty("weight_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("weight_textbox_xpath")), propConfig.getProperty("weight_value"));

			System.out.println("Entered weight value");


			click(By.xpath(propObjctRepo.getProperty("length_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("length_textbox_xpath")), propConfig.getProperty("length_value"));

			System.out.println("Entered length value");

			click(By.xpath(propObjctRepo.getProperty("breadth_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("breadth_textbox_xpath")), propConfig.getProperty("breadth_value"));

			System.out.println("Entered breadth value");

			click(By.xpath(propObjctRepo.getProperty("height_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("height_textbox_xpath")), propConfig.getProperty("height_value"));

			System.out.println("Entered height value");


			click(By.xpath(propObjctRepo.getProperty("description_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("description_textbox_xpath")), propConfig.getProperty("description_text_value"));

			System.out.println("Entered description value");


			click(By.xpath(propObjctRepo.getProperty("gst_button_xpath")));

			System.out.println("Clicked GST includeed value");




		} catch (Exception e) {

			addErrorlogs(e, "Error on submitting the domain name.");

		}

	}
	
	
	@Test(priority = 7)
	public void submit_add_new_item_with_valid_data() throws Exception {

		try {


			scrolltoElement(By.xpath(propObjctRepo.getProperty("save_button_xpath")));
			System.out.println("scrolled to save button");
			click(By.xpath(propObjctRepo.getProperty("save_button_xpath")));
			System.out.println("clicked to save button");
			Thread.sleep(3000);
			scrolltoTop();
			System.out.println("Verified Positive Case - User is able to save the form data with valid inputs.");
			
			
	
		} catch (Exception e) {
			addErrorlogs(e, "Error on submitting the domain name.");
		}

	}
	
	
	@Test(priority = 8)
	public void navigate_item_list_and_search_newly_added_sku_item() throws Exception {

		try {


			click(By.xpath(propObjctRepo.getProperty("submenu_items_xpath")));
			click(By.xpath(propObjctRepo.getProperty("sku_id_search_textbox_xpath")));
			type(By.xpath(propObjctRepo.getProperty("sku_id_search_textbox_xpath")), testskuid);
			enter(By.xpath(propObjctRepo.getProperty("sku_id_search_textbox_xpath")));
			System.out.println("Searching the added item : "+ testskuid);

						
			

		} catch (Exception e) {
			addErrorlogs(e, "Error on submitting the domain name.");
		}

	}
	
	
	@Test(priority = 8)
	public void verify_newly_added_sku_item() throws Exception {

		try {

	
			verifyElement(By.xpath(propObjctRepo.getProperty("sku_table_row_xpath")));
			System.out.println("Found the added item in search result : "+ testskuid);

						

		} catch (Exception e) {
			addErrorlogs(e, "Error on submitting the domain name.");
		}

	}


}
