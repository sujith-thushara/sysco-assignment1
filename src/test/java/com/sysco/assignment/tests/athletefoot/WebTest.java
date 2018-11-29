package com.sysco.assignment.tests.athletefoot;

import com.sysco.assignment.data.LoginData;
import com.sysco.assignment.functions.athletefoot.*;
import com.sysco.assignment.pages.athletefoot.LandingPage;
import com.sysco.assignment.pages.athletefoot.LoginPage;
import com.sysco.assignment.pages.athletefoot.ShoppingCartPage;
import com.sysco.assignment.utils.BasePage;
import com.sysco.assignment.utils.ExcelUtil;
import com.sysco.assignment.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.ref.PhantomReference;
import java.util.Map;

public class WebTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    BasePage basePage = new BasePage();


    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @AfterMethod
    public void quitBrowser(){
        basePage.quitDriver();
    }

    @Test(priority = 1)
    public void validateLoginPageTest(){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        String buttonText = Login.validateLoginBtn();
        softAssert.assertEquals(buttonText,"LOGIN","Login Button is not visible");
        softAssert.assertAll();

    }

    @Test(priority = 2,dataProvider = "Authentication")
    public void validLoginTest(String email, String password){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser(email,password);
        Home.logout();

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

    @Test(priority = 3,dataProvider = "Authentication")
    public void verifyAccountNameTest(String email, String password){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser(email,password);
        String userName = Home.getUserName();
        softAssert.assertEquals(userName,"WILLIAM JACOB", "Expected User Name Not Found");
        softAssert.assertAll();

    }

    @Test(priority = 4,dataProvider = "Authentication")
    public void removeShoppingCartItemsIdExistsTest(String email, String password){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser(email,password);
        Home.navigateToShoppingCart();
        ShoppingCart.removeIfItemsExistsInCart();

    }

    @Test(priority = 5,dataProvider = "Authentication",dependsOnMethods = { "removeShoppingCartItemsIdExistsTest" })
    public void addProductToCartTest(String email, String password){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser(email,password);
        Home.selectSubMenuAndCategory("Mens","Run");
        Home.selectRandomItem();
        Home.addSelectedItemToCart();
        boolean isMatched = RightPane.verifyItemInShoppingCart();
        softAssert.assertEquals(isMatched,true,"Contents not matched");
        softAssert.assertAll();

    }

    @Test(priority = 6,dataProvider = "Authentication",dependsOnMethods = { "removeShoppingCartItemsIdExistsTest" })
    public void verifyRequiredFieldsTest(String email, String password){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser(email,password);
        Home.selectSubMenuAndCategory("Mens","Run");
        Home.selectRandomItem();
        Home.addSelectedItemToCart();
        boolean isMatched = RightPane.verifyItemInShoppingCart();
        softAssert.assertEquals(isMatched,true,"Contents not matched");
        softAssert.assertAll();
        RightPane.navigateToCheckout();
        SecureCheckout.verifyErrorMessage();

    }

    @Test(priority = 7,dataProvider = "Authentication",dependsOnMethods = { "removeShoppingCartItemsIdExistsTest" })
    public void verifyDeliveryInformationTest(String email, String password){
        Landing.loadLandingPage();
        Landing.navigateToLoginPage();
        Login.loginAsValidUser(email,password);
        Home.selectSubMenuAndCategory("Mens","Run");
        Home.selectRandomItem();
        Home.addSelectedItemToCart();
        boolean isMatched = RightPane.verifyItemInShoppingCart();
        softAssert.assertEquals(isMatched,true,"Contents not matched");
        softAssert.assertAll();
        RightPane.navigateToCheckout();
        SecureCheckout.enterPayementDetails();
        SecureCheckout.selectPostCode("2000", "BARANGAROO New South Wales");
        SecureCheckout.setPhoneNumber("222222222");
        SecureCheckout.navigateToReviewPayments();
        SecureCheckout.selectPaymentType();
        String paymentInfo = SecureCheckout.validatePaymentDetails();
        paymentInfo.contains("william jacob street_1 BARANGAROO, New South Wales 2000 Australia 0222 222 222");
        softAssert.assertAll();


    }

    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {
        return new Object[][] { { "williamjacob802@gmail.com", "0okmNHY6" }};
    }
}
