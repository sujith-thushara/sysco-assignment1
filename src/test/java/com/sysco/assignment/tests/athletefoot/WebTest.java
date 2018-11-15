package com.sysco.assignment.tests.athletefoot;

import com.sysco.assignment.data.LoginData;
import com.sysco.assignment.functions.athletefoot.Landing;
import com.sysco.assignment.functions.athletefoot.Login;
import com.sysco.assignment.pages.athletefoot.LandingPage;
import com.sysco.assignment.pages.athletefoot.LoginPage;
import com.sysco.assignment.utils.ExcelUtil;
import com.sysco.assignment.utils.TestBase;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTest extends TestBase {
    Landing landing;
    Login login;


    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test(priority = 1)
    public void validateLoginPage(){
        Landing.loadLandingPage();
        Landing.clickLogin();
        String buttonText = Login.validateLoginBtn();
        Assert.assertEquals(buttonText,"LOGIN","Login Button is not visible");
    }

    @Test (priority = 2)
    public void sucessLogin(){
        Login.validLogin("williamjacob802@gmail.com","0okmNHY6");
    }





}
