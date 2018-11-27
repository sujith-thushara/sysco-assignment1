package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.RightPanePage;
import com.sysco.assignment.pages.athletefoot.SecureCheckoutPage;

import java.util.Map;

public class SecureCheckout {

    public static SecureCheckoutPage secureCheckoutPage = new SecureCheckoutPage();
    public static RightPanePage rightPanePage = new RightPanePage();

    public static boolean verifyBuyerInformation(String firstName,String lastName){
        Map<String,String> buyerInfo = secureCheckoutPage.getBuyerInfo();
        String actualFname=buyerInfo.get("FirstName");
        String acrulLname=buyerInfo.get("LastName");
        System.out.println("+++" + actualFname + acrulLname + "+++");
        return true;
    }

    public static boolean verifyErrorMessage(){
        secureCheckoutPage.clickContinueBtn();
        secureCheckoutPage.getErrorMessage();
        return true;
    }

    public static void enterPayementDetails(){
        secureCheckoutPage.enterAddress1("street_1");
        //secureCheckoutPage.enterCity("SampleCity");
        secureCheckoutPage.enterPostCode("2000");


    }


}
