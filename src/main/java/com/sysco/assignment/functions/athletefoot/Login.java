package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.HomePage;
import com.sysco.assignment.pages.athletefoot.LandingPage;
import com.sysco.assignment.pages.athletefoot.LoginPage;

public class Login {
    public static LoginPage loginPage = new LoginPage();
    public static LandingPage landingPage = new LandingPage();

    public static String validateLoginBtn(){
        String btnText= loginPage.getLoginBtnText();
        return btnText;
    }

    public static HomePage validLogin(String email, String password){
        loginPage.setValidCredentials(email, password);
        return new HomePage();
    }
}
