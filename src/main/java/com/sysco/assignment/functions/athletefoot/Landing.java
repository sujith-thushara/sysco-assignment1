package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.common.Constants;
import com.sysco.assignment.pages.athletefoot.HomePage;
import com.sysco.assignment.pages.athletefoot.LandingPage;
import com.sysco.assignment.pages.athletefoot.LoginPage;
import com.sysco.assignment.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Landing {

    public static LandingPage landingPage = new LandingPage();

    public static void loadLandingPage() {
        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            landingPage.loadLandingPage(capabilities, Constants.New_APP_URL);
        } else {
            landingPage.loadLandingPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.New_APP_URL);
        }

    }



    public static void navigateToLogin(){
        landingPage.loadLandingPage();
    }


    public static void navigateToLoginPage(){
        landingPage.clickLoginLink();
    }


}
