package com.sysco.assignment.tests.athletefoot;

import com.sysco.assignment.data.LoginData;
import com.sysco.assignment.functions.athletefoot.Home;
import com.sysco.assignment.functions.athletefoot.Landing;
import com.sysco.assignment.functions.athletefoot.Login;
import com.sysco.assignment.functions.athletefoot.ShoppingCart;
import com.sysco.assignment.pages.athletefoot.LandingPage;
import com.sysco.assignment.pages.athletefoot.LoginPage;
import com.sysco.assignment.pages.athletefoot.ShoppingCartPage;
import com.sysco.assignment.utils.ExcelUtil;
import com.sysco.assignment.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    LoginPage loginPage;


    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test(priority = 1)
    public void validateLoginPagetest(){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        String buttonText = Login.validateLoginBtn();
        softAssert.assertEquals(buttonText,"LOGIN","Login Button is not visible");
        softAssert.assertAll();
        Login.closeBrowser();
    }

    @Test(priority = 2)
    public void validLogintest(){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser("williamjacob802@gmail.com","0okmNHY6");
        Home.logout();
        Login.closeBrowser();

    }

//    @Test (priority = 3)
//    public void invalidLogin(){
//        Landing.loadLandingPage();
//        Landing.clickLogin();
//        String errorMessage = Login.invalidLogin("incorrectemail@gmail.com","1234");
//
////        softAssert.assertEquals(errorMessage,"PLEASE ENTER A VALID EMAIL ADDRESS (EX: JOHNDOE@DOMAIN.COM).","Expected Message Not Found");
////        softAssert.assertAll();
//        Login.closeBrowser();
//    }

    @Test(priority = 3)
    public void verifyAccountNametest(){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser("williamjacob802@gmail.com","0okmNHY6");
        String userName = Home.getUserName();
        softAssert.assertEquals(userName,"william  jacob", "Expected User Name Not Found");
        Home.closeBrowser();


    }

    @Test(priority = 4)
    public void removeShoppingCartItemsIdExists(){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser("williamjacob802@gmail.com","0okmNHY6");
        Home.navigateToShoppingCart();
        ShoppingCart.removeIfItemsExistsInCart();
        Home.closeBrowser();

    }






}
