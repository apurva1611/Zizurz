/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.analytics;

import com.assignment5.entities.Order;
import java.util.Map;

/**
 *
 * @author 15085
 */
public class AnalysisHelper {
    public void runCode(){
        Map<Integer,Order> orders = DataStore.getInstance().getOrders();
        for(Integer i:orders.keySet()){
            System.out.println(i);
            System.out.println(orders.get(i).getSupplierId());
        }
        
    }
}
