package com.sysco.assignment.pages.athletefoot;

import com.sysco.assignment.utils.BasePage;
import com.syscolab.qe.core.common.LoggerUtil;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class HomePage extends BasePage {

    private By lnkLogout = By.xpath("//a[text()='Logout']");
    private By txtUserName = By.xpath("//a[text()='My account']/../../li[2]/span/span");
    private By imgShoppingCart = By.xpath("//*[@id=\"header-search\"]/following-sibling::div[3]");
    private By lnkFirstRandomItem = By.xpath("//a[@class='product-item-link']");
    private By lblProductName = By.xpath("//div/h1/span");
    private By lblProductPrice = By.xpath("//div[@class='price-box price-final_price']/span/span/span");
    private By lblSize = By.xpath("//div[@class='swatch-row -active']/div[@class='swatch-option text']");
    private By btnAddToCart = By.id("product-addtocart-button");
    public static String itemPrice;
    public static String itemName;



    public LandingPage logout(){
        syscoLabUIOgm.click(lnkLogout);
        LoggerUtil.logINFO("user logged out");
        return new LandingPage();
    }

    public String getUserName(){
        String userName= syscoLabUIOgm.getText(txtUserName);
        return userName;
    }

    public void clickShoppingCartIcon(){
        syscoLabUIOgm.click(imgShoppingCart);

    }

    public void clickGivenSubMenu(String subMenu){
        String subMenuXpath = "//a[@title="+"'"+subMenu+"']";
        syscoLabUIOgm.waitTillElementLoaded(By.xpath(subMenuXpath)).click();

    }

    public void clickGivenCategory(String category){
        //String categoryXpath ="//a[@title="+"'"+category+"'"+" "+"and"+" "+"@id='mi-3-2-3-1']";
        String categoryXpath ="//*[@id='mi-3-2-3-1']";
        syscoLabUIOgm.waitTillElementLoaded(By.xpath(categoryXpath));
        syscoLabUIOgm.click(By.xpath(categoryXpath));

    }


    public void clickOnRandomItem(){
        syscoLabUIOgm.waitTillElementLoaded(lnkFirstRandomItem);
        syscoLabUIOgm.click(lnkFirstRandomItem);

    }

    public String getProductName(){
        syscoLabUIOgm.waitTillElementLoaded(lblProductName);
        String productName= syscoLabUIOgm.getText(lblProductName);
        return productName;

    }

    public String getProductPrice(){
        syscoLabUIOgm.waitTillElementLoaded(lblProductPrice);
        LoggerUtil.logINFO(("price is: "+syscoLabUIOgm.getText(lblProductPrice)));
        String productPrice=syscoLabUIOgm.getText(lblProductPrice);
        return productPrice;

    }



    public Map<String, String> getProductDetails(){

        syscoLabUIOgm.waitTillElementLoaded(lblProductPrice);
        String productPrice=syscoLabUIOgm.getText(lblProductPrice);

        syscoLabUIOgm.waitTillElementLoaded(lblProductName);
        String productName= syscoLabUIOgm.getText(lblProductName);

        Map<String, String> itemMap=new HashMap<String, String>();



        itemMap.put("price",productPrice);
        itemMap.put("Name",productName);
        System.out.println("Item Name is :" + itemMap.get("Name") + "and the price is" + itemMap.get("price"));
        return itemMap;
    }

    public void clickAddToCart(){

        getProductDetails();
        syscoLabUIOgm.scrollToElement(lblSize);
        syscoLabUIOgm.waitTillElementLoaded(lblSize).click();
        syscoLabUIOgm.waitTillElementLoaded(btnAddToCart).click();

    }


}
