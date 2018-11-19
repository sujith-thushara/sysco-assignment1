package com.sysco.assignment.functions.athletefoot;

import com.sysco.assignment.pages.athletefoot.ShoppingCartPage;

public class ShoppingCart {

    public static ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public static void removeIfItemsExistsInCart(){

        shoppingCartPage.removeIfItemExists();
    }
}
