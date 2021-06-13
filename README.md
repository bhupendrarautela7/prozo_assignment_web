# webapp-automation-framework
Web application data driven automation testing framework using the selenium web driver and testNg.
# prozo_assignment

Sample test console report -

[RemoteTestNG] detected TestNG version 7.0.0
Iniating Browser.chrome
==============================================
Test started at :  2021/06/13 14:11:57
==============================================
==============================================
OS Detected : MAC , Browser Launched : Chrome
==============================================
Starting ChromeDriver 91.0.4472.101 (af52a90bf87030dd1523486a1cd3ae25c5d76c9b-refs/branch-heads/4472@{#1462}) on port 37716
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
Jun 13, 2021 2:12:01 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
==================================
Opening : https://swms.prozo.com/auth/login
=====================================
Successfully opened login page.
Jun 13, 2021 2:12:08 PM common.TestBase addlogs
INFO: Element By.name: domain found on page
Element By.name: domain found on page
Verified the prasence of domain name textbox.
Entered domain name value in domain name text box.
Jun 13, 2021 2:12:08 PM common.TestBase addlogs
INFO: Element By.xpath: //div[@id='kt_login']/div/div/main/div/div/form/div[2]/div/button found on page
Element By.xpath: //div[@id='kt_login']/div/div/main/div/div/form/div[2]/div/button found on page
Verified the prasence of domain submit button.
Clicked on the domain name button.
Jun 13, 2021 2:12:09 PM common.TestBase addlogs
INFO: Element By.name: email found on page
Element By.name: email found on page
Verified the prasence of loginid text box.
Jun 13, 2021 2:12:09 PM common.TestBase addlogs
INFO: Element By.name: password found on page
Element By.name: password found on page
Verified the prasence of password textbox.
Jun 13, 2021 2:12:09 PM common.TestBase addlogs
INFO: Element By.xpath: //*[@id="kt_login"]/div/div/main/div/div/form/div[3]/div/button[2] found on page
Element By.xpath: //*[@id="kt_login"]/div/div/main/div/div/form/div[3]/div/button[2] found on page
Verified the prasence of login details submit button.
Entered invalid userid
Entered invalid password
Invalid login password details submitted
Jun 13, 2021 2:12:12 PM common.TestBase addlogs
INFO: Element By.xpath: //*[contains(text(),'Incorrect Password')] found on page
Element By.xpath: //*[contains(text(),'Incorrect Password')] found on page
Verified Negative Case- Shown validation for the invalid user login
Entered valid userid
Entered valid password
Verified Positive Case- Successfully logged in with the valid user login
scrolled to save button
Verified Negative Case- User is not able to submit the blank data.
test SKU id for this test case : SKU010140569
selected brand
selected category
entered SKU ID
entered ean ID
entered UPC ID
entered Min Reorder value
selected HSN
Entered MRP value
Selected unit of mesurement
Entered weight value
Entered length value
Entered breadth value
Entered height value
Entered description value
Clicked GST includeed value
scrolled to save button
clicked to save button
Verified Positive Case - User is able to save the form data with valid inputs.
Searching the added item : SKU010140569
Jun 13, 2021 2:12:40 PM common.TestBase addlogs
INFO: Element By.xpath: //*[@id="kt_content"]/div[2]/div/div[1]/table/tbody[2]/tr/td[1] found on page
Element By.xpath: //*[@id="kt_content"]/div[2]/div/div[1]/table/tbody[2]/tr/td[1] found on page
Found the added item in search result : SKU010140569

===============================================
Suite
Total tests run: 18, Passes: 18, Failures: 0, Skips: 0
===============================================

