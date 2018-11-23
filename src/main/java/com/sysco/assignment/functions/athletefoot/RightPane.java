package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.RightPanePage;

public class RightPane {

    public static RightPanePage rightPanePage = new RightPanePage();

    public static boolean verifyItemInShoppingCart(){
        Boolean isMatched = rightPanePage.isItemsMatched();
        return isMatched;

    }




}
