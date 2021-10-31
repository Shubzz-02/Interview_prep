package com.company.etc.infy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Item {
    private int id, quantity;
    private String name;
    private double price;

    public Item(int id, int quantity, String name, double price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


public class Solution {

    private static Item findItemWithMaximumQuantity(Item[] item) {
        if (item.length == 0)
            return null;
        else {
            Item maxIt = null;
            int max = Integer.MIN_VALUE;
            for (Item i : item) {
                if (i.getQuantity() > max) {
                    max = i.getQuantity();
                    maxIt = i;
                }
            }
            return maxIt;
        }
    }

    private static Item searchItemByQuantity(Item[] items, int quantity) {
        if (items.length == 0)
            return null;
        for (Item i : items) {
            if (i.getQuantity() == quantity)
                return i;
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Item[] items = new Item[t];
        int i = 0;
        while (t-- > 0) {
            items[i++] = new Item(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), br.readLine(), Double.parseDouble(br.readLine()));
        }
        int qt = Integer.parseInt(br.readLine());
        Item max = findItemWithMaximumQuantity(items);
        if (max == null) {
            System.out.println("No Item found with mentioned attribute");
        } else {
            System.out.println("id :- " + max.getId() + "\n" +
                    "quantity :- " + max.getQuantity() + "\n" +
                    "name :- " + max.getName() + "\n" +
                    "price :- " + max.getPrice());
        }

        Item sc = searchItemByQuantity(items, qt);
        if (max == null) {
            System.out.println("No Item found with mentioned attribute");
        } else {
            System.out.println("id :- " + sc.getId() + "\n" +
                    "quantity :- " + sc.getQuantity() + "\n" +
                    "name :- " + sc.getName() + "\n" +
                    "price :- " + sc.getPrice());
        }
    }
}