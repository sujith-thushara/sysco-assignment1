package com.sysco.assignment.tests.athletefoot;

import com.sysco.assignment.data.LoginData;
import com.sysco.assignment.functions.athletefoot.Landing;
import com.sysco.assignment.pages.athletefoot.LandingPage;
import com.sysco.assignment.utils.ExcelUtil;
import com.sysco.assignment.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTest extends TestBase {
    Landing landing;


    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void navigateToMyAccountTest(){
        LoginData loginData = ExcelUtil.getLoginData("$as238l");
        landing.loadLandingPage();

    }



}
