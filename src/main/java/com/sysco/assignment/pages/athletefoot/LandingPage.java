package com.sysco.assignment.pages.athletefoot;

import com.sysco.assignment.utils.BasePage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    private By lnkLogin = By.xpath("//a[text()='Login']");
    private By lnkLandingPage = By.xpath("//strong[@class='slogan']");


    public void waitForLoginLink(){
        syscoLabUIOgm.waitTillElementLoaded(lnkLogin, 3000);
    }

    public void clickLoginLink(){
        syscoLabUIOgm.click(lnkLogin);
    }

    public void loadLandingPage() {

        if (!syscoLabUIOgm.getCurrentURL().equalsIgnoreCase("https://www.theathletesfoot.com.au/")) {
            syscoLabUIOgm.clickOnVisibleElement(lnkLandingPage);
        }


    }




}
