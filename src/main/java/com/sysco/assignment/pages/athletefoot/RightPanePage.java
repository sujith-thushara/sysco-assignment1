package com.sysco.assignment.pages.athletefoot;

import com.sysco.assignment.utils.BasePage;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import java.util.Map;

public class RightPanePage extends BasePage {


    private By btnViewCart = By.xpath("//*[@id=\"minicartOffcanvas\"]/div/div[2]/div[2]/div[1]/div/a");
    private By lblItemCount = By.xpath("//div[@class='minicart-wrapper']/span/span");
    private By lblProductName = By.xpath("//div[@class='minicart-product-details']//a");
    private By imgCart = By.xpath("//div[@class='minicart-wrapper']");
    private By btnProceedToCheckout = By.xpath("//button[@title='Proceed To Checkout']");
    HomePage homePage = new HomePage();


    public void clickViewCart(){

        String className = syscoLabUIOgm.getAttribute(lblItemCount,"class");

        if (className.equals("counter qty")) {
            String ttt = syscoLabUIOgm.getText(btnViewCart);
            syscoLabUIOgm.waitTillElementLoaded(btnViewCart).click();
        }else if (className.equals("counter qty empty")){
            LoggerUtil.logINFO("An Empty Cart !!!");
        }

    }



    public boolean isItemsMatched(){
        Map<String,String>items=homePage.getProductDetails();
        String productName = items.get("Name");
        syscoLabUIOgm.waitTillElementLoaded(imgCart).click();
        String productNameInCart = syscoLabUIOgm.waitTillElementLoaded(lblProductName).getText();

        if (productName.equalsIgnoreCase(productNameInCart)){
            LoggerUtil.logINFO("Search content matched");
            return true;
        }else  {
            return false;
        }

    }


    public void clickProceedToCheckout(){
        syscoLabUIOgm.click(btnProceedToCheckout);
    }

}
