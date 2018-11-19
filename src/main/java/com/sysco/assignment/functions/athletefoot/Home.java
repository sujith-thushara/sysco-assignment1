package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.*;

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



    public static void closeBrowser(){
        homePage.quitDriver();

    }

}
