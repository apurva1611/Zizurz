/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kasai
 */
public class SalesPerson {
    int supplierId;
    List<Order> orders;

    public SalesPerson(int supplierId) {
        this.supplierId = supplierId;
        this.orders = new ArrayList<>();
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
     @Override
    public String toString() {
        return "SalesPerson{" + "id = " + supplierId + ", no. of orders = " + orders.size() + '}';
    }
    
}
