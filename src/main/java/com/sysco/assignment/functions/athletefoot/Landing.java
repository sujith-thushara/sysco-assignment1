package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.common.Constants;
import com.sysco.assignment.pages.athletefoot.LandingPage;
import com.sysco.assignment.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Landing {

    public static LandingPage landingPage = new LandingPage();

    public static void loadLandingPage(){
        DriverSetUpUtil.setToRunLocally();
        DesiredCapabilities capabilities = null;
        landingPage.loadLoginPage(capabilities, Constants.New_APP_URL);
        //landingPage.clickLogin();

    }


}
