package com.example.servepoor;

public class Item {
    String donateItem;
    int donateItemImage;

    public Item(String donateItem, int donateItemImage) {
        this.donateItem = donateItem;
        this.donateItemImage = donateItemImage;
    }

    public String getItemName()
    {
        return this.donateItem;
    }

    public int getDonateItemImage()
    {
        return donateItemImage;
    }
}
