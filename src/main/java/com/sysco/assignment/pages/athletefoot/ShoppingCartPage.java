package com.sysco.assignment.pages.athletefoot;

import com.sysco.assignment.utils.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartPage extends BasePage {


    private By removeItems = By.xpath("//tbody[@class=\"cart item\"]/tr/td/div/a[2]");
    private By btnAddToCart = By.id("product-addtocart-button");
    public Map<String, String> map;


    public  void removeIfItemExists(){
        int i=1;


            List<WebElement> listOfElements = syscoLabUIOgm.getDriver().findElementsByClassName("item-info");

            for (WebElement items:listOfElements){
                items = listOfElements.get(i-1);
                i++;
                syscoLabUIOgm.waitTillElementLoaded((By) removeItems,3000);
                syscoLabUIOgm.click(removeItems);
            }

    }



}
