package com.sysco.assignment.pages.athletefoot;

import com.sysco.assignment.utils.BasePage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class SecureCheckoutPage extends BasePage {
//
//    private By txtFirstName = By.xpath("//div[@name='shippingAddress.firstname']//input");
//    private By txtLastName = By.xpath("//div[@name='shippingAddress.lastname']//input");

    private By txtFirstName = By.xpath("(//input[@name='firstname'])[1]");
    private By txtLastName = By.xpath("(//input[@name='lastname'])[1]");
    private By lblErrorMessage = By.xpath("//span[text()='This is a required field.']");
    private By btnContinue = By.xpath("//button[text()='Continue']");
    private By txtStreetAdd1 = By.xpath("//span[text()='Street Address Line 1']/../../div/input");
    private By txtCity = By.xpath("//div[@name='shippingAddress.city']/div/input");
    private By drpState = By.xpath("//div[@name='shippingAddress.region_id']/div/select");
    //private By txtPostCode = By.xpath("//div[@name='shippingAddress.postcode']/div/input");
    private By txtPostCode = By.xpath("//span[text()='Post Code']/../../div/input");
    private By drpCountry = By.xpath("//div[@name='shippingAddress.country_id']/div/select");
    private By drpPhoneRegion = By.xpath("//select[@id='localization-select-field']");
    private By txtPhoneNumber = By.xpath("//span[text()='Phone Number']/../../div/input");
    private By txtPostCodeEntry = By.xpath("//a[contains(text(),'0 BARANGAROO New South Wales')]");


    public Map<String,String> getBuyerInfo(){

        syscoLabUIOgm.waitTillElementLoaded(txtFirstName);
        String firstName = syscoLabUIOgm.getText(txtFirstName);
        syscoLabUIOgm.waitTillElementLoaded(txtLastName);
        String lastName =  syscoLabUIOgm.getText(txtLastName);




        Map<String,String>buyerDetails = new HashMap<String, String>();
        buyerDetails.put("FirstName",firstName);
        buyerDetails.put("LastName",lastName);
        System.out.println("First name is :" + buyerDetails.get("FirstName")+ "and last name is :"+ buyerDetails.get("LastName"));
        return buyerDetails;


    }

    public void clickContinueBtn(){
        syscoLabUIOgm.waitTillElementLoaded(btnContinue).click();
    }

    public void getErrorMessage(){
        String errorMessage = syscoLabUIOgm.getText(lblErrorMessage);

    }

    public void enterAddress1(String add1){
        syscoLabUIOgm.sendKeys(txtStreetAdd1,add1);

    }

    public void enterCity(String city){
        syscoLabUIOgm.sendKeys(txtCity, city);
    }

    public void enterPostCode(String postCode){
        syscoLabUIOgm.scrollToElement(txtPostCode);

        syscoLabUIOgm.sendKeys(txtPostCode,postCode);
        syscoLabUIOgm.sleep(5);
        syscoLabUIOgm.waitTillElementLoaded(txtPostCodeEntry);
        syscoLabUIOgm.scrollToElement(txtPostCodeEntry);
        syscoLabUIOgm.clickOnVisibleElement(txtPostCodeEntry);
        //syscoLabUIOgm.click(txtPostCodeEntry);
    }









}
