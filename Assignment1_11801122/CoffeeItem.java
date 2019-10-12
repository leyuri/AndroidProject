package org.yuri.coffeeapp;

/**
 * Created by user on 2016-08-10.
 */
public class CoffeeItem {

    String name;
    String content;
    int price;
    int resId;

    public CoffeeItem(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public CoffeeItem(String name, String content, int price, int resId) {
        this.name = name;
        this.content = content;
        this.price = price;
        this.resId = resId;
    }

    public int getPrice() {
        return price;
    }

    public void setCoffeprice(int price) {
        this.price = price;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

