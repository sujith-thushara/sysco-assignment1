package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.HomePage;
import com.sysco.assignment.pages.athletefoot.LandingPage;
import com.sysco.assignment.pages.athletefoot.LoginPage;

public class Login {
    public static LoginPage loginPage = new LoginPage();

    public static String validateLoginBtn(){
        String btnText= loginPage.getLoginBtnText();
        return btnText;
    }

    public static void loginAsValidUser(String email, String password){
        loginPage.setValidCredentials(email, password);
    }

    public static String LoginAsInvalidLogin(String email, String password){
        String errorMessage = loginPage.setInvalidCredentials(email, password);
        return errorMessage;

    }


}
