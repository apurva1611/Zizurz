/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment5.xerox;

import com.assignment5.analytics.AnalysisHelper;
import com.assignment5.analytics.DataStore;
import com.assignment5.entities.Customer;
import com.assignment5.entities.Item;
import com.assignment5.entities.Order;
import com.assignment5.entities.Product;
import com.assignment5.entities.SalesPerson;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author kasai
 */
public class GateWay {
    private static AnalysisHelper helper;
    public static void main(String args[]) throws IOException{
        helper = new AnalysisHelper();
        DataGenerator generator = DataGenerator.getInstance();
        
        //Below is the sample for how you can use reader. you might wanna 
        //delete it once you understood.
        
        DataReader orderReader = new DataReader(generator.getOrderFilePath());
        String[] orderRow;
        printRow(orderReader.getFileHeader());
        while((orderRow = orderReader.getNextRow()) != null){
            generateData(orderRow);
        }
        System.out.println("_____________________________________________________________");
        DataReader productReader = new DataReader(generator.getProductCataloguePath());
        String[] prodRow;
        printRow(productReader.getFileHeader());
        while((prodRow = productReader.getNextRow()) != null){
            generateProduct(prodRow);
        }
        
        helper.runCode();  
    }
    
    public static void printRow(String[] row){
        for (String row1 : row) {
            System.out.print(row1 + ", ");
        }
        System.out.println("");
    }
    public static void generateData(String[] row){
        int orderId = Integer.parseInt(row[0]);
        int itemId = Integer.parseInt(row[1]);
        int productId = Integer.parseInt(row[2]);
        int quantity = Integer.parseInt(row[3]);
        int salesId = Integer.parseInt(row[4]);
        int customerId = Integer.parseInt(row[5]);
        int salesPricePerProduct = Integer.parseInt(row[6]);
        String marketSegment = row[7];
        // mapping of all orders
        Item item = new Item(productId,salesPricePerProduct,quantity);
        Order o = new Order(orderId,salesId,customerId,item);
        DataStore.getInstance().getOrders().put(orderId, o);
        // mapping of all sales Person
        if(DataStore.getInstance().getSalesPersons().containsKey(salesId)){
            List<Order>  oldOrders= DataStore.getInstance().getSalesPersons().get(salesId).getOrders();
            oldOrders.add(o);  
        }
        else {
            SalesPerson salesPerson = new SalesPerson(salesId);
            salesPerson.getOrders().add(o);
            DataStore.getInstance().getSalesPersons().put(salesId, salesPerson);
        }
        // mapping of all customers 
        if(DataStore.getInstance().getCustomers().containsKey(customerId)){
            List<Order>  oldOrders= DataStore.getInstance().getCustomers().get(customerId).getOrders();
            oldOrders.add(o);  
        }
        else {
            Customer customer = new Customer(customerId);
            customer.getOrders().add(o);
            DataStore.getInstance().getCustomers().put(customerId, customer);
        }
        
    }
    public static void generateProduct(String[] row){
        int productId = Integer.parseInt(row[0]);
        int minPrice = Integer.parseInt(row[1]);
        int maxPrice = Integer.parseInt(row[2]);
        int targetPrice = Integer.parseInt(row[3]);
        Product p = new Product(productId,minPrice,maxPrice,targetPrice);
        DataStore.getInstance().getProducts().put(productId,p);
        
    }
    
}
