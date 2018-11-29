package com.sysco.assignment.pages.athletefoot;

import com.sun.xml.internal.ws.server.ServerRtException;
import com.sysco.assignment.utils.BasePage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class SecureCheckoutPage extends BasePage {

    private By txtFirstName = By.xpath("(//input[@name='firstname'])[1]");
    private By txtLastName = By.xpath("(//input[@name='lastname'])[1]");
    private By lblErrorMessage = By.xpath("//span[text()='This is a required field.']");
    private By txtStreetAdd1 = By.xpath("//span[text()='Street Address Line 1']/../../div/input");
    private By txtCity = By.xpath("//div[@name='shippingAddress.city']/div/input");
    private By btnContinue = By.xpath("//button[text()='Continue']");
    private By txtPostCode = By.xpath("(//span[text()='Post Code']/../..)[1]/div/input");
    private By txtPhoneNumber = By.xpath("//span[text()='Phone Number']/../../div/input");
    private String txtState = "//a[contains(text(),'STATE')]";
    private By chkCreditCard = By.xpath("//div[@class='payment-method-title field choice']/label/strong");
    private By lblPaymentDetails = By.xpath("//div[@class='billing-address-details']");


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
        syscoLabUIOgm.clear(txtPostCode);
        syscoLabUIOgm.waitTillElementLoaded(txtPostCode);
        syscoLabUIOgm.sendKeys(txtPostCode, postCode);
    }

    public void selectPostCode(String state){
        syscoLabUIOgm.waitTillElementLoaded(By.xpath(txtState.replace("STATE", state)), 5000);
        syscoLabUIOgm.clickOnVisibleElement(By.xpath(txtState.replace("STATE", state)));
    }

    public void setPhoneNumber(String phoneNo){
        syscoLabUIOgm.scrollToElement(txtPhoneNumber);
        syscoLabUIOgm.waitTillElementLoaded(txtPhoneNumber).sendKeys(phoneNo);
    }

    public void clickContinueBtn(){
        syscoLabUIOgm.waitTillElementLoaded(btnContinue).click();

    }

    public void selectPaymentType(){
        syscoLabUIOgm.waitTillElementLoaded(chkCreditCard).click();
    }

    public String getPaymentDetails(){

        String paymentDetails = syscoLabUIOgm.waitTillElementLoaded(lblPaymentDetails).getText();
        System.out.println("printing payement details :"+paymentDetails);
        return paymentDetails;
    }


}
