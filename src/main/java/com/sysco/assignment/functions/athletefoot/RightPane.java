package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.RightPanePage;

import java.util.Map;

public class RightPane {

    public static RightPanePage rightPanePage = new RightPanePage();

    public static boolean verifyItemInShoppingCart(){
        Boolean isMatched = rightPanePage.isItemsMatched();
        return isMatched;

    }

    public static void navigateToCheckout(){
        rightPanePage.clickProceedToCheckout();
    }







}
