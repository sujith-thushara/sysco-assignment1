package com.sysco.assignment.pages.athletefoot;

import com.sysco.assignment.utils.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {


    private By btnLogin = By.id("send2");
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By txtErrorMessage = By.id("email-error");

    public String getLoginBtnText() {
        String buttonText = syscoLabUIOgm.getText(btnLogin);
        return buttonText;

    }

    public void setCredentials(String email, String password){
        syscoLabUIOgm.sendKeys(txtEmail,email);
        syscoLabUIOgm.sendKeys(txtPassword,password);
        syscoLabUIOgm.click(btnLogin);
    }

    public String setInvalidCredentials(String email, String password){
       setCredentials(email,password);
       String errorMessage = syscoLabUIOgm.getText(txtErrorMessage);
       return errorMessage;
    }

    public void setValidCredentials(String email, String password){
        setCredentials(email,password);
        //return new HomePage();


    }





}
