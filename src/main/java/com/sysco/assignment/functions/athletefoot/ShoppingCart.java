package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.ShoppingCartPage;

import java.util.Map;

public class ShoppingCart {

    public static ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public static void removeIfItemsExistsInCart(){

        shoppingCartPage.removeIfItemExists();
    }

}
