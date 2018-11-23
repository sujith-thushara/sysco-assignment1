package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.*;

import java.util.Map;

public class Home {

    public static HomePage homePage= new HomePage();
    public static RightPanePage rightPanePage = new RightPanePage();

    public static void logout(){
        homePage.logout();
        //return new LoginPage();
    }

    public static String getUserName(){
        String userName = homePage.getUserName();
        return userName;
    }

    public static void navigateToShoppingCart(){
        homePage.clickShoppingCartIcon();
        rightPanePage.clickViewCart();
        //return new ShoppingCartPage();
    }

    public static void selectSubMenuAndCategory(String subMenu,String category){
        homePage.clickGivenSubMenu(subMenu);
        homePage.clickGivenCategory(category);
    }

    public static void selectRandomItem(){
        homePage.clickOnRandomItem();

    }

    public static void addSelectedItemToCart(){
        homePage.clickAddToCart();
    }



    public static void closeBrowser(){
        homePage.quitDriver();

    }

}
