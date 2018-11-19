package com.sysco.assignment.pages.athletefoot;

import com.sysco.assignment.utils.BasePage;
import org.openqa.selenium.By;

public class RightPanePage extends BasePage {

    //private By btnViewCart = By.xpath("//span[text()='View Cart']");
    private By btnViewCart = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[2]/div[1]/div/a");
    //private By btnViewCart = By.xpath("//span[text()='View Cart']/../../");


    public void clickViewCart(){
        String ttt = syscoLabUIOgm.getText(btnViewCart);
        System.out.printf(ttt);
        syscoLabUIOgm.click(btnViewCart);

        //return new ShoppingCartPage();



    }
}
