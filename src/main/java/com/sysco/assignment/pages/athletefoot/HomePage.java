package com.sysco.assignment.pages.athletefoot;

import com.sysco.assignment.utils.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By lnkLogout = By.xpath("//a[text()='Logout']");
    private By txtUserName = By.xpath("//a[text()='My account']/../../li[2]/span/span");
    private By imgShoppingCart = By.xpath("//*[@id=\"header-search\"]/following-sibling::div[3]");

    public LandingPage logout(){
        syscoLabUIOgm.click(lnkLogout);
        return new LandingPage();
    }

    public String getUserName(){
        String userName= syscoLabUIOgm.getText(txtUserName);
        return userName;
    }

    public void clickShoppingCartIcon(){
        syscoLabUIOgm.click(imgShoppingCart);


    }



    public void closeBrowser(){
        syscoLabUIOgm.quit();
    }
}
